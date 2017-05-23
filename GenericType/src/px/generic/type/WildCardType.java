package px.generic.type;

import java.util.Collection;

public class WildCardType {

	public static double totalArea(Collection<? extends Object> arr) {
		contains(new Shape[10], new WildCardType().new Person());
		contains(new Shape[10], new WildCardType().new Shape());
		findMax(new Person[10]);
		findMax(new Employee[10]);
//		findMax(new Shape[10]);
		findMax2(new Person[10]);
		findMax2(new Employee[10]);
		return 1.0;
	}
	
	public static <AnyType> boolean contains( AnyType[] arr, AnyType x) {
		for (AnyType val : arr) {
			if (x.equals(val)) {
				return true;
			}
		}
		return false;
	}
	
	public static <AnyType extends Comparable<AnyType>> AnyType findMax(AnyType[] array) {
		int maxIndex = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i].compareTo(array[maxIndex]) > 0) {
				maxIndex = i;
			}
		}
		return array[maxIndex];
	}
	
	public static <AnyType extends Comparable<? super AnyType>> AnyType findMax2(AnyType[] array) {
		int maxIndex = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i].compareTo(array[maxIndex]) > 0) {
				maxIndex = i;
			}
		}
		return array[maxIndex];
	}
	
	class Employee extends Person {
		public String job;
	}
	
	class Person implements Comparable<Person> {
		public String name ;

		@Override
		public int compareTo(Person o) {
			return name.compareTo(o.name);
		}
	}
	
	class Shape {
		public double area ;
	}
	
}
