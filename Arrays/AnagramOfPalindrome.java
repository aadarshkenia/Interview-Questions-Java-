class AnagramOfPalindrome {
	public boolean isAnagramOfPalindrome(String s) {
		int[] bitVector = new int[4];
		for(int i : s.toCharArray()) {			
			bitVector[i / 32] = bitVector[i / 32] ^ (1 << (i % 32));				
		}
		//Check if atmost one bit is set in the bit vectors
		
		int setBits = 0;
		for(int l : bitVector) {
			while(l != 0) {
				if((l & 1) == 1) {
					setBits += 1;
					if(setBits > 1) return false;					
				}
				l = l >> 1;	
			}
		}
		return true;
	}

	public static void main(String args[]) {
		if(args.length < 1) {
			System.out.println("Enter the input as first command line arg.");
			return;
		}
		System.out.println(new AnagramOfPalindrome().isAnagramOfPalindrome(args[0]));
	}
}