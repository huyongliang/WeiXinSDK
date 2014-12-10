package org.lut.hyl.weixin.model.request;

public class RequestImageMessage extends RequestMessage {
	protected String picUrl;
	protected String mediaId;

	public RequestImageMessage() {
		super();
		this.msgType = RequestMessageType.IMG;
	}

	public RequestImageMessage(String toUserName, String fromUserName,
			long createTime, long msgId, String picUrl, String mediaId) {
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType = RequestMessageType.IMG;
		this.msgId = msgId;
		this.picUrl = picUrl;
		this.mediaId = mediaId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public String toString() {
		return "ImageMessage [picUrl=" + picUrl + ", toUserName=" + toUserName
				+ ", fromUserName=" + fromUserName + ", createTime="
				+ createTime + ", msgType=" + msgType + ", msgId=" + msgId
				+ "]";
	}

}
