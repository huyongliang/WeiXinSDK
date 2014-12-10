package org.lut.hyl.weixin.handler;

import org.lut.hyl.weixin.model.request.RequestMessage.RequestMessageType;

/**
 * ������Ϣ������{@link RequestMessageHandler}���ṩ��
 * 
 * @author HuYongliang
 *
 */
public interface RequestMessageHandlerProvider {
	/**
	 * ���ݴ����������Ϣ���ͷ�����Ӧ�Ĵ�����
	 * 
	 * @param reqMsgType
	 *            {@link RequestMessageType}
	 * @return ���ݴ����������Ϣ���ͷ�����Ӧ�Ĵ�����
	 */
	RequestMessageHandler getHandler(RequestMessageType reqMsgType);
}
