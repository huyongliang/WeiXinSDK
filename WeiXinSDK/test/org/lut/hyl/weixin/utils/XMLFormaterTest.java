package org.lut.hyl.weixin.utils;

import java.util.Date;

import org.junit.Test;
import org.lut.hyl.weixin.model.response.ResponseMessage;
import org.lut.hyl.weixin.model.response.ResponseTextMessage;

public class XMLFormaterTest {

	@Test
	public void testFormatResponseMessage() {
		ResponseMessage message = new ResponseTextMessage("to", "from",
				new Date().getTime(), 0, "hello");
		System.out.println(new XMLFormater().format(message));
	}

}
