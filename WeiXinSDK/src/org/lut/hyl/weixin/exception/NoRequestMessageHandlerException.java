package org.lut.hyl.weixin.exception;

public class NoRequestMessageHandlerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoRequestMessageHandlerException(String msg) {
		super(msg);
	}
}
