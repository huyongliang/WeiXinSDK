package org.lut.hyl.weixin.model.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class RequestLinkMessage extends RequestMessage {
	// 消息标题
	@XStreamAlias("Title")
	protected String title;
	// 消息描述
	@XStreamAlias("Description")
	protected String description;
	// 消息链接
	@XStreamAlias("Url")
	protected String url;

	public RequestLinkMessage() {
		super();
		this.msgType=RequestMessageType.LINK;
	}

	public RequestLinkMessage(String toUserName, String fromUserName, long createTime,
			  long msgId, String title, String description,
			String url) {
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType=RequestMessageType.LINK;
		this.msgId = msgId;

		this.title = title;
		this.description = description;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "LinkMessage [title=" + title + ", description=" + description
				+ ", url=" + url + ", toUserName=" + toUserName
				+ ", fromUserName=" + fromUserName + ", createTime="
				+ createTime + ", msgType=" + msgType + ", msgId=" + msgId
				+ "]";
	}

}
