package com.link2map.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class Fields {
	
	/**
	 * getDeclaredFields、getFields方法的差异和getDeclaredMethods、getMethods的差异一致
	 */
	@Test
	public void acquireFields() {
		Class<?> demo = null;
		try {
			demo = Class.forName("com.link2map.entity.Person");
			Field[] fields = demo.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getName()
						+ " " + field.getName() + ";");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void modifyFields() {
		Class<?> demo = null;
		try {
			demo = Class.forName("com.link2map.entity.Person");
			Object object = demo.newInstance();
			Field field = demo.getDeclaredField("name");
			field.setAccessible(true);
			field.set(object, "Alone");
			System.out.println(field.get(object));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
