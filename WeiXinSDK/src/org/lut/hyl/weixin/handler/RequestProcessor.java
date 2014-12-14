package org.lut.hyl.weixin.handler;

import java.util.HashMap;
import java.util.Map;

import org.lut.hyl.weixin.exception.NoRequestMessageHandlerException;
import org.lut.hyl.weixin.model.request.RequestImageMessage;
import org.lut.hyl.weixin.model.request.RequestLinkMessage;
import org.lut.hyl.weixin.model.request.RequestLocationMessage;
import org.lut.hyl.weixin.model.request.RequestMessage;
import org.lut.hyl.weixin.model.request.RequestMessage.RequestMessageType;
import org.lut.hyl.weixin.model.request.RequestTextMessage;
import org.lut.hyl.weixin.model.request.RequestVideoMessage;
import org.lut.hyl.weixin.model.request.RequestVoiceMessage;
import org.lut.hyl.weixin.model.response.ResponseMessage;

/**
 * ȫ�ֵ�������Ϣ������
 * 
 * @author HuYongliang
 *
 */
public class RequestProcessor {
	private RequestMessageHandlerProvider provider;
	private static Map<Class<? extends RequestMessage>, RequestMessageType> map;
	static {
		map = new HashMap<Class<? extends RequestMessage>, RequestMessageType>();
		map.put(RequestTextMessage.class, RequestMessageType.TEXT);
		map.put(RequestImageMessage.class, RequestMessageType.IMG);
		map.put(RequestLinkMessage.class, RequestMessageType.LINK);
		map.put(RequestLocationMessage.class, RequestMessageType.LOCATION);
		map.put(RequestVideoMessage.class, RequestMessageType.VIDEO);
		map.put(RequestVoiceMessage.class, RequestMessageType.VOICE);
	}

	public RequestProcessor(RequestMessageHandlerProvider provider) {
		super();
		this.provider = provider;
	}

	/**
	 * ����������Ϣ�����ش�������Ӧ��Ϣ{@link ResponseMessage}�ľ������� <h1>
	 * �������͵Ĳ�ͬ�������ɱ�����ƣ����Ǳ��๹�췽��
	 * {@link RequestProcessor#RequestProcessor(RequestMessageHandlerProvider)}
	 * �д��ݵ�������Ϣ�������еľ��崦��������</h1>
	 * 
	 * @param requestMessage
	 *            {@link RequestMessage}�ľ�������
	 * @return {@link ResponseMessage}�ľ������� ��Ҫ����ʵ����������ǿ��ת��Ϊ��������
	 */
	public ResponseMessage doHandle(RequestMessage requestMessage) {
		RequestMessageType type = map.get(requestMessage.getClass());
		RequestMessageHandler h  = this.provider.getHandler(type);
		if (h == null)
			throw new NoRequestMessageHandlerException("���ṩ����"
					+ type.getValue() + "������Ϣ�Ĵ�����");
		return h.doHandle(requestMessage);
	}
}
