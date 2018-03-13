import java.util.List;
import java.util.ArrayList;

class BinaryPaths{
	public static void main(String args[]){
		
	}

	public List<String> binaryTreePaths(TreeNode root){
		List<String> paths = new ArrayList();
		if(root == null)
			return paths;
		
		binaryPaths(root, Integer.toString(root.val), paths);
		return paths;
	}

	private void binaryPaths(TreeNode node, String pathTillNow, List<String> paths){
		String currPath = pathTillNow + "->" + node.val;
		if(isLeaf(node)){
			paths.add(currPath);
		}
		else{
			if(node.left != null)
				binaryPaths(node.left, currPath, paths);
			if(node.right != null)
				binaryPaths(node.right, currPath, paths);
		}
	}

	private boolean isLeaf(TreeNode root){
		if(root != null)
			if(root.left == null && root.right == null)
				return true;
		return false;
	}
}
