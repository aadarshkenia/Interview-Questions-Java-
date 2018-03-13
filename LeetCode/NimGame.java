class NimGame{

	public static void main(String args[]){
		int n = 330001212;
		System.out.println(canWinNum(n));
	}

	public static boolean canWinNum(int n){
		if(n <= 0)
		    return false;
		if(n < 4)
		    return true;

		boolean a=true, b=true, c=true;

		for(int i=4;i<=n;i++){
		    boolean temp;
		    if(!a || !b || !c)
		        temp = true;
		    else
		        temp = false;
		    a = b;
		    b = c;
		    c = temp;
		}
		return c;
	}
}