package org.lut.hyl.weixin.model.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class ResponseTextMessage extends ResponseMessage {
	@XStreamAlias("Content")
	protected String content;

	public ResponseTextMessage() {
		super();
		this.msgType = ResponseMessageType.TEXT;
	}

	public ResponseTextMessage(String toUserName, String fromUserName,
			long createTime, int funcFlag, String content) {
		super();
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType = ResponseMessageType.TEXT;
		this.funcFlag = funcFlag;

		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "TextMsg [content=" + content + ", toUserName=" + toUserName
				+ ", fromUserName=" + fromUserName + ", createTime="
				+ createTime + ", msgType=" + msgType + ", funcFlag="
				+ funcFlag + "]";
	}

}
