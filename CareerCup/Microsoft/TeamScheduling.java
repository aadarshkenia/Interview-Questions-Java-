//Question : Given n teams which need to play each other exactly once and at most once per day, output the game schedule.
//https://www.careercup.com/question?id=5104569490079744
import java.util.List;
import java.util.ArrayList;

class TeamScheduling {
	public List<List<int[]>> schedule(int n) {
		List<List<int[]>> teams = new ArrayList<>(); //inner int is int[2] storing the two teams, inner list is for teams playing on that day, outer list is number of days
		if(n == 1) {
			throw new IllegalArgumentException("Number of teams have to be greater than n");
		}
		//Initialize for n = 2;
		int[] temp = {1,2};
		teams.add(temp);
		for(int i = 3; i <= n; i++) {
			if(i - 1 % 2 == 0) {
				for(int j = 1; j < n; j++) {
					int pairing[] = new int[2];
					pairing[0] = j;
					pairing[1] = n;
					teams.add(pairing);
				}
			} else {
				int numdays = teams.size();
				for(int i=1 ; i < numdays; i++) {
					if(numdays.get(i-1))
				} 
			}
		}
	}

}
