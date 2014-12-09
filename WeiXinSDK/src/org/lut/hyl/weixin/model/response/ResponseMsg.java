package org.lut.hyl.weixin.model.response;

public class ResponseMsg {
	protected String toUserName;
	// 开发者微信号
	protected String fromUserName;
	// 消息创建时间 （整型）
	protected long createTime;
	// 消息类型（text/music/news）
	protected String msgType;
	// 位0x0001被标志时，星标刚收到的消息
	protected int funcFlag;

	public ResponseMsg() {
		super();
	}

	public ResponseMsg(String toUserName, String fromUserName, long createTime,
			String msgType, int funcFlag) {
		super();
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType = msgType;
		this.funcFlag = funcFlag;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public int getFuncFlag() {
		return funcFlag;
	}

	public void setFuncFlag(int funcFlag) {
		this.funcFlag = funcFlag;
	}

}
