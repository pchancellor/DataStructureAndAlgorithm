package com.link2map.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.link2map.entity.Demo;
import com.link2map.entity.Person;

public class ClassObjects {

	@Test
	public void acquireClassInfo() {
		Demo demo = new Demo();
		System.out.println(demo.getClass().getName());
		System.out.println(demo.getClass().getClassLoader());
	}

	@Test
	public void acquireClassInfo2() {
		Class<?> demo1 = null;
		Class<?> demo2 = null;
		Class<?> demo3 = null;
		try {
			demo1 = Class.forName("com.link2map.entity.Demo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		demo2 = new Demo().getClass();
		demo3 = Demo.class;
		System.out.println(demo1.getName());
		System.out.println(demo2.getName());
		System.out.println(demo3.getName());
	}

	@Test
	public void acquireInterfaceInfo() {
		Class<?> demo = null;
		try {
			demo = Class.forName("com.link2map.factory.Apple");
			Class<?>[] interfaces = demo.getInterfaces();
			Class<?> parent = demo.getSuperclass();
			System.out.println(parent.getName());
			for (Class<?> _interface : interfaces) {
				System.out.println(_interface.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void instantiate() {
		Class<?> demo = null;
		try {
			demo = Class.forName("com.link2map.entity.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Person person = null;
		try {
			person = (Person) demo.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		person.setAge(23);
		person.setName("Alone");
		System.out.println(person);
	}
	
	@Test
	public void instantiateWithParams() {
		Class<?> demo = null;
		try {
			demo = Class.forName("com.link2map.entity.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Person person1 = null;
		Person person2 = null;
		Person person3 = null;
		Constructor<?> constructor = null;
		try {
			constructor = demo.getConstructor(String.class, int.class);
			person1 = (Person) constructor.newInstance("Alone2", 22);
			constructor = demo.getConstructor();
			person2 = (Person) constructor.newInstance();
			constructor = demo.getConstructor(int.class);
			person3 = (Person) constructor.newInstance(21);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		System.out.println(person1);
		System.out.println(person2);
		System.out.println(person3);
	}
}
