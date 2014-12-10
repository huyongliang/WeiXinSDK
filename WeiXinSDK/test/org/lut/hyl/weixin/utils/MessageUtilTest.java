package org.lut.hyl.weixin.utils;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class MessageUtilTest {

	@Test
	public void testFormatTime() {
	}

	@Test
	public void testGetByteSize() throws UnsupportedEncodingException {
		this.testUTF8();
		this.testGBK();
	}

	private void testGBK() throws UnsupportedEncodingException {
		System.out.println("GBK==========");
		String s = new String("这是汉字".getBytes(), "GBK");
		System.out.println(s + "--byteSize:" + s.getBytes("GBK").length);
		System.out.println(s + "--length:" + s.length());
		s = "this is a string";
		System.out.println(s + "--byteSize:" + s.getBytes("GBK").length);
		System.out.println(s + "--length:" + s.length());
		System.out.println("GBK==========");

	}

	private void testUTF8() {
		System.out.println("UTF-8==========");
		String s = "这是汉字";
		System.out.println(s + "--byteSize:" + MessageUtil.getByteSize(s));
		System.out.println(s + "--length:" + s.length());
		s = "this is a string";
		System.out.println(s + "--byteSize:" + MessageUtil.getByteSize(s));
		System.out.println(s + "--length:" + s.length());
		System.out.println("UTF-8==========");

	}

	@Test
	public void testShrint2fit() throws UnsupportedEncodingException {
		String s = "你好吗？这是";
		System.out.println(new MessageUtil().shrint2fit(s, "UTF-8", 6));
		System.out.println(new MessageUtil().shrint2fit(s, "GBK", 6));
		System.out.println(new MessageUtil().shrint2fit(s, "GB2312", 6));
	}

}
