class _40 {
	public static void main(String args[]) {
		int x[] = {6,1,6,3,6,3,3,1,2,1};
		System.out.println("Number : " + getNumber(x));

	}

	private static int getNumber(int x[]) {
		int counter0 = 0, counter1 = 0;
		for(int i : x) {			
			int counter1_new = ~counter0 & (counter1 ^ i);
			int counter0_new = (~counter0 & counter1 & i) | (counter0 & ~counter1 & ~i);
			counter0 = counter0_new;
			counter1 = counter1_new;
		}
		return counter1;
	}
}