import java.util.*;

class PascalTriangle{
	public static void main(String args[]){
		List<List<Integer>> pascalTriangle = generate(Integer.parseInt(args[0]));
		for(List<Integer> row : pascalTriangle)
			System.out.println(row);
	}


	public static List<List<Integer>> generate(int numrows){
		List<List<Integer>> ans = new ArrayList();
		for(int i=0; i < numrows; i++){
			if(i==0){
				List<Integer> temp = new ArrayList();
				temp.add(1);
				ans.add(i, temp);
			}
			else{
				List<Integer> precedingList = ans.get(i-1);
				List<Integer> currentList = new ArrayList();
				int size = precedingList.size();
				for(int j=0; j <= i; j++){
					if(j==0 || j==i){
						currentList.add(1);
					}
					else{
						currentList.add(precedingList.get(j) + precedingList.get(j-1));
					}
				}
				ans.add(currentList);
			}
		} 
		return ans;
	}
}
