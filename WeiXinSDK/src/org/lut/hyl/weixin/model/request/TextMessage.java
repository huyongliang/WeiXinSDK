package org.lut.hyl.weixin.model.request;

public class TextMessage extends RequestMessage {
	// ÏûÏ¢ÄÚÈÝ
	private String content;

	public TextMessage() {
		super();
	}

	public TextMessage(String toUserName, String fromUserName, long createTime,
			String msgType, long msgId, String content) {
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
