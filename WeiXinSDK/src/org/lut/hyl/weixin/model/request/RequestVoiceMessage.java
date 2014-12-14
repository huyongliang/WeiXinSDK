package org.lut.hyl.weixin.model.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class RequestVoiceMessage extends RequestMessage {
	// ý��ID
	@XStreamAlias("MediaId")
	protected String mediaId;
	// ������ʽ
	@XStreamAlias("Format")
	protected String format;

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

	@Override
	public String toString() {
		return "VoiceMessage [mediaId=" + mediaId + ", format=" + format
				+ ", toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", createTime=" + createTime + ", msgType="
				+ msgType + ", msgId=" + msgId + "]";
	}

}
