package org.lut.hyl.weixin.handler;

import org.lut.hyl.weixin.model.request.RequestMessage.RequestMessageType;

/**
 * 请求消息处理器{@link RequestMessageHandler}的提供者
 * 
 * @author HuYongliang
 *
 */
public interface RequestMessageHandlerProvider {
	/**
	 * 根据传入的请求消息类型返回相应的处理器
	 * 
	 * @param reqMsgType
	 *            {@link RequestMessageType}
	 * @return 根据传入的请求消息类型返回相应的处理器
	 */
	RequestMessageHandler getHandler(RequestMessageType reqMsgType);
}
