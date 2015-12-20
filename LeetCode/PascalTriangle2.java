import java.util.*;
class PascalTriangle2{
    static int[] factorials;
    public static void main(String args[]){
        int rowIndex = Integer.parseInt(args[0]);
        System.out.println(getRow(rowIndex));
    }

    public static List<Integer> getRow(int rowIndex) {
        int n = rowIndex;
        int mid = n/2;
        Integer ans[] = new Integer[n+1];
            
        ans[0] = 1;
        ans[n] = 1;
        long coeff = n;
        for(int i=1; i <= n-i; i++){
            coeff = i == 1 ? n : (coeff * (long)(n-i+1))/(i); 
			if(i == n-i){
				
			} 	         
            ans[i] = (int)coeff;
            ans[n-i] = (int)coeff;
        }
        List<Integer> retval = Arrays.asList(ans);
        return retval;
    }

}
