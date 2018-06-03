package px.practice.offer;

public class VerifySquenceOfBSTPractice {
	
	public static void main(String[] args) {
		int[] sequence = new int[] {3,6,5,11,10,13,8};
		VerifySquenceOfBSTPractice practice = new VerifySquenceOfBSTPractice();
		System.out.println(practice.VerifySquenceOfBST(sequence));
	}

    public boolean VerifySquenceOfBST(int [] sequence) {
    	if (sequence.length == 0) {
			return false;
		}
        return VerifySquenceOfBST(sequence, 0, sequence.length-1);
    }
    
    private boolean VerifySquenceOfBST(int[] sequence, int left, int right) {
    	if (left >= right) {
			return true;
		}
		int root = sequence[right];
		int i ;
		for (i = left; i < right; i++) {
			if (sequence[i] > root) {
				break;
			}
		}
		for (int j = i; j < right; j++) {
			if (sequence[j] < root) {
				return false;
			}
		}
		return VerifySquenceOfBST(sequence, left, i-1) && VerifySquenceOfBST(sequence, i, right-1);
	}
}
