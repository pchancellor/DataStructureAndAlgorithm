package px.practice.offer;

import java.util.ArrayList;

public class PopOrderJudgementPractice {
	
	public static void main(String[] args) {
		int[] push = new int[]{1,2,3,4,5};
		int[] pop = new int[]{4,5,3,2,1};
//		int[] pop = new int[]{4,3,5,1,2};
		System.out.println(new PopOrderJudgementPractice().IsPopOrder(push, pop));
	}

    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	ArrayList<Integer> list = new ArrayList<>();
    	int popIndex = 0;
    	for (int i = 0; i < pushA.length; i++) {
    		list.add(pushA[i]);
			while (!list.isEmpty() && list.get(list.size()-1) == popA[popIndex]) {
				list.remove(list.size()-1);
				popIndex++;
			}
		}
    	return list.isEmpty();
    }
}
