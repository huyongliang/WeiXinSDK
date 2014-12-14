package org.lut.hyl.weixin.model.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class RequestVoiceMessage extends RequestMessage {
	// √ΩÃÂID
	@XStreamAlias("MediaId")
	protected String mediaId;
	// ”Ô“Ù∏Ò Ω
	@XStreamAlias("Format")
	protected String format;

	@XStreamAlias("Recognition")
	protected String recognition;

	public RequestVoiceMessage() {
		super();
		this.msgType = RequestMessageType.VOICE;
	}

	public RequestVoiceMessage(String toUserName, String fromUserName,
			long createTime, long msgId, String mediaId, String format) {
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType = RequestMessageType.VOICE;
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

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

	@Override
	public String toString() {
		return "RequestVoiceMessage [mediaId=" + mediaId + ", format=" + format
				+ ", recognition=" + recognition + "]";
	}

}
