package org.lut.hyl.weixin.utils;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.lut.hyl.weixin.GlobalProperties;

public class MessageUtil {
	public static final String REQ_MSG_TEXT = "text";
	public static final String REQ_MSG_LINK = "link";
	public static final String REQ_MSG_IMG = "image";
	public static final String REQ_MSG_VOICE = "voice";
	public static final String REQ_MSG_VIDEO = "video";
	public static final String REQ_MSG_LOCATION = "location";

	/**
	 * 将微信消息中的CreateTime转换成标准格式的时间（yyyy-MM-dd HH:mm:ss）
	 * 
	 * @param createTime
	 *            消息创建时间
	 * @return
	 */
	public static String formatTime(String createTime) {
		// 将微信传入的CreateTime转换成long类型，再乘以1000
		long msgCreateTime = Long.parseLong(createTime) * 1000L;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date(msgCreateTime));
	}

	public static int getByteSize(String content) {
		int size = 0;
		if (null != content) {
			try {
				// 汉字采用utf-8编码时占3个字节
				size = content.getBytes(GlobalProperties.CHARACTER_ENCODING).length;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return size;
	}
}
