package px.practice.toutiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProjectManager {

	/*
	 * 2 2 5
1 1 1 2
1 2 1 1
1 3 2 2
2 1 1 2
2 3 5 5
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int pmNum = scanner.nextInt();
			int ProgNum = scanner.nextInt();
			int ideaNum = scanner.nextInt();
			List<Idea>[] ideas = new ArrayList[pmNum];
			for (int i = 0; i < ideas.length; i++) {
				ideas[i] = new ArrayList<>();
			}
			int pmId ;
			for (int i = 0; i < ideas.length; i++) {
				pmId = scanner.nextInt();
				ideas[i].add(new Idea(i, pmId, scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
			}
			for (int i = 0; i < ideas.length; i++) {
				Collections.sort(ideas[i], new Comparator<Idea>() {
					@Override
					public int compare(Idea o1, Idea o2) {
						if (o1.priority == o2.priority) {
							if (o1.workTime == o2.workTime) {
								return o1.putForwardTime - o2.putForwardTime;
							}
							return o1.workTime - o2.workTime;
						}
						return o2.priority - o1.priority;
					}
				});
			}
			int finishIdeas = 0;
			int[] pgEpoch = new int[ProgNum];
			Arrays.fill(pgEpoch, 1);
			Idea pickedIdea = null, tmpIdea ;
			int pickedProgId = -1;
			while (finishIdeas < ideaNum) {
				for (int i = 0; i < ideas.length; i++) {
					for (int j = 0; j < ideas[i].size(); j++) {
						tmpIdea = ideas[i].get(j);
						int progId = selectProg(pgEpoch, tmpIdea);
						if (progId >= 0) {
							if (pickedIdea == null || ((pickedIdea.workTime > tmpIdea.workTime || 
									(pickedIdea.workTime == tmpIdea.workTime && pickedIdea.pmId > tmpIdea.pmId)) && pgEpoch[pickedProgId] >= pgEpoch[progId])) {
								pickedIdea = tmpIdea;
								pickedProgId = progId;
								break;
							}
						}
					}
				}
				pickedIdea.finish(pgEpoch[pickedProgId]);
				pgEpoch[pickedProgId] += pickedIdea.workTime;
				finishIdeas++;
			}
			for (int i = 0; i < ideas.length; i++) {
				Collections.sort(ideas[i], new Comparator<Idea>() {
					@Override
					public int compare(Idea o1, Idea o2) {
						return o1.ideaId - o2.ideaId;
					}
				});
			}
			int[] ideasIndex = new int[pmNum];
			for (int i = 0; i < ideas.length; i++) {
				for (int j = ideasIndex[i]; j < ideas[i].size(); j++) {
					if (ideas[i].get(j).ideaId == i) {
						ideasIndex[i]++;
						System.out.println(ideas[i].get(j).finishEpoch);
					} else {
						break;
					}
				}
			}
		}
		scanner.close();
	}
	
	private static int selectProg(int[] pgEpoch, Idea idea) {
		int index = -1;
		int earliestEpoch = -1;
		for (int i = 0; i < pgEpoch.length; i++) {
			if (pgEpoch[i] >= idea.putForwardTime) {
				if (earliestEpoch < 0 || earliestEpoch > pgEpoch[i]) {
					earliestEpoch = pgEpoch[i];
					index = i;
				}
			}
		}
		return index;
	}
	
	static class Idea {
		int pmId ;
		int putForwardTime ;
		int priority ;
		int workTime ;
		int finishEpoch = -1;
		int ideaId ;
		public Idea(int id, int pmId, int pTime, int prior, int wTime) {
			ideaId = id;
			this.pmId = pmId;
			putForwardTime = pTime;
			priority = prior;
			workTime = wTime;
		}
		public void finish(int startEpoch) {
			finishEpoch = startEpoch + workTime;
		}
		@Override
		public String toString() {
			return "pmId:"+pmId+" putForwardTime:"+putForwardTime+" priority:"+priority+" workTime:"+workTime+" finishEpoch:"+finishEpoch;
		}
	}
	
}
