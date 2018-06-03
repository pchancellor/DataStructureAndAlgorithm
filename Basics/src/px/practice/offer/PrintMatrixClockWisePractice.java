package px.practice.offer;

import java.util.ArrayList;

public class PrintMatrixClockWisePractice {
	
	public static void main(String[] args) {
//		int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//		int[][] matrix = new int[][]{{1,2,3,4,5}};
//		int[][] matrix = new int[][]{{1},{2},{3},{4},{5}};
		int[][] matrix = new int[][]{{1,2},{3,4},{5,6},{7,8},{9,10}};
		System.out.println(new PrintMatrixClockWisePractice().printMatrix(matrix));
	}

    public ArrayList<Integer> printMatrix(int [][] matrix) {
    	ArrayList<Integer> container = new ArrayList<>();
    	if (matrix.length == 0) {
			return container;
		}
        int left = 0, top = 0, right = matrix[0].length-1, bottom = matrix.length-1;
        printMatrix(matrix, container, top, bottom, left, right);
        return container;
    }
    
    private void printMatrix(int [][] matrix, ArrayList<Integer> container, int top, int bottom, int left, int right) {
		if (top > bottom || left > right) {
			return;
		}
		if (top == bottom) {
			for (int i = left; i <= right; i++) {
				container.add(matrix[top][i]);
			}
		} else if (left == right) {
			for (int i = top; i <= bottom; i++) {
				container.add(matrix[i][left]);
			}
		} else {
			for (int i = left; i <= right; i++) {
				container.add(matrix[top][i]);
			}
			for (int i = top+1; i <= bottom; i++) {
				container.add(matrix[i][right]);
			}
			for (int i = right-1; i >= left; i--) {
				container.add(matrix[bottom][i]);
			}
			for (int i = bottom-1; i >= top+1; i--) {
				container.add(matrix[i][left]);
			}
			printMatrix(matrix, container, top+1, bottom-1, left+1, right-1);
		}
	}
    
    @Deprecated
    public ArrayList<Integer> printMatrix2(int [][] matrix) {
    	ArrayList<Integer> container = new ArrayList<>();
    	if (matrix.length == 0) {
			return container;
		}
        int left = 0, top = 0, right = matrix[0].length-1, bottom = matrix.length-1;
        int changeTag = 0;
        while (left < right && top < bottom) {
			switch (changeTag++ % 4) {
			case 0:
				for (int i = left; i <= right; i++) {
					container.add(matrix[top][i]);
				}
				top++;
				break;
			case 1:
				for (int i = top; i <= bottom; i++) {
					container.add(matrix[i][right]);
				}
				right--;
				break;
			case 2:
				for (int i = right; i >= left; i--) {
					container.add(matrix[bottom][i]);
				}
				bottom--;
				break;
			case 3:
				for (int i = bottom; i >= top; i--) {
					container.add(matrix[i][left]);
				}
				left++;
				break;
			default:
				break;
			}
		}
        if (left == right && changeTag % 4 < 2) {
        	for (int i = top; i <= bottom; i++) {
				container.add(matrix[i][right]);
			}
		} else if (left == right) {
			for (int i = bottom; i >= bottom; i--) {
				container.add(matrix[i][right]);
			}
		} else if ((changeTag+1) % 4 > 1) {
			for (int i = right; i >= left; i--) {
				container.add(matrix[bottom][i]);
			}
		} else {
			for (int i = left; i <= right; i++) {
				container.add(matrix[top][i]);
			}
		}
        return container;
    }
}
