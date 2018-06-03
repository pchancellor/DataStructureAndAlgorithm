package px.practice.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class JosephPractice {
	
	public static void main(String[] args) {
		System.out.println(new JosephPractice().getResult2(13));
	}

    public int getResult(int n) {
        int pace = 2;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
        int index = 0;
        while (arr.length > 1) {
			int[] tmp = arr;
			arr = new int[(int) Math.ceil((double)arr.length/pace)];
			for (int i = 0; i < arr.length; i++) {
				arr[(index+i)%arr.length] = tmp[(index+i*pace)%tmp.length];
			}
			index = (index+arr.length-1)%arr.length;
			pace++;
		}
        return arr[0];
    }

    /**
     * Ê¹ÓÃÁ´±í
     * @param n
     * @return
     */
    public int getResult2(int n) {
    	if (n <= 0) {
			return 0;
		}
        int pace = 2;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
			list.add(i+1);
		}
        while (list.size() > 1) {
        	Iterator<Integer> iterator = list.iterator();
            int index = 0;
			while (iterator.hasNext()) {
				iterator.next();
				if (index++ % pace != 0) {
					iterator.remove();
				}
			}
			list.addFirst(list.removeLast());
			pace++;
		}
        return list.get(0);
    }
}
