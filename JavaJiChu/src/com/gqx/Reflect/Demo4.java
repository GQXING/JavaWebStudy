package com.gqx.Reflect;

import java.lang.reflect.Field;

public class Demo4 {
	private String proprety = null;
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		// TODO Auto-generated method stub
		Class<?> clazz = Class.forName("com.gqx.Reflect.Demo4");
        Object obj = clazz.newInstance();
        // 可以直接对 private 的属性赋值
        Field field = clazz.getDeclaredField("proprety");
        field.setAccessible(true);
        field.set(obj, "Java反射机制");
        System.out.println(field.get(obj));
	}

}
