package px.practice.tencent;

import java.util.Scanner;

public class GameMark {

	//TODO: ´ýÐÞÕý
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int task1 = scanner.nextInt();
			int task2 = scanner.nextInt();
			if (task1 < 1 || task1 > 1024 || task2 < 1 || task2 > 1024) {
				System.out.println(-1);
			} else {
				int[] taskset = new int[32];
				byte[] bytes1 = new byte[4];
				int quot1 = setBytes(task1, taskset, bytes1);
				taskset[quot1] = taskset[quot1] | bytes2Int(bytes1);

				byte[] bytes2 = new byte[4];
				int quot2 = setBytes(task2, taskset, bytes2);
				taskset[quot2] = taskset[quot2] & bytes2Int(bytes2);
				if (taskset[quot2]==0) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}
			}
		}
		scanner.close();
	}
	
	public static int setBytes(int target, int[] taskset, byte[] bytes) {
		int quot = (int) (Math.ceil(target / 32.0) + 1);
		int mod = target % 32;
		
		bytes[mod/8] = (byte) Math.pow(2, mod%8);
		return quot;
	}
	
	public static int bytes2Int(byte[] bytes) {
		int result = 0;
		for (int i = 0; i < bytes.length; i++) {
			result += bytes[i] << i;
		}
		return result;
	}
}
