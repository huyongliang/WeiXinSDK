package org.lut.hyl.weixin.utils;

import org.dom4j.DocumentException;
import org.junit.Test;
import org.lut.hyl.weixin.exception.UnKnowMessageTypeException;
import org.lut.hyl.weixin.model.request.RequestMessage;

public class XMLParserTest {

	private XMLParser parser;
	{
		this.parser = new XMLParser();
	}

	@Test
	public void testGetMessageType() throws UnKnowMessageTypeException,
			DocumentException {
		System.out.println(parser.getMessageType(this.getInputXML()));
	}

	@Test
	public void testParseMessageString() throws UnKnowMessageTypeException,
			DocumentException {
		RequestMessage m = parser.parseMessage(getInputXML());
		System.out.println(m);
	}

	public String getInputXML() {
		String ret = "<xml><ToUserName><![CDATA[gh_009e11640155]]></ToUserName>"
				+ "<FromUserName><![CDATA[oUZort7B1-Yp4SNuakicIRX8ctto]]></FromUserName>"
				+ "	<CreateTime>1417280280</CreateTime>"
				+ "	<MsgType><![CDATA[text]]></MsgType>"
				+ "	<Content><![CDATA[12270207]]></Content>"
				+ "	<MsgId>6087172452067160585</MsgId></xml>";
		return ret;
	}

}
