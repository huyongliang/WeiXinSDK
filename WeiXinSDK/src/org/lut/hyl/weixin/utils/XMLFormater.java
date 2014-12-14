package org.lut.hyl.weixin.utils;

import java.io.Writer;

import org.lut.hyl.weixin.model.response.ResponseMessage;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 工具类：将ResponseMessage根据{@link ResponseMessage#getMsgType()}转换为对应的xml格式字符串
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
		xstream.processAnnotations(obj.getClass()); // 通过注解方式的，一定要有这句话
		return xstream.toXML(obj);
	}
}
