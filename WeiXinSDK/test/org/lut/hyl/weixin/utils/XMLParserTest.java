package org.lut.hyl.weixin.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import org.dom4j.DocumentException;
import org.junit.Test;
import org.lut.hyl.weixin.exception.UnKnowMessageTypeException;
import org.lut.hyl.weixin.model.request.RequestMessage;
import org.lut.hyl.weixin.model.request.RequestTextMessage;

public class XMLParserTest {

	private XMLParser parser;
	{
		this.parser = new XMLParser();
	}

	@Test
	public void testGetMessageType() throws UnKnowMessageTypeException,
			DocumentException, UnsupportedEncodingException {
		System.out.println(parser.getMessageType(this.getInputXML()));
	}

	@Test
	public void testParseMessageString() throws UnKnowMessageTypeException,
			DocumentException, NoSuchMethodException, SecurityException,
			IllegalArgumentException, InvocationTargetException,
			UnsupportedEncodingException {
		RequestMessage m = parser.parseMessage(getInputXML());
		System.out.println(m);
	}
	
	/*@Test
	public void testParseMessageString1() throws UnKnowMessageTypeException, DocumentException{
		System.out.println(this.parser.parseMessage(getInputXML(), RequestTextMessage.class));
	}*/

	public String getInputXML() {
		String ret = "<xml><ToUserName><![CDATA[gh_009e11640155]]></ToUserName>"
				+ "<FromUserName><![CDATA[oUZort7B1-Yp4SNuakicIRX8ctto]]></FromUserName>"
				+ "	<CreateTime>1417280280</CreateTime>"
				+ "	<MsgType><![CDATA[text]]></MsgType>"
				+ "	<Content><![CDATA[12270207]]></Content>"
				+ "	<MsgId>6087172452067160585</MsgId></xml>";
		return ret;
	}

	@Test
	public void testToBean() throws UnKnowMessageTypeException,
			DocumentException {
		System.out.println(this.parser.parseMessage(getInputXML()));
	}
}
