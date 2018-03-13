import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class IterativePreorder{
	public static void main(String args[]){
        int x[] = {1,2,3,4,5,6,7};
        Tree tree = new Tree(x);
        //tree.dfs(tree.root);
        List<Integer> ans = null;
        try{
            ans = preorderTraversal(tree.root);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(ans);
    }


	 public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList();
		Stack<TreeNode> stack = new Stack();
		if(root != null)
			stack.push(root);
		while(!stack.empty()){
			TreeNode curr = stack.pop();
			result.add(curr.val);
			if(curr.right != null)
				stack.push(curr.right);
			if(curr.left != null)	
				stack.push(curr.left);
		}
		return result;
	 }
}
