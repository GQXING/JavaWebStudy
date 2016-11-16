package com.contactSystem.exception;
/**
 * 姓名重复的自定义异常
 * @author Administrator
 *
 */
public class NameRepeatException extends Exception{
	public NameRepeatException(String msg) {
		super(msg);
	}
}
