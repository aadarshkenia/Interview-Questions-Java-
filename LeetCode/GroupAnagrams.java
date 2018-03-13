import java.util.*;

class GroupAnagrams{
	public static void main(String args[]){
		String str[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> ans = groupAnagrams(str);
		for(List<String> group : ans)
			System.out.println(group);
	}
	
	
	public static List<List<String>> groupAnagrams(String [] str){
		Arrays.sort(str);
		int n = str.length;
		HashMap<String, ArrayList<String>> map = new HashMap();
		for(int i = 0; i < n; i++){
			addToMap(str[i], map);	
		}
		List<List<String>> ans = createGroupsFromMap(map);
		return ans;
	}
	
	public static List<List<String>> createGroupsFromMap(HashMap<String, ArrayList<String>> map){
		List<List<String>> ans = new ArrayList();
		Set<String> keySet = map.keySet();
		Iterator it = keySet.iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			ans.add((List<String>)map.get(key));
		}
		return ans;
	}

	public static void addToMap(String str, HashMap<String, ArrayList<String>> keyGroupMap){
		String orig = str;
		str = sortString(str);
		ArrayList<String> group = (ArrayList<String>)keyGroupMap.get(str);
		if(group == null)
			group = new ArrayList();
		group.add(orig);
		keyGroupMap.put(str, group);
	}

	public static String sortString(String str){
		char s[] = str.toCharArray();
		Arrays.sort(s);
		return new String(s);
	}
	
	/*
	//Method to add a string into a sorted list
	public static void addStringToList(String str, List<String> list){
		int n = list.size();
		int low = 0, high = n-1 ;
		while(low <= high){
			int mid = low + (high-low)/2;
			if(str.compareTo(list.get(mid)) > 0){
				if(mid < n-1){
					if(str.compareTo(list.get(mid + 1)) < 0){
						list.add(mid+1, str);
						return;
					}
					else
						low = mid + 1;
				}
				else{
					list.add(n, str);
					return;	
				}
			}
			else if(str.equals(list.get(mid))){
				list.add(mid+1, str);
				return;
			}
			else{
				high = mid - 1;	
			}
		}
		list.add(low, str);

	}
	*/

}
