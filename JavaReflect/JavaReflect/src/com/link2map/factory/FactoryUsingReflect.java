package com.link2map.factory;

public class FactoryUsingReflect {

	public static Fruit getFruit(String className) {
		Fruit fruit = null;
		try {
			fruit = (Fruit) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fruit;
	}
	
}
