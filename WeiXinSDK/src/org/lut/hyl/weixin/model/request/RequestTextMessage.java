package org.lut.hyl.weixin.model.request;

public class RequestTextMessage extends RequestMessage {
	// ÏûÏ¢ÄÚÈÝ
	protected String content;

	public RequestTextMessage() {
		super();
		this.msgType=RequestMessageType.TEXT;
	}

	public RequestTextMessage(String toUserName, String fromUserName, long createTime,
			long msgId, String content) {
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType=RequestMessageType.TEXT;
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
