package org.lut.hyl.weixin.model.request;

public abstract class RequestMessage {
	// ������΢�ź�
	protected String toUserName;
	// ���ͷ��ʺţ�һ��OpenID��
	protected String fromUserName;
	// ��Ϣ����ʱ�� �����ͣ�
	protected long createTime;
	// ��Ϣ���ͣ�text/image/location/link��
	protected RequestMessageType msgType;
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

	public RequestMessageType getMsgType() {
		return msgType;
	}

	public void setMsgType(RequestMessageType msgType) {
		this.msgType = msgType;
	}

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	public static enum RequestMessageType {
		/**
		 * �ı���Ϣ
		 */
		TEXT("text"),
		/**
		 * ͼƬ��Ϣ
		 */
		IMG("image"), /**
		 * ������Ϣ
		 */
		VOICE("voice"), /**
		 * ��Ƶ��Ϣ
		 */
		VIDEO("video"), /**
		 * λ����Ϣ
		 */
		LOCATION("location"), /**
		 * ������Ϣ
		 */
		LINK("link");
		private RequestMessageType(String v) {
			this.value = v;
		}

		private String value;

		public String getValue() {
			return value;
		}
	}

}
