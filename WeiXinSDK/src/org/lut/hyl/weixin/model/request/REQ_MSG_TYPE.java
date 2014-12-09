package org.lut.hyl.weixin.model.request;

public enum REQ_MSG_TYPE {
	TEXT("text"), IMG("image"), VOICE("voice"), VIDEO("video"), LOCATION(
			"location"), LINK("link");
	private REQ_MSG_TYPE(String v) {
		this.value = v;
	}

	private String value;

	public String getValue() {
		return value;
	}
}
