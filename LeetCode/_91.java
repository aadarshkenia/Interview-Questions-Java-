class _91{
	public static void main(String args[]){
	
	}

	public int numDecodings(String s){
		if(s == null || s.equals("") || s.length() < 1)
			return 0;
		int n = s.length();
		int first = 0;
		int count = 0;
		if(s.charAt(0) - '0' != 0)
			first=1;
		int second = 0;
		if(n == 1)
			return first;
		if(n > 1){
			second = Integer.parseInt(s.substring(0,2));
			if(second >=10 && second <= 26)
				count +=1;
		}
		return 
	}
}
