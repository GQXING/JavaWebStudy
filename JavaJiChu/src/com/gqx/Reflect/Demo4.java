package com.gqx.Reflect;

import java.lang.reflect.Field;

public class Demo4 {
	private String proprety = null;
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		// TODO Auto-generated method stub
		Class<?> clazz = Class.forName("com.gqx.Reflect.Demo4");
        Object obj = clazz.newInstance();
        // ����ֱ�Ӷ� private �����Ը�ֵ
        Field field = clazz.getDeclaredField("proprety");
        field.setAccessible(true);
        field.set(obj, "Java�������");
        System.out.println(field.get(obj));
	}

}
