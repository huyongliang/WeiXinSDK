package org.lut.hyl.weixin.model.response;

public class TextMsg extends ResponseMsg {
	private String content;

	public TextMsg() {
		super();
	}

	public TextMsg(String toUserName, String fromUserName, long createTime,
			String msgType, int funcFlag, String content) {
		super();
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType = msgType;
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
