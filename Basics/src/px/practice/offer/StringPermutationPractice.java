package px.practice.offer;

import java.util.ArrayList;
import java.util.Arrays;

public class StringPermutationPractice {

	public static void main(String[] args) {
		String string = "abcc";
		System.out.println(new StringPermutationPractice().Permutation(string));
	}
	
	public ArrayList<String> Permutation(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		ArrayList<String> list = new ArrayList<>();
		StringBuilder sBuilder = new StringBuilder();
		getPermutation(list, sBuilder, chars);
		return list;
    }
	
	private void getPermutation(ArrayList<String> container, StringBuilder sBuilder, char[] arr) {
		if (arr.length == 1) {
			sBuilder.append(arr[0]);
			if (container.isEmpty() || !container.contains(sBuilder.toString())) {
				container.add(sBuilder.toString());
			}
			sBuilder.deleteCharAt(sBuilder.length()-1);
		}
		for (int i = 0; i < arr.length; i++) {
			sBuilder.append(arr[i]);
			char[] copiedArr = new char[arr.length-1];
			int index = 0;
			for (int j = 0; j < arr.length; j++) {
				if (i != j) {
					copiedArr[index++] = arr[j];
				}
			}
			getPermutation(container, sBuilder, copiedArr);
			sBuilder.deleteCharAt(sBuilder.length()-1);
		}
	}
}
