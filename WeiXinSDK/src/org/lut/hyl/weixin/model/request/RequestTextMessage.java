package org.lut.hyl.weixin.model.request;

public class RequestTextMessage extends RequestMessage {
	// ÏûÏ¢ÄÚÈÝ
	protected String content;

	public RequestTextMessage() {
		super();
	}

	public RequestTextMessage(String toUserName, String fromUserName, long createTime,
			RequestMessageType msgType, long msgId, String content) {
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType = msgType;
		this.msgId = msgId;
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
		return "TextMessage [content=" + content + ", toUserName=" + toUserName
				+ ", fromUserName=" + fromUserName + "\n, createTime="
				+ createTime + ", msgType=" + msgType + ",\n msgId=" + msgId
				+ "]";
	}
}
