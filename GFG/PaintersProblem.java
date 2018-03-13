//From Google archives
//We have to paint n boards of length {A1, A2, .. An}. 
//There are k painters available and each takes 1 unit time to paint 1 unit of board. 
//The problem is to find the minimum time to get this job done under the constraints that any painter 
//will only paint continuous sections of boards, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
	
class PaintersProblem {
	
	public static void main(String args[]) {
		int A[] = {10,20,30,40};
		int k = 3;
		System.out.println(new PaintersProblem().minimumPaintTime(A, k));
	}

	public int minimumPaintTime(int A[], int k) {
		int n = A.length;
		int[][] buf = new int[k+1][n+1];
		int[] cumulativeAreaSum = new int[n+1];

		for(int i = 1; i <= n; i++) {
			cumulativeAreaSum[i] = cumulativeAreaSum[i-1] + A[i-1];
			buf[1][i] = cumulativeAreaSum[i];
		}

		//DP
		for(int i = 2; i <= k; i++) {
			for(int j = 1; j <= n; j++) {
				int minTime = Integer.MAX_VALUE;
				for(int r = 1; j - r > 0; r++) {
					int paintTimeForCurrentPainter = cumulativeAreaSum[j] - cumulativeAreaSum[r];
					minTime = Math.min(minTime, Math.max(buf[i-1][r], paintTimeForCurrentPainter));
				}
				buf[i][j] = minTime; 
			}
		}
		return buf[k][n];
	}
}