package org.lut.hyl.weixin.model.request;

public abstract class RequestMessage {
	// 开发者微信号
	protected String toUserName;
	// 发送方帐号（一个OpenID）
	protected String fromUserName;
	// 消息创建时间 （整型）
	protected long createTime;
	// 消息类型（text/image/location/link）
	protected RequestMessageType msgType;
	// 消息id，64位整型
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
		 * 文本消息
		 */
		TEXT("text"),
		/**
		 * 图片消息
		 */
		IMG("image"), /**
		 * 语音消息
		 */
		VOICE("voice"), /**
		 * 视频消息
		 */
		VIDEO("video"), /**
		 * 位置消息
		 */
		LOCATION("location"), /**
		 * 链接消息
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
