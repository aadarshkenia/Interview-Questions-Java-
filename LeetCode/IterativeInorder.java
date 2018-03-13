import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


class IterativeInorder{
	public static void main(String args[]){
		int x[] = {1,2,3,4,5,6,7};
		Tree tree = new Tree(x);
		//tree.dfs(tree.root);
		List<Integer> ans = null;
		try{
			ans = inOrderTraversal(tree.root);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(ans);
	}
	
	public static List<Integer> inOrderTraversal(TreeNode root){
		List<Integer> result = new ArrayList();
		Stack<TreeNode> stack = new Stack();

		TreeNode curr = root;
		while(curr != null || !stack.empty()){
			while(curr != null){
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			result.add(curr.val);
			curr = curr.right;
		}
		return result;

	}

}
