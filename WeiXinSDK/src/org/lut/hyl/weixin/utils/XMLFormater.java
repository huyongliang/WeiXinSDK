package org.lut.hyl.weixin.utils;

import java.io.Writer;

import org.lut.hyl.weixin.model.response.ResponseMessage;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * �����ࣺ��ResponseMessage����{@link ResponseMessage#getMsgType()}ת��Ϊ��Ӧ��xml��ʽ�ַ���
 * 
 * @author HuYongliang
 *
 */
public class XMLFormater {
	protected static String PREFIX_CDATA = "<![CDATA[";
	protected static String SUFFIX_CDATA = "]]>";
	private XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				boolean cdata = true;

				public void startNode(String name,
						@SuppressWarnings("rawtypes") Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write(PREFIX_CDATA);
						writer.write(text);
						writer.write(SUFFIX_CDATA);
					} else {
						writer.write(text);
					}
				}
			};
		}
	});

	public String format(ResponseMessage baseMsg, boolean alredyReverseFromAnTo)
			throws UnsupportedOperationException {
		if (alredyReverseFromAnTo)
			return this.toXml(baseMsg);
		String f = baseMsg.getFromUserName();
		baseMsg.setFromUserName(baseMsg.getToUserName());
		baseMsg.setToUserName(f);
		return this.toXml(baseMsg);
	}

	public String format(ResponseMessage baseMsg)
			throws UnsupportedOperationException {
		return this.format(baseMsg, true);
	}

	private String toXml(Object obj) {
		xstream.processAnnotations(obj.getClass()); // ͨ��ע�ⷽʽ�ģ�һ��Ҫ����仰
		return xstream.toXML(obj);
	}
}
