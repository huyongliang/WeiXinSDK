package org.lut.hyl.weixin.utils;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	/**
	 * 微信支持的最大长度为2048bytes，此方法将字节数大于2048的后续部分去掉
	 * 
	 * @param content
	 *            需要检测的字符串
	 * @param encoding
	 *            使用的编码类型
	 * @param maxLengthOfBytes
	 *            支持的最大字节长度，如2048
	 * @return 过滤后的字符串
	 * @throws UnsupportedEncodingException
	 */
	public String shrint2fit(String content, String encoding,
			int maxLengthOfBytes) throws UnsupportedEncodingException {
		if (content == null || "".equals(content))
			return content;
		int lengthPerChar = 2;
		if ("UTF-8".equalsIgnoreCase(encoding)) {
			lengthPerChar = 3;
		} else if ("GBK".equalsIgnoreCase(encoding)
				|| "gb2312".equalsIgnoreCase(encoding)) {
			lengthPerChar = 2;
		}
		int l = content.getBytes(encoding).length;
		if (l >= maxLengthOfBytes) {
			int max = maxLengthOfBytes / lengthPerChar;
			content = content.substring(0, max);
		}
		return content;
	}
}
