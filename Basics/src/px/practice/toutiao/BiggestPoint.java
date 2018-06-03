package px.practice.toutiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class BiggestPoint {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int num = scanner.nextInt();
			Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});//key,value分别表示x和y,按x降序排列
			for (int i = 0; i < num; i++) {
				map.put(scanner.nextInt(), scanner.nextInt());
			}
			Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator();
			int maxY = -1;
			Entry<Integer, Integer> entry;
			List<String> results = new ArrayList<>();
			while (iterator.hasNext()) {
				entry = iterator.next();
				if (entry.getValue() >= maxY) {
					maxY = entry.getValue();
					results.add(entry.getKey() + " " + entry.getValue());
				}
			}
			for (int i = results.size()-1; i >= 0; i--) {
				System.out.println(results.get(i));
			}
			
			
//			Point[] points = new Point[num];
//			for (int i = 0; i < points.length; i++) {
//				points[i] = new Point(scanner.nextInt(), scanner.nextInt());
//			}
//			List<Point> biggestList = new ArrayList<>();
//			Arrays.sort(points, new Comparator<Point>() {
//				@Override
//				public int compare(Point o1, Point o2) {
//					return o1.x - o2.x;
//				}
//			});
//			int maxY = points[num-1].y;
//			biggestList.add(points[num-1]);
//			for (int i = num-2; i >= 0; i--) {
//				if (points[i].y >= maxY) {
//					maxY = points[i].y;
//					biggestList.add(points[i]);
//				}
//			}
//			for (int i = biggestList.size()-1; i >= 0; i--) {
//				System.out.println(biggestList.get(i));
//			}
		}
		scanner.close();
	}
	
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return x + " " + y;
		}
	}
}
