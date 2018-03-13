import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class SimplifyPath{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String path = br.readLine();
		System.out.println(simplifyPath(path));
	}
	static public String simplifyPath(String path) {

		ArrayList<String> paths = new ArrayList();
		String[] tokens = path.split("/");
		for (String token : tokens){
			if(token.equals(".") || token.equals(""))
				continue;
			else if(token.equals("..")){
				if(paths.size() > 0)
					paths.remove(paths.size()-1);
			}
			else
				paths.add(token);
		}
		return constructPath(paths);
    }

    static String constructPath(ArrayList<String> paths){
    	StringBuilder sb = new StringBuilder("/");
    	int size = paths.size();
    	for(int i=0; i < size; i++){
    		//System.out.println(paths.get(i));
    		sb.append(paths.get(i));
    		if(i != size-1)
    			sb.append("/");
    	}
    	return sb.toString();
    }
}