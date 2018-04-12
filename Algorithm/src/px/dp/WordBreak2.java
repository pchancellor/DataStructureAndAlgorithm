package px.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak2 {

	//TODO: ´ýÐÞÕý
	public static void main(String[] args) {
//		String string = "catsanddog";//"cat", "cats", "and", "sand", "dog"
//		String string = "a";
		String string = "aaaaaaa";
		Set<String> dic = new HashSet<>();
//		dic.add("cat");	dic.add("cats");	dic.add("and");
//		dic.add("sand");	dic.add("dog");
		dic.add("a");
		dic.add("aaaa");	dic.add("aa");
		System.out.println(new WordBreak2().wordBreak(string, dic));
	}

	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> results = new ArrayList<>();
		boolean[] contains = new boolean[s.length()+1];
		contains[0] = true;
		int length = s.length();
		for (int i = 1; i <= length; i++) {
			for (int j = 0; j < i; j++) {
				if (contains[j] && dict.contains(s.substring(j, i))) {
					contains[i] = true;
					break;
				}
			}
		}
		if (!contains[contains.length-1]) {
			return null;
		}
		getWords(results, contains, s, dict, contains.length-1);
		return results;
    }
	
	public void getWords(ArrayList<String> list, boolean[] contains, String s, Set<String> dict, int end) {
		for (int i = end - 1; i > 0; i--) {
			if (contains[i]) {
				StringBuilder sBuilder = new StringBuilder();
				sBuilder.insert(0, s.substring(i, end)).insert(0, " ");
				getWords(list, contains, s, dict, i-1);
			}
		}
	}
}
