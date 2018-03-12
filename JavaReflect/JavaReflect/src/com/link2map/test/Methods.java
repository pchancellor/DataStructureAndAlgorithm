package com.link2map.test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class Methods {

	/**
	 * getMethods方法获取所有的public方法，包括继承自父类的方法
	 */
	@Test
	public void acquireMethods() {
		Class<?> demo = null;
		try {
			demo = Class.forName("com.link2map.entity.Person");
			Method[] methods = demo.getMethods();
			for (Method method : methods) {
				System.out.println(method.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * getDeclaredMethods方法获取所有修饰符修饰的方法，包括public private等，不包括继承自父类的方法
	 */
	@Test
	public void acquireDeclaredMethods() {
		Class<?> demo = null;
		try {
			demo = Class.forName("com.link2map.entity.Person");
			Method[] methods = demo.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(method.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void acquireModifier() {
		Class<?> demo = null;
		try {
			demo = Class.forName("com.link2map.entity.Person");
			Method[] methods = demo.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(method.getModifiers());
				System.out.println(Modifier.toString(method.getModifiers())+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void acquireException() {
		Class<?> demo = null;
		try {
			demo = Class.forName("com.link2map.entity.Person");
			Method[] methods = demo.getDeclaredMethods();
			for (Method method : methods) {
				Class<?>[] exceptionType = method.getExceptionTypes();
				for (Class<?> exception : exceptionType) {
					System.out.println(exception.getName());
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void invokeDeclaredMethods() {
		Class<?> demo = null;
		try {
			demo = Class.forName("com.link2map.entity.Person");
			Object object = demo.newInstance();
			Method method = demo.getDeclaredMethod("setAge", int.class);
			method.invoke(object, 24);
			method = demo.getDeclaredMethod("getAge");
			System.out.println(method.invoke(object));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
