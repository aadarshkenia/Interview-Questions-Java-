class _387 {
	
	public static void main(String args[]) {
		String test1 = "leetcode";
		System.out.println(new _387().firstUniqChar(test1));
		String test2 = "loveleetcode";
		System.out.println(new _387().firstUniqChar(test2));
	}

	public int firstUniqChar(String s) {
		int hash[] = new int[26];
		for(char c : s.toCharArray()) {
			hash[(int)c - 'a']++;
		}
		for(int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(hash[(int)c - 'a'] == 1) return i;
		}
		return -1;
    }

}