package org.lut.hyl.weixin.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.lut.hyl.weixin.GlobalProperties;
import org.lut.hyl.weixin.exception.UnKnowMessageTypeException;
import org.lut.hyl.weixin.model.request.RequestImageMessage;
import org.lut.hyl.weixin.model.request.RequestLinkMessage;
import org.lut.hyl.weixin.model.request.RequestLocationMessage;
import org.lut.hyl.weixin.model.request.RequestMessage;
import org.lut.hyl.weixin.model.request.RequestTextMessage;
import org.lut.hyl.weixin.model.request.RequestVideoMessage;
import org.lut.hyl.weixin.model.request.RequestVoiceMessage;

public class XMLParser {
	private static Map<String, Class<? extends RequestMessage>> map = new HashMap<String, Class<? extends RequestMessage>>();

	static {
		map.put(MessageUtil.REQ_MSG_IMG, RequestImageMessage.class);
		map.put(MessageUtil.REQ_MSG_LINK, RequestLinkMessage.class);
		map.put(MessageUtil.REQ_MSG_LOCATION, RequestLocationMessage.class);
		map.put(MessageUtil.REQ_MSG_TEXT, RequestTextMessage.class);
		map.put(MessageUtil.REQ_MSG_VIDEO, RequestVideoMessage.class);
		map.put(MessageUtil.REQ_MSG_VOICE, RequestVoiceMessage.class);
	}

	public String getXMLFromRequest(HttpServletRequest request)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		InputStream is = request.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,
				GlobalProperties.CHARACTER_ENCODING);
		BufferedReader br = new BufferedReader(isr);
		String s = null;
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}

		return sb.toString();

	}

	public Class<? extends RequestMessage> getMessageType(String strXml)
			throws DocumentException, UnKnowMessageTypeException {
		Document document = DocumentHelper.parseText(strXml);
		// 获得文档的根节点
		Element root = document.getRootElement();
		// 遍历根节点下所有子节点
		Iterator<?> iter = root.elementIterator();
		while (iter.hasNext()) {
			Element ele = (Element) iter.next();
			if (ele.getName().equals("MsgType")) {
				return this.getType(ele.getText().trim());
			}
		}
		return null;
	}

	public RequestMessage parseMessage(HttpServletRequest request)
			throws IOException, UnKnowMessageTypeException {
		return this.parseMessage(this.getXMLFromRequest(request));
	}

	public RequestMessage parseMessage(String xml)
			throws UnKnowMessageTypeException {
		RequestMessage ret = null;
		try {
			Class<?> c = getMessageType(xml);
			ret = (RequestMessage) c.newInstance();
			Document document = DocumentHelper.parseText(xml);
			// 获得文档的根节点
			Element root = document.getRootElement();
			// 遍历根节点下所有子节点
			Iterator<?> iter = root.elementIterator();
			while (iter.hasNext()) {
				Element ele = (Element) iter.next();
				char firstC = ele.getName().charAt(0);
				String fieldName = new StringBuffer(ele.getName())
						.deleteCharAt(0)
						.insert(0, Character.toLowerCase(firstC)).toString();
				Field field = this.getField(c, fieldName);
				field.setAccessible(true);
				String value = ele.getText();
				if (field.getType().equals(Long.class)
						|| field.getType().equals(long.class)) {
					field.set(ret, Long.parseLong(value));
				} else if (field.getType().equals(Integer.class)
						|| field.getType().equals(int.class)) {
					field.set(ret, Integer.parseInt(value));
				} else {
					field.set(ret, value);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return ret;
	}

	private Field getField(Class<?> clazz, String fieldName) {
		Field field = null;
		while (clazz != Object.class) {
			try {
				return clazz.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
				clazz = clazz.getSuperclass();
			}
		}
		return field;
	}

	private Class<? extends RequestMessage> getType(String t)
			throws UnKnowMessageTypeException {
		Class<? extends RequestMessage> clazz = map.get(t);
		if (clazz == null)
			throw new UnKnowMessageTypeException("未知消息类型:" + t);
		return clazz;
	}
}
