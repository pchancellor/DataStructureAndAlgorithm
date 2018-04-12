package px.practice.niuke;

public class StringReplaceSpace {

	public static void main(String[] args) {
		StringBuffer stringBuffer = new StringBuffer("We Are Happy");
		System.out.println(new StringReplaceSpace().replaceSpace(stringBuffer));
	}

	public String replaceSpace(StringBuffer str) {
		char[] chars = str.toString().toCharArray();
		str.setLength(0);
		int offset = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				str.append(chars, offset, i-offset).append("%20");
				offset = i+1;
			}
		}
		str.append(chars, offset, chars.length-offset);
    	return str.toString();
    }
	
}
