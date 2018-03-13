import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class _371 {
	public static void main(String args[]) throws IOException {
		// System.out.println(new _371().getSum(3,3));
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Enter two space separated integers: ");
		String s = br.readLine();
		String sp[] = s.split("\\s+");
		int a = Integer.parseInt(sp[0]);
		int b = Integer.parseInt(sp[1]);	
		System.out.println(new _371().getSumPositive(a, b));
		// System.out.println("\n" + (1<<33));
	}

	public int getSumPositive(int a, int b) {
		// System.out.println(String.format("Last a: %d b: %d", a, b));	
    	int sum = 0, carry = 0;
    	int i=0;
    	while(a != 0 || b != 0) {
    		int a_lsb = a & 1;
    		int b_lsb = b & 1;
    		int newSum = (a_lsb & ((b_lsb & carry) | ~(b_lsb | carry))) | (~a_lsb & (b_lsb ^ carry));
    		carry = (a_lsb & b_lsb) | (carry & (a_lsb ^ b_lsb));
    		sum |= (newSum << i++); 
    		a = a>>>1;
    		b = b>>>1;
    	}
    	return i < 32 ? (carry << i) | sum : sum;    
    }

}