package px.test;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import px.sort.SelectionProblem;

public class TestSelectionProblem {
	
	SelectionProblem myTestProblem ;
	
	@Before
	public void init() {
		myTestProblem = new SelectionProblem();
	}

	@Test
	public void test() {
//		int[] arrays = new int[]{2,53,17,32,1,62,78,5,11,3,24,11};
		int[] arrays = new int[30];
		Random random = new Random();
		for (int i = 0; i < arrays.length; i++) {
			arrays[i] = random.nextInt(100);
		}
		Arrays.sort(arrays);
		for (int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] + " ");
		}
		try {
			System.out.println("\nk biggest value:" + myTestProblem.selectKBiggestValue(arrays, 10));
			System.out.println("k biggest value (binary heap) :" + myTestProblem.selectKthBiggestValueUsingHeap(arrays, arrays.length - 10 + 1));
			System.out.println("k biggest value (binary heap with size k) :" + myTestProblem.selectKthBiggestValueUsingHeapSizeK(arrays, 10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
