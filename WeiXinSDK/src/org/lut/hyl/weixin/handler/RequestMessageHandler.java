package org.lut.hyl.weixin.handler;

import org.lut.hyl.weixin.model.request.RequestMessage;
import org.lut.hyl.weixin.model.response.ResponseMessage;

/**
 * 请求消息处理器
 * 
 * @author HuYongliang
 *
 */
public interface RequestMessageHandler {
	ResponseMessage doHandle(RequestMessage requestMessage);
}
