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
 * 全局的请求消息处理器
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
	 * 传入请求消息，返回处理后的响应消息{@link ResponseMessage}的具体子类 <h1>
	 * 返回类型的不同并不是由本类控制，而是本类构造方法
	 * {@link RequestProcessor#RequestProcessor(RequestMessageHandlerProvider)}
	 * 中传递的请求消息处理器中的具体处理器决定</h1>
	 * 
	 * @param requestMessage
	 *            {@link RequestMessage}的具体子类
	 * @return {@link ResponseMessage}的具体子类 需要根据实际情况合理地强制转换为具体子类
	 */
	public ResponseMessage doHandle(RequestMessage requestMessage) {
		RequestMessageType type = map.get(requestMessage.getClass());
		RequestMessageHandler h  = this.provider.getHandler(type);
		if (h == null)
			throw new NoRequestMessageHandlerException("请提供处理"
					+ type.getValue() + "类型消息的处理器");
		return h.doHandle(requestMessage);
	}
}
