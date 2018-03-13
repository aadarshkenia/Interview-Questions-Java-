import java.io.*;

class MinWindowSubstring{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		System.out.println(minWindow(s, t));
	}

	public static String minWindow(String s, String t){
		int buf[] = new int[128];
		for(int i=0; i < t.length(); i++)
			buf[(int)t.charAt(i)]--;
		
		int minSubstrLen = Integer.MAX_VALUE;
		String minSubstr = "";
		int startIndex = 0, endIndex = -1;
		int slen = s.length();
		for(int i= 0; i < slen; i++){
			char ch = s.charAt(i);
			buf[(int)ch]++;
			if(checkBuf(buf)){
				while(checkBuf(buf)){
					int curLen = i - startIndex + 1;
					if(curLen < minSubstrLen){
						minSubstrLen = curLen;
						minSubstr = s.substring(startIndex, i+1);
					}
					buf[(int)s.charAt(startIndex)]--;
					startIndex++;
				}
			}
		}
		return minSubstr;
	}

	static boolean checkBuf(int buf[]){
		int n = buf.length;
		for(int i=0; i < n; i++)
			if(buf[i] < 0)
				return false;
		return true;
	}

}
