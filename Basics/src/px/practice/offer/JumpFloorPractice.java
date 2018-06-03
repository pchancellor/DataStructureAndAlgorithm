package px.practice.offer;

public class JumpFloorPractice {
	
	public static void main(String[] args) {
		int target = 4;
		System.out.println(new JumpFloorPractice().JumpFloor(target));
	}

	public int JumpFloor(int target) {
		if (target < 2) {
			return 1;
		}
		int[] methods = new int[target+1];
		methods[0] = 1;
		methods[1] = 1;
		for (int i = 2; i < methods.length; i++) {
			methods[i] = methods[i-1] + methods[i-2];
		}
		return methods[target];
    }
	
	public int JumpFloorII(int target) {
		if (target == 0) {
			return 1;
		}
//		return (int) Math.pow(2, target-1);
		return 1 << (target-1);//用位移代替幂运算
    }
}
