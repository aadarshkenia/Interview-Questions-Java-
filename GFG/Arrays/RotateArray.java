class RotateArray {
	public static void main(String args[]) {
		int x[] = {1,2,3,4,5,6};
		rotate(x, 4);
		for(int i : x) System.out.print(i+" ");
		System.out.println();
	}

	public static void rotate(int x[], int d) {
		int n = x.length;
		for(int i = 0; i < d; i++) {
			int temp = x[i];
			for(int j = i; j < n; j += d) {
				if(j < n - d) {
					x[j] = x[j + d];	
				} else {
					x[j] = temp;
				}
			}
		}
	}

	public int gcd(int a, int b) {
		if(a%b == 0) return b;
		return gcd(b, a % b);
	}
}