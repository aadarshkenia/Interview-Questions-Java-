class LastWordLength{
	public int lengthOfLastWord(String s){
		int n = s.length;
		int end = n-1;
		while(s.charAt(end) == ' ')
			end--;
		for(int i=end; i>=0 ;i--){
			if(s.charAt(i) == ' '){
				return n-1-i;
			}
		}
		return n;
	}
}
