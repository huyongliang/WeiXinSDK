package org.lut.hyl.weixin.model.response;

public enum RESP_MSG_TYPE {
	TEXT("text"), IMG("image"), VOICE("voice"), VIDEO("video"), MUSIC("music"), NEWS(
			"news");
	private RESP_MSG_TYPE(String v) {
		this.value = v;
	}

	private String value;

	public String getValue() {
		return value;
	}
}
