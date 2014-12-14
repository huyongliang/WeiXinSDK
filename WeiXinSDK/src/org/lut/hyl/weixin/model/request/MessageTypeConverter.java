package org.lut.hyl.weixin.model.request;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.thoughtworks.xstream.converters.enums.EnumSingleValueConverter;

public class MessageTypeConverter extends EnumSingleValueConverter {
	private static final String CUSTOM_ENUM_NAME_METHOD = "getValue";
	private static final String CUSTOM_ENUM_VALUE_OF_METHOD = "toEnum";

	private Class<? extends Enum<?>> enumType;

	public MessageTypeConverter(Class<? extends Enum<?>> type) {
		super(type);
		this.enumType = type;
	}

	@Override
	public String toString(Object obj) {
		Method method = getCustomEnumNameMethod();
		if (method == null) {
			return super.toString(obj);
		} else {
			try {
				return (String) method.invoke(obj, (Object[]) null);
			} catch (Exception ex) {
				return super.toString(obj);
			}
		}
	}

	@Override
	public Object fromString(String str) {
		Method method = getCustomEnumStaticValueOfMethod();
		if (method == null) {
			return enhancedFromString(str);
		}
		try {
			return method.invoke(null, str);
		} catch (Exception ex) {
			return enhancedFromString(str);
		}
	}

	private Method getCustomEnumNameMethod() {
		try {
			return enumType.getMethod(CUSTOM_ENUM_NAME_METHOD,
					(Class<?>[]) null);
		} catch (Exception ex) {
			return null;
		}
	}

	private Method getCustomEnumStaticValueOfMethod() {
		try {
			Method method = enumType.getMethod(CUSTOM_ENUM_VALUE_OF_METHOD,
					(Class<?>[]) null);
			if (method.getModifiers() == Modifier.STATIC) {
				return method;
			}
			return null;
		} catch (Exception ex) {
			return null;
		}
	}

	private Object enhancedFromString(String str) {
		try {
			return super.fromString(str);
		} catch (Exception ex) {
			for (Enum<?> item : enumType.getEnumConstants()) {
				if (item.name().equalsIgnoreCase(str)) {
					return item;
				}
			}
			throw new IllegalStateException("Cannot converter <" + str
					+ "> to enum <" + enumType + ">");
		}
	}
}