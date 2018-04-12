package px.practice.ali;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CommodityCombination {
	
	public Map<String, Integer> warehouse = new HashMap<>();
	public int commodityTypeNum ;
	public int combinationTypeNum ;
	public List<Integer> commodityNumList = new ArrayList<>();
	public List<List<Integer>> rawData = new ArrayList<>();
	public List<Integer> sumList = new ArrayList<>(commodityTypeNum);
	public int totalCommody ;
	public int minLeftTypes ;

	public static void main(String[] args) {
		Map<Integer, Integer> map1 = new HashMap<>();
		map1.put(1, 1);
		map1.put(2, 2);
		Map<Integer, Integer> map2 = new HashMap<>(map1);
		map2.put(3, 3);
		System.out.println(map1);
		System.out.println(map2);
	}
	
	public void readData(String fileName) throws Exception {
		File file = new File(fileName);
		try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
			String fisrtLine = "";
			String secondLine = "";
			if ((fisrtLine = reader.readLine()) != null) {
				commodityTypeNum = Integer.valueOf(fisrtLine.split(",")[0]);
				combinationTypeNum = Integer.valueOf(fisrtLine.split(",")[1]);
			}
			if ((secondLine = reader.readLine()) != null) {
				String[] strings = secondLine.split(",");
				for (String string : strings) {
					commodityNumList.add(Integer.valueOf(string));
				}
			}
			String line = "";
			for (int i = 0; i < combinationTypeNum; i++) {
				List<Integer> list ;
				if ((line = reader.readLine()) != null) {
					String[] strings = line.split(",");
					list = new ArrayList<>();
					for (int j = 1; j < strings.length; j++) {
						list.add(Integer.valueOf(strings[i]));
					}
					if (list.size()!=commodityTypeNum) {
						throw new Exception("数据格式不对");
					}
					rawData.add(list);
				}
			}
			if (rawData.size() != combinationTypeNum) {
				throw new Exception("数据格式不对");
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<Combination> getCombination(int columnId) {
		Row[] rows = getSortedRowsAsc(columnId);
		List<Combination> combinations = new ArrayList<>();
		int theoryMaxSets = commodityNumList.get(columnId)/rows[0].specificElem;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(rows[0].rowId, theoryMaxSets);
		Combination combination = new Combination(map, computeLeftTypes(map));
		if (checkCombination(combination)) {
			combinations.add(combination);
			setMaxItemNum(combination.itemNum);
		} else {
			getBestCombination(rows, map, combinations);
		}
		return combinations;
	}
	
	public void getBestCombination(Row[] rows, Map<Integer, Integer> currentMap, List<Combination> combinations) {
//		if (minLeftTypes < new Combination(currentMap, computeLeftTypes(currentMap)).leftTypes) {
//			return;
//		}
		int sum = sumCurrentMap(currentMap);
		for (int i = 1; i < rows.length; i++) {
			int tempSum = sum + rows[i].specificElem;
			if (tempSum > totalCommody) {
				currentMap.put(rows[0].rowId, currentMap.get(rows[0].rowId)-1);
				currentMap.put(rows[i].rowId, currentMap.get(rows[i].rowId)+1);
				break;
			} else {
				Map<Integer, Integer> map = new HashMap<>(currentMap);
				int value = map.get(rows[i].rowId);
				map.put(rows[i].rowId, value + 1);
				Combination combination = new Combination(map, computeLeftTypes(map));
				if (checkCombination(combination)) {
					combinations.add(combination);
					setMaxItemNum(combination.itemNum);
				}
			}
		}
		getBestCombination(rows, currentMap, combinations);
	}
	
	public void setMaxItemNum(int itemNum) {
		minLeftTypes = minLeftTypes >= itemNum ? minLeftTypes : itemNum;
	}
	
	public int sumCurrentMap(Map<Integer, Integer> currentMap) {
		
		return 0;
	}
	
	public boolean checkCombination(Combination combination) {
		
		return false;
	}
	
	public Row[] getSortedRowsAsc(int columnId) {
		return null;
	}
	
	public int computeLeftTypes(Map<Integer, Integer> map) {
		
		return 0;
	}
	
	static class Row implements Comparable<Row> {
		List<Cell> cells = new ArrayList<>();
		int rowId ;
		int specificElem ;
		
		@Override
		public int compareTo(Row o) {
			return this.specificElem - o.specificElem;
		}
	}
	
	static class Cell {
		int value ;
		int row ;
		int column ;
	}
	
	static class Combination implements Comparable<Combination>{
		int itemNum ;
		int leftTypes ;
		Map<Integer, Integer> rowIdMap ;//key是rowid，value是rowid对应的row出现的次数
		public Combination(Map<Integer, Integer> map, int leftTypes) {
			rowIdMap = new HashMap<>(map);
			for (Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
				Entry<Integer, Integer> num = (Entry<Integer, Integer>) iterator.next();
				itemNum += num.getValue();
			}
			this.leftTypes = leftTypes;
		}
		@Override
		public int compareTo(Combination o) {
			return itemNum - o.itemNum;
		}
	}
}
