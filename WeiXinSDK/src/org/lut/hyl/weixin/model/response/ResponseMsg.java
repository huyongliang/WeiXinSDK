package org.lut.hyl.weixin.model.response;

public class ResponseMsg {
	protected String toUserName;
	// ������΢�ź�
	protected String fromUserName;
	// ��Ϣ����ʱ�� �����ͣ�
	protected long createTime;
	// ��Ϣ���ͣ�text/music/news��
	protected String msgType;
	// λ0x0001����־ʱ���Ǳ���յ�����Ϣ
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
