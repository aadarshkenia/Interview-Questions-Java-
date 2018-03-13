import java.util.Queue;
import java.util.LinkedList;

class SymmetricTree{

	public static void main(String args[]){
		int x[] = {1,2,2,3,4,4,3};
		Tree tree = new Tree(x);
		System.out.println(isSymmetric(tree.root));
	}

	public static boolean isSymmetric(TreeNode root){
		if(root==null || isLeaf(root))
			return true;
		Queue<TreeNode> queue = new LinkedList();
		if(queue.size() == 1)
			return false;
		
		queue.add(root.left);
		queue.add(root.right);

		while(!queue.isEmpty() && queue.size() >= 2){
			TreeNode first = queue.remove();
			TreeNode second = queue.remove();
			if(first == null && second == null)
				continue;
			if((first == null && second != null) || (first != null && second == null) || first.val != second.val)
				return false;
			if(first != null && second != null){
				queue.add(first.left);
				queue.add(second.right);
				queue.add(first.right);
				queue.add(second.left);
			}
		}
		return true;
	}

	public static boolean isLeaf(TreeNode root){
		return root.left == null && root.right == null;
	}
}
