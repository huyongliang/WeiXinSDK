package org.lut.hyl.weixin.model.request;

public class RequestMessage {
	// ������΢�ź�
	protected String toUserName;
	// ���ͷ��ʺţ�һ��OpenID��
	protected String fromUserName;
	// ��Ϣ����ʱ�� �����ͣ�
	protected long createTime;
	// ��Ϣ���ͣ�text/image/location/link��
	protected String msgType;
	// ��Ϣid��64λ����
	protected long msgId;

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

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

}
