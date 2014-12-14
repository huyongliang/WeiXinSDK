package org.lut.hyl.weixin.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.lut.hyl.weixin.exception.UnKnowMessageTypeException;
import org.lut.hyl.weixin.model.request.RequestImageMessage;
import org.lut.hyl.weixin.model.request.RequestLinkMessage;
import org.lut.hyl.weixin.model.request.RequestLocationMessage;
import org.lut.hyl.weixin.model.request.RequestMessage;
import org.lut.hyl.weixin.model.request.RequestTextMessage;
import org.lut.hyl.weixin.model.request.RequestVideoMessage;
import org.lut.hyl.weixin.model.request.RequestVoiceMessage;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 工具类：处理请求中的消息
 * 
 * @author HuYongliang
 *
 */
public class XMLParser {
	private static Map<String, Class<? extends RequestMessage>> map = new HashMap<String, Class<? extends RequestMessage>>();

	static {
		map.put(MessageUtil.REQ_MSG_IMG, RequestImageMessage.class);
		map.put(MessageUtil.REQ_MSG_LINK, RequestLinkMessage.class);
		map.put(MessageUtil.REQ_MSG_LOCATION, RequestLocationMessage.class);
		map.put(MessageUtil.REQ_MSG_TEXT, RequestTextMessage.class);
		map.put(MessageUtil.REQ_MSG_VIDEO, RequestVideoMessage.class);
		map.put(MessageUtil.REQ_MSG_VOICE, RequestVoiceMessage.class);
	}

	public String getXMLStringFromRequest(HttpServletRequest request)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		InputStream is = request.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,
				GlobalProperties.CHARACTER_ENCODING);
		BufferedReader br = new BufferedReader(isr);
		String s = null;
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}
		br.close();
		isr.close();
		is.close();

		return sb.toString();

	}

	public Class<? extends RequestMessage> getMessageType(String strXml)
			throws DocumentException, UnKnowMessageTypeException {
		Document document = DocumentHelper.parseText(strXml);
		// 获得文档的根节点
		Element root = document.getRootElement();
		// 遍历根节点下所有子节点
		Iterator<?> iter = root.elementIterator();
		while (iter.hasNext()) {
			Element ele = (Element) iter.next();
			if (ele.getName().equals("MsgType")) {
				return this.getType(ele.getText().trim());
			}
		}
		return null;
	}

	public RequestMessage parseMessage(HttpServletRequest request)
			throws IOException, UnKnowMessageTypeException, DocumentException {
		return this.parseMessage(this.getXMLStringFromRequest(request));
	}

	public RequestMessage parseMessage(String xml)
			throws UnKnowMessageTypeException, DocumentException {
		XStream xstream = new XStream(new DomDriver());
		Class<? extends RequestMessage> cls = this.getMessageType(xml);
		xstream.processAnnotations(cls);
		return (RequestMessage) xstream.fromXML(xml);

	}

	private Class<? extends RequestMessage> getType(String t)
			throws UnKnowMessageTypeException {
		Class<? extends RequestMessage> clazz = map.get(t);
		if (clazz == null)
			throw new UnKnowMessageTypeException("未知消息类型:" + t);
		return clazz;
	}
}
