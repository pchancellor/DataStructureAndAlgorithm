package px.practice.tencent;

import java.util.Scanner;

public class Encode {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String target = scanner.next();
			if (target.length() < 4) {
				for (int i = target.length(); i < 4; i++) {
					target += "z";
				}
			}
			int index = 0;
			int _4 = 1+25*(1+25*(1+25));
			int _3 = 1+25*(1+25);
			int _2 = 1+25;
			int _1 = 1;
			for (int i = 0; i < target.length(); i++) {
				if (target.charAt(i) == 'z') {
					break;
				}
				index++;
				switch (i) {
				case 0:	index+=(target.charAt(i)-'a')*_4;	break;
				case 1:	index+=(target.charAt(i)-'a')*_3;	break;
				case 2:	index+=(target.charAt(i)-'a')*_2;	break;
				case 3:	index+=(target.charAt(i)-'a')*_1;	break;
				default:
					break;
				}
			}
			System.out.println(--index);
		}
		scanner.close();
	}

}
