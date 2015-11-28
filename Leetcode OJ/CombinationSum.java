import java.util.ArrayList;
import java.util.List;
class CombinationSum{

	public static void main(String args[]){
    	int target = 7;
    	int x[] = {2,3,6,7};
    	List<List<Integer>> ans = combinationSum(x, target);
    	System.out.println(ans);
    }//main


	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	int n = candidates.length;
        List<List<List<Integer>>> buf = new ArrayList();

        for(int i=1; i<=target; i++){
            List<List<Integer>> partialList = new ArrayList();
            for(int j=0;j<n;j++){
                if(i == candidates[j]){
                    List<Integer> templist = new ArrayList();
                    templist.add(i);
                    partialList.add(templist);
                }
                else if(i > candidates[j]){
                    List<List<Integer>> diffList = buf.get(i - candidates[j] - 1);
                    if(diffList.size() > 0){

                        for(List<Integer> eachCombination : diffList){
                            if(candidates[j] <= eachCombination.get(0)){
	                            List<Integer> newList = new ArrayList();
	                            newList.add(candidates[j]);
	                            for(int k : eachCombination)
	                            	newList.add(k);
	                        	partialList.add(newList);
                        	}
                        }

                    }
                }                    
            }//inner for
            buf.add(partialList);
        }//outer for

        return buf.get(buf.size()-1);
    }//function

}