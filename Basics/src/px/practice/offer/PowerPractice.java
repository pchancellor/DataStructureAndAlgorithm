package px.practice.offer;

public class PowerPractice {
	
    public double Power(double base, int exponent) {
    	double res = 1;
    	if (exponent < 0) {
			exponent = -exponent;
			base = 1/base;
		}
    	for (int i = 0; i < exponent; i++) {
			res *= base;
		}
    	return res;
    }

    /**
     * 使用递归算法，时间复杂度O(logN)
     * @param base
     * @param exponent
     * @return
     */
    public double Power2(double base, int exponent) {
    	boolean negaExpo = false;
    	if (exponent < 0) {
			exponent = -exponent;
			negaExpo = true;
		}
    	if (exponent == 0) {
			return 1;
		}
    	if (exponent == 1) {
			return base;
		}
    	double res = Power2(base, exponent>>1);
    	res *= res;
    	if ((exponent & 1) == 1) {
			res *= base;
		}
    	if (negaExpo) {
			res = 1/res;
		}
    	return res;
    }
}
