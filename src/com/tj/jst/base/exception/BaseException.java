package com.tj.jst.base.exception;

/**
 * ȫ���쳣
 * @author Administrator
 *
 */
public class BaseException extends Exception {
	
	// ��ʾ�ĳ�����Ϣ
	private String message;

	// ���췽��
	public BaseException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
