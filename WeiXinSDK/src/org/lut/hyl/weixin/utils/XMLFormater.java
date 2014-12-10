package org.lut.hyl.weixin.utils;

import java.util.Date;

import org.lut.hyl.weixin.model.response.ResponseMessage;
import org.lut.hyl.weixin.model.response.ResponseNewsMessage;
import org.lut.hyl.weixin.model.response.ResponseNewsMessage.Article;
import org.lut.hyl.weixin.model.response.ResponseTextMessage;

/**
 * 工具类：将ResponseMessage根据{@link ResponseMessage#getMsgType()}转换为对应的xml格式字符串
 * 
 * @author HuYongliang
 *
 */
public class XMLFormater {
	private String getCommonTags(ResponseMessage baseMsg,
			boolean alredyReverseFromAnTo) {
		StringBuffer sb = new StringBuffer();
		Date date = new Date();
		String from = alredyReverseFromAnTo ? baseMsg.getFromUserName()
				: baseMsg.getToUserName();
		String to = alredyReverseFromAnTo ? baseMsg.getToUserName() : baseMsg
				.getFromUserName();
		sb.append("<ToUserName><![CDATA[");
		sb.append(to);
		sb.append("]]></ToUserName>\n<FromUserName><![CDATA[");
		sb.append(from);
		sb.append("]]></FromUserName>\n<CreateTime>");
		sb.append(date.getTime());
		sb.append("</CreateTime>\n");
		return sb.toString();
	}

	public String format(ResponseMessage baseMsg, boolean alredyReverseFromAnTo)
			throws UnsupportedOperationException {
		StringBuffer sb = new StringBuffer("<xml>\n");
		sb.append(this.getCommonTags(baseMsg, alredyReverseFromAnTo));
		String special = this.getSpecialTags(baseMsg);
		if (special == null)
			throw new UnsupportedOperationException("暂不支持的操作,消息类型："
					+ baseMsg.getMsgType());
		sb.append(this.getSpecialTags(baseMsg));
		sb.append("<FuncFlag>0</FuncFlag>\n</xml>");
		return sb.toString();
	}

	private String getSpecialTags(ResponseMessage responseMsg) {
		StringBuilder sb = new StringBuilder();
		switch (responseMsg.getMsgType()) {
		case TEXT: {
			ResponseTextMessage msg = (ResponseTextMessage) responseMsg;
			sb.append("<MsgType><![CDATA[text]]></MsgType>\n");
			sb.append("<Content><![CDATA[" + msg.getContent() + "]]></Content>\n");
			break;
		}
		case NEWS: {
			ResponseNewsMessage msg = (ResponseNewsMessage) responseMsg;
			sb.append("<MsgType><![CDATA[news]]></MsgType>");
			sb.append("<ArticleCount>" + msg.getArticleCount()
					+ "</ArticleCount>");
			sb.append("<Articles>");
			for (Article a : msg.getArticles()) {
				sb.append("<item>");
				sb.append("<Title><![CDATA[" + a.getTitle() + "]]></Title> ");
				sb.append("<Description><![CDATA[" + a.getDescription()
						+ "]]></Description>");
				sb.append("<PicUrl><![CDATA[" + a.getPicUrl() + "]]></PicUrl>");
				sb.append("<Url><![CDATA[" + a.getUrl() + "]]></Url>");
				sb.append("</item>");
			}
			sb.append("</Articles>");
			break;
		}
		default:
			return null;
		}

		return sb.toString();
	}

	public String format(ResponseMessage baseMsg)
			throws UnsupportedOperationException {
		return this.format(baseMsg, true);
	}
	/*
	 * if (responseMsg instanceof ResponseTextMessage) { ResponseTextMessage msg
	 * = (ResponseTextMessage) responseMsg;
	 * sb.append("<MsgType><![CDATA[text]]></MsgType>");
	 * sb.append("<Content><![CDATA[" + msg.getContent() + "]]></Content>"); }
	 * else if (responseMsg instanceof ResponseNewsMessage) {
	 * ResponseNewsMessage msg = (ResponseNewsMessage) responseMsg;
	 * sb.append("<MsgType><![CDATA[news]]></MsgType>");
	 * sb.append("<ArticleCount>" + msg.getArticleCount() + "</ArticleCount>");
	 * sb.append("<Articles>"); for (Article a : msg.getArticles()) {
	 * sb.append("<item>"); sb.append("<Title><![CDATA[" + a.getTitle() +
	 * "]]></Title> "); sb.append("<Description><![CDATA[" + a.getDescription()
	 * + "]]></Description>"); sb.append("<PicUrl><![CDATA[" + a.getPicUrl() +
	 * "]]></PicUrl>"); sb.append("<Url><![CDATA[" + a.getUrl() + "]]></Url>");
	 * sb.append("</item>"); } sb.append("</Articles>"); }
	 */

}
