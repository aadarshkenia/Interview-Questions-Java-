class MaximalRectangle{
	
	public static void main(String args[]){
		String s[] = {"01101","11010","01110","11110","11111","00000"};
		char m[][] = getMatrix(s);
		for(int i=0; i < 1; i++)
        	for(int j=0; j < 3; j++)
        		m[i][j] = '1';
		System.out.println(maximalRectangle(m));
	}


	public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0)
        	return 0;
        int n = matrix[0].length;

        int w[][] = new int[m][n];
        int h[][] = new int[m][n];

        
        w[0][0] = matrix[0][0] - 48;
        h[0][0] = matrix[0][0] - 48;
        int max = matrix[0][0] - 48;
        //Fill up top row
        for(int i = 1; i < n; i++){
        	if(matrix[0][i] == '1'){
        		h[0][i] = 1;
        		w[0][i] = w[0][i-1] + 1;
        		max = max(w[0][i], h[0][i], max);
        	}        	
        }

        //Fill up leftmost col
        for(int i = 1; i < m; i++){
        	if(matrix[i][0] == '1'){
        		w[i][0] = 1;
        		h[i][0] = h[i-1][0] + 1;
        		max = max(w[i][0], h[i][0], max);
        	}        	
        }

        for(int i=1; i < m; i++){
        	for(int j=1; j < n; j++){

        		if(matrix[i][j] == '1'){
        			//w[i][j] = w[i][j-1] + 1;//wrong
        			//h[i][j] = h[i-1][j] + 1;//wrong

        				

        			int min_w = min(w[i-1][j], w[i-1][j-1], w[i][j-1]);
        			int min_h = min(h[i-1][j], h[i-1][j-1], h[i][j-1]);
        			
        			w[i][j] = min_w + 1;
        			h[i][j] = min_h + 1;

        			System.out.println("i: "+i+" j:"+j+" min_w: "+min_w+" min_h: "+min_h);
        			max = Math.max(max((min_w+1)*(min_h+1), w[i][j], h[i][j]), max);
        			System.out.println("max: "+max);
        		}        		
        	}
        }
        return max;
    }


    public static int min(int x, int y, int z){
    	return Math.min(Math.min(x,y), z);
    }

    public static int max(int x, int y, int z){
    	return Math.max(Math.max(x,y), z);
    }

    public static char[][] getMatrix(String[] s){
    	int m = s.length;
    	int n = s[0].length();

    	char mat[][] = new char[m][n];
    	for(int i=0; i < m ; i++){
    		String str = s[i];
    		for(int j=0; j < n; j++){
    			mat[i][j] = str.charAt(j);
    		}
    	}
    	return mat;
    }
}