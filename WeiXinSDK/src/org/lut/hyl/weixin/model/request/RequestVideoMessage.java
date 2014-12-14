package org.lut.hyl.weixin.model.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class RequestVideoMessage extends RequestMessage {
	@XStreamAlias("ThumbMediaId")
	protected String thumbMediaId;
	@XStreamAlias("MediaId")
	protected String mediaId;

	public RequestVideoMessage() {
		super();
		this.msgType=RequestMessageType.VIDEO;
	}

	public RequestVideoMessage(String toUserName, String fromUserName,
			long createTime, long msgId, String thumbMediaId,
			String mediaId) {
		super();
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType = RequestMessageType.VIDEO;
		this.msgId = msgId;
		this.thumbMediaId = thumbMediaId;
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public String toString() {
		return "VideoMessage [thumbMediaId=" + thumbMediaId + ", mediaId="
				+ mediaId + ", toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", createTime=" + createTime + ", msgType="
				+ msgType + ", msgId=" + msgId + "]";
	}

}
