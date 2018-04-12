package px.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreakReference {

	public static void main(String[] args) {

//		String string = "catsanddog";//"cat", "cats", "and", "sand", "dog"
//		String string = "a";
		String string = "aaaaaaa";
		Set<String> dic = new HashSet<>();
//		dic.add("cat");	dic.add("cats");	dic.add("and");
//		dic.add("sand");	dic.add("dog");
		dic.add("a");
		dic.add("aaaa");	dic.add("aa");
		System.out.println(new WordBreakReference().wordBreak(string, dic));
	
	}
	
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> results = new ArrayList<>();
		boolean[] contains = new boolean[s.length()];//contains[i]==true,表示从i位置往后分割不出满足条件的串。
		StringBuilder sBuilder = new StringBuilder();
		func(results, s, sBuilder, s.length(), dict, contains);
		return results;
    }
	
	private void func(ArrayList<String> list,String s,StringBuilder ans,int i,Set<String> dict,boolean[] flag) {
		for (int j = i-1; j >= 0; j--) {
			if (dict.contains(s.substring(j, i))) {
				StringBuilder tmp = new StringBuilder(ans);
				if (j == 0) {
					tmp.insert(0, s.substring(j, i));
					list.add(tmp.toString());
				} else {
					if (!flag[j]) {
						int oldSize = list.size();
						tmp.insert(0, " " + s.substring(j, i));
						func(list, s, tmp, j, dict, flag);
						if (oldSize == list.size()) {
							flag[j] = true;
						}
					}
				}
			}
		}
	}
}
