package org.lut.hyl.weixin.model.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

public abstract class RequestMessage {
	@XStreamAlias("ToUserName")
	protected String toUserName;

	@XStreamAlias("FromUserName")
	protected String fromUserName;

	@XStreamAlias("CreateTime")
	protected Long createTime;

	@XStreamAlias(value = "MsgType")
	@XStreamConverter(value = MessageTypeConverter.class)
	protected RequestMessageType msgType;

	@XStreamAlias("MsgId")
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

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public RequestMessageType getMsgType() {
		return msgType;
	}

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	/**
	 * 请求消息对应的类型
	 * 
	 * @author HuYongliang
	 *
	 */
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

		public static RequestMessageType toEnum(String str) {
			try {
				return Enum.valueOf(RequestMessageType.class, str);
			} catch (Exception ex) {
				for (RequestMessageType period : RequestMessageType.values()) {
					if (period.getValue().equalsIgnoreCase(str)) {
						return period;
					}
				}
				throw new IllegalArgumentException("Cannot convert <" + str
						+ "> to TimePeriod enum");
			}
		}
	}

}
