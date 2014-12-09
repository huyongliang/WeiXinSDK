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
	 * ��΢����Ϣ�е�CreateTimeת���ɱ�׼��ʽ��ʱ�䣨yyyy-MM-dd HH:mm:ss��
	 * 
	 * @param createTime
	 *            ��Ϣ����ʱ��
	 * @return
	 */
	public static String formatTime(String createTime) {
		// ��΢�Ŵ����CreateTimeת����long���ͣ��ٳ���1000
		long msgCreateTime = Long.parseLong(createTime) * 1000L;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date(msgCreateTime));
	}

	public static int getByteSize(String content) {
		int size = 0;
		if (null != content) {
			try {
				// ���ֲ���utf-8����ʱռ3���ֽ�
				size = content.getBytes(GlobalProperties.CHARACTER_ENCODING).length;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return size;
	}
}
