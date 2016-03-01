import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class RestoreIP{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		List<String> ans = restoreIpAddresses(s);
		for(String str: ans)
			System.out.println(str);
	}

	public static List<String> restoreIpAddresses(String s) {
		return helper(s, 4);
	}

	public static List<String> helper(String s, int n){
		List<String> output = new ArrayList();
		if(s.length() < 1 || n < 1)
			return output;

		if(n == 1){
			
			if(s.length() > 3 || s.length() < 1)
				return null;
			if(s.length() == 1){
				output.add(s);
				return output;
			}
			else{
				if(!s.startsWith("0")){
					int ip = Integer.parseInt(s);				
					if(ip >= 0 && ip <= 255){
						output.add(s);
						return output;
					}
				}
				
			
			}
		}
		else{
			//Check for one char
			List<String> children = helper(s.substring(1), n-1);
			if(children != null){
				for(String child : children)
					output.add(s.charAt(0)+"."+child);
			}
			//Check for two chars
			if(s.length() > 2 && s.charAt(0) != '0'){
				String prefix = s.substring(0, 2);
					children = helper(s.substring(2), n-1);
					if(children != null){
						for(String child : children)
							output.add(prefix+"."+child);
					}		
			}
			
			//Check for three chars
			if(s.length() > 3 && s.charAt(0) != '0'){
				String prefix = s.substring(0, 3);
				int prefixInt = Integer.parseInt(prefix);
				if(prefixInt >= 0 && prefixInt <= 255){
					children = helper(s.substring(3), n-1);
					if(children != null){
						for(String child : children)
							output.add(prefix+"."+child);
					}	
				}
			}
			return output;
		}
		return null;
	}

}//class
