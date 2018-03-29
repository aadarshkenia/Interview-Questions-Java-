import java.util.List;
import java.util.ArrayList;
class _17 {
	public static void main(String args[]) {
		String s = "dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext";
		new _17().getLargest(s);
	}

	public String getLargest(String s) {
		// traverse(constructTree(s), 0);
		return "";
	}

	public TreeNode constructTree(String s) {
		// System.out.println("s="+s);
		int n = s.length();

		char ch[] = s.toCharArray();
		int i = 0;
		String dirName = s.substring(0, i);
		int prevStart = -1;
		List<TreeNode> children = new ArrayList<>();
		while(i < n) {
			if((ch[i] == '\\' && s.substring(i, i + 4).equals("\\n\\t") && ch[i+4] != '\\')
					|| i == n - 1) {				
				// System.out.println("i split: " + i);
				if(prevStart == -1) {
					dirName = i != n-1 ? s.substring(0, i) : s.substring(0, n);
					// System.out.println("dirname=" + dirName);
				} else {
					String childStr = i != n-1 ? s.substring(prevStart + 4, i) : s.substring(prevStart + 4, n);
					// System.out.println("childstr="+childStr);
					// System.out.println(childStr.indexOf("\\n\\t"));
					childStr = childStr.replace("\\n\\t", "\\n");
					// System.out.println(String.format("Replaced %s", childStr));
					if(childStr.length() > 0) {
						children.add(constructTree(childStr));	
					}					
				}
				prevStart = i;
				i += 4;
			} else {
				i++;
			}		

		}

		if(dirName.contains(".")) {
			TreeNode file = TreeNode.fromFileName(dirName);
			return file;
		} else {
			TreeNode root = new TreeNode(false, children, dirName);
			return root;	
		}
	}



	private int largest(TreeNode root) {
		return -1;
	}

	private void traverse(TreeNode t, int level) {
		// System.out.println("Traversing " + t.getName() + " size: " + (t.getChildren() != null ?  t.getChildren().size() : "0"));
		String prefix = "";
		for(int i=0; i < level; i++){
			prefix = prefix + "\t";
		}
		System.out.println(prefix + t.getName());
		List<TreeNode> children = t.getChildren();
		if(children != null) {
			for(TreeNode child : children) {
				traverse(child, level+1);
			}
		}
	}
}

class TreeNode {
	private boolean isFile;
	private List<TreeNode> children;
	private String name;

	public TreeNode(boolean isFile, List<TreeNode> children, String name) {
		this.isFile = isFile;
		this.children = children;
		this.name = name; 
	}

	public static TreeNode fromFileName(String name) {
		TreeNode file = new TreeNode();
		file.isFile = true;
		file.name = name;
		return file;
	}

	private TreeNode(){}

	public boolean isFile() {return isFile;}
	public List<TreeNode> getChildren(){return children;}
	public String getName() {return name;}
}