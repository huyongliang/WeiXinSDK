package org.lut.hyl.weixin.model.request;

public class RequestLocationMessage extends RequestMessage {
	protected String location_X;
	// ����λ�þ���
	protected String location_Y;
	// ��ͼ���Ŵ�С
	protected String scale;
	// ����λ����Ϣ
	protected String label;

	public RequestLocationMessage() {
		super();
		this.msgType=RequestMessageType.LOCATION;
	}

	public RequestLocationMessage(String toUserName, String fromUserName,
			long createTime,   long msgId, String location_X,
			String location_Y, String scale, String label) {
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType=RequestMessageType.LOCATION;
		this.msgId = msgId;

		this.location_X = location_X;
		this.location_Y = location_Y;
		this.scale = scale;
		this.label = label;
	}

	public String getLocation_X() {
		return location_X;
	}

	public void setLocation_X(String location_X) {
		this.location_X = location_X;
	}

	public String getLocation_Y() {
		return location_Y;
	}

	public void setLocation_Y(String location_Y) {
		this.location_Y = location_Y;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "LocationMessage [location_X=" + location_X + ", location_Y="
				+ location_Y + ", scale=" + scale + ", label=" + label
				+ ", toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", createTime=" + createTime + ", msgType="
				+ msgType + ", msgId=" + msgId + "]";
	}

}
