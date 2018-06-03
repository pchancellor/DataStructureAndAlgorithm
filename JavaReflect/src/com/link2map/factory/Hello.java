package com.link2map.factory;

public class Hello {

	public static void main(String[] args) {
		Fruit fruit = Factory.getFruit("orange");
		fruit.eat();
		Fruit fruit2 = FactoryUsingReflect.getFruit(Apple.class.getName());
		fruit2.eat();
	}

}
