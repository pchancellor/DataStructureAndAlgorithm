package px.practice.offer;

public class NumberOf1Between1AndNPractice {
	
	public static void main(String[] args) {
		int n = 200;
		System.out.println(new NumberOf1Between1AndNPractice().NumberOf1Between1AndN_Solution(n));
	}

    public int NumberOf1Between1AndN_Solution(int n) {
    	if (n == 0) {
			return 0;
		}
    	int length = (""+n).length();
    	if (length == 1) {
			return 1;
		}
    	int[] oneNums = new int[length-1];
    	oneNums[0] = 1;
    	int tens = 10;
    	for (int i = 1; i < oneNums.length; i++) {
			oneNums[i] = tens + 10*oneNums[i-1];
			tens *= 10;
		}
    	int totalNumOfOne = 0;
    	while (n > 9) {
        	int index = (int) Math.floor(Math.log10(n));
    		int base = (int) Math.pow(10, index);
    		int quotient = n/base;
			totalNumOfOne += quotient*oneNums[index-1];
			n %= base;
			totalNumOfOne += quotient==1 ? n+1 : base;
		}
    	if (n != 0) {
			totalNumOfOne++;
		}
    	return totalNumOfOne;
    }
    
    /**
     * 参考他人解法
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution2(int n) {
    	if (n <= 0) {
			return 0;
		}
    	int count = 0;
    	for (int i = 1; i <= n; i*=10) {
    		int divider = i * 10;
			count += n/divider*i + Math.min(Math.max(n%divider-i+1, 0), i);
		}
    	return count;
    }
}
