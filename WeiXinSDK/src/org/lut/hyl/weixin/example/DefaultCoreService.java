package org.lut.hyl.weixin.example;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.lut.hyl.weixin.exception.UnKnowMessageTypeException;
import org.lut.hyl.weixin.handler.RequestMessageHandlerProvider;
import org.lut.hyl.weixin.handler.RequestProcessor;
import org.lut.hyl.weixin.model.request.RequestMessage;
import org.lut.hyl.weixin.model.response.ResponseMessage;
import org.lut.hyl.weixin.utils.GlobalProperties;
import org.lut.hyl.weixin.utils.SignatureUtil;
import org.lut.hyl.weixin.utils.XMLFormater;
import org.lut.hyl.weixin.utils.XMLParser;

/**
 * Ê¹ÓÃÊ¾Àý
 * 
 * @author HuYongliang
 *
 */
public class DefaultCoreService {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private RequestMessageHandlerProvider provider;

	public DefaultCoreService(HttpServletRequest request,
			HttpServletResponse response, RequestMessageHandlerProvider provider) {
		super();
		this.request = request;
		this.response = response;
		this.provider = provider;
	}

	public void service() throws IOException, UnKnowMessageTypeException,
			DocumentException {
		request.setCharacterEncoding(GlobalProperties.CHARACTER_ENCODING);
		response.setCharacterEncoding(GlobalProperties.CHARACTER_ENCODING);
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		OutputStream outputStream = response.getOutputStream();
		if (echostr != null && echostr.length() > 0) {
			if (SignatureUtil.checkSignature(signature, timestamp, nonce)) {
				outputStream.write(echostr
						.getBytes(GlobalProperties.CHARACTER_ENCODING));
			}
		} else {
			XMLParser xmlParser = new XMLParser();
			XMLFormater xmlFormater = new XMLFormater();
			RequestProcessor processor = new RequestProcessor(this.provider);
			RequestMessage requestMessage = xmlParser.parseMessage(request);
			ResponseMessage responseMsg = processor.doHandle(requestMessage);
			String xml = xmlFormater.format(responseMsg);
			outputStream.write(xml
					.getBytes(GlobalProperties.CHARACTER_ENCODING));
		}

		outputStream.flush();
		outputStream.close();
		// outputStream=null;
	}

}
