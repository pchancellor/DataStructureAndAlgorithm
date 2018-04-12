package px.practice.niuke;

public class ArraySearch {

	public static void main(String[] args) {
		int[][] array = new int[][] {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}} ;
		System.out.println(new ArraySearch().Find(7, array));
	}
	
	public boolean Find(int target, int [][] array) {
        int rows = array.length;
		if (rows == 0) {
			return false;
		} else {
			return compare(target, array, rows/2, array[rows/2].length/2, MoveDirection.no);
		}
    }
	
	public boolean compare(int target, int[][] array, int row, int column, MoveDirection direction) {
		if (row < 0 || row >= array.length || column < 0 || column >= array[row].length) {
			return false;
		}
		if (target == array[row][column]) {
			return true;
		} else if (target < array[row][column]) {
			if (direction == MoveDirection.down || direction == MoveDirection.right) {
				return false;
			}
			return compare(target, array, row-1, column, MoveDirection.up) || compare(target, array, row, column-1, MoveDirection.left);
		} else {
			if (direction == MoveDirection.up || direction == MoveDirection.left) {
				return false;
			}
			return compare(target, array, row+1, column, MoveDirection.down) || compare(target, array, row, column+1, MoveDirection.right);
		}
	}
	
	public static enum MoveDirection {
		left, right, up, down, no
	}
}
