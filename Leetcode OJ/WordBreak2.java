import java.util.*;

class WordBreak2{
	public static void main(String args[]){
		String s = "catsanddog";
		HashSet<String> set = new HashSet();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");

		List<String> ans = wordBreak(s, set);
		System.out.println(ans);
	}

	public static List<String> wordBreak(String s, Set<String> dict){
		List<String> result = new ArrayList<String>();
		Iterator it = dict.iterator();
		while(it.hasNext()){
			String dict_word = (String)it.next();
			if(dict_word.equals(s)){
				result.add(dict_word);
				return result;
			}

			if(isPrefix(dict_word, s)){
				Set<String> newset = copySet(dict);
				newset.remove(dict_word);
				List<String> smallList = wordBreak(s.substring(dict_word.length()), newset);
				if(smallList.size() > 0){
					for(String small_string : smallList)
						result.add(dict_word+" "+small_string);
				}
							}
		}//set iterator
		return result;
	}//function

	//To check if smaller word is a prefix of larger word
	public static boolean isPrefix(String small, String large){
		if(small.length() > large.length())
			return false;

		int slen = small.length();
		for(int i=0;i<slen;i++){
			if(small.charAt(i) != large.charAt(i))
				return false;
		}
		return true;
	}

	public static Set<String> copySet(Set<String> original){
		Set<String> newset = new HashSet<String>();
		Iterator it = original.iterator();
		while(it.hasNext()){
			newset.add((String)it.next());
		}
		return newset;
	}

}