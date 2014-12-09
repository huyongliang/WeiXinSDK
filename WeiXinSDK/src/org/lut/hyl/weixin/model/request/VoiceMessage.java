package org.lut.hyl.weixin.model.request;

public class VoiceMessage extends RequestMessage {
	// √ΩÃÂID
	private String mediaId;
	// ”Ô“Ù∏Ò Ω
	private String format;

	public VoiceMessage() {
		super();
	}

	public VoiceMessage(String toUserName, String fromUserName,
			long createTime, String msgType, long msgId, String mediaId,
			String format) {
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType = msgType;
		this.msgId = msgId;
		this.mediaId = mediaId;
		this.format = format;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return "VoiceMessage [mediaId=" + mediaId + ", format=" + format
				+ ", toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", createTime=" + createTime + ", msgType="
				+ msgType + ", msgId=" + msgId + "]";
	}

}
