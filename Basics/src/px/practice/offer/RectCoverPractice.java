package px.practice.offer;

public class RectCoverPractice {

    public int RectCover(int target) {
    	if (target == 0) {
			return 0;
		}
    	if (target == 1) {
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
}
