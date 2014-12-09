package org.lut.hyl.weixin.model.response;

public abstract class ResponseMessage {
	protected String toUserName;
	protected String fromUserName;
	protected long createTime;
	protected ResponseMessageType msgType;
	protected int funcFlag;

	public ResponseMessage() {
		super();
	}

	public ResponseMessage(String toUserName, String fromUserName,
			long createTime, ResponseMessageType msgType, int funcFlag) {
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

	public ResponseMessageType getMsgType() {
		return msgType;
	}

	public void setMsgType(ResponseMessageType msgType) {
		this.msgType = msgType;
	}

	public int getFuncFlag() {
		return funcFlag;
	}

	public void setFuncFlag(int funcFlag) {
		this.funcFlag = funcFlag;
	}

	public static enum ResponseMessageType {
		/**
		 * Œƒ±æ
		 */
		TEXT("text"), /**
		 * Õº∆¨
		 */
		IMG("image"), /**
		 * ”Ô“Ù
		 */
		VOICE("voice"), /**
		 *  ”∆µ
		 */
		VIDEO("video"), /**
		 * “Ù¿÷
		 */
		MUSIC("music"), /**
		 * ÕºŒƒ
		 */
		NEWS("news");
		private ResponseMessageType(String v) {
			this.value = v;
		}

		private String value;

		public String getValue() {
			return value;
		}
	}
}
