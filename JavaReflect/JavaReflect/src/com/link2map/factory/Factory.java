package com.link2map.factory;

public class Factory {

	public static Fruit getFruit(String fruitName) {
		Fruit fruit = null;
		if (fruitName.equals("apple")) {
			fruit = new Apple();
		}
		if (fruitName.equals("orange")) {
			fruit = new Orange();
		}
		return fruit;
	}
	
}
