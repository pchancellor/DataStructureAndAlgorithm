package px.dp;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	public static void main(String[] args) {
		String s = "leetcodecode";
//		String s = "ab";
		Set<String> dict = new HashSet<>();
		dict.add("leet");
		dict.add("code");
		dict.add("a");
		dict.add("b");
//		System.out.println(new WordBreak().wordBreak(s, dict));
		System.out.println(new WordBreak().wordBreak2(s, dict));
	}

	public boolean wordBreak(String s, Set<String> dict) {
        int length = s.length();
        boolean[][] contains = new boolean[length][length];
        for (int i = 0; i < contains.length; i++) {
        	if (dict.contains(s.substring(i, i+1))) {
				contains[i][i] = true;
			} else {
				contains[i][i] = false;
			}
		}
        for (int k = 1; k < contains.length; k++) {
			for (int start = 0; start < contains.length - k; start++) {
				int end = start + k;
				if (dict.contains(s.substring(start, end+1))) {
					contains[start][end] = true;
				} else {
					for (int i = start; i < end; i++) {
						if (contains[start][i] && contains[i+1][end]) {
							contains[start][end] = true;
							break;
						}
					}
				}
			}
		}
        return contains[0][length-1];
    }

	public boolean wordBreak2(String s, Set<String> dict){
		int len = s.length();
		boolean[] arrays = new boolean[len+1];
		arrays[0] = true;
		for (int i = 1; i <= len; ++i){
			for (int j = 0; j < i; ++j){
				if (arrays[j] && dict.contains(s.substring(j, i))){
					arrays[i] = true;
					break;
				}
			}
		}
		return arrays[len];
	}
}
