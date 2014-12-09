package org.lut.hyl.weixin.exception;

public class UnKnowMessageTypeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnKnowMessageTypeException(String msg) {
		super(msg);
	}
}
