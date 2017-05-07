package px.test;

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
		int[] arrays = new int[]{2,53,17,32,1,62,78,5,11,3,24,11};
		try {
			System.out.println("k biggest value:" + myTestProblem.selectKBiggestValue(arrays, 10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
