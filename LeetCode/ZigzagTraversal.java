import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class ZigzagTraversal{

	public List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> ans = new ArrayList();
		if(root == null)
			return ans;
		Stack<TreeNode> s1 = new Stack();
		Stack<TreeNode> s2 = new Stack();
		
		s1.push(root);
		Stack<TreeNode> currentStack = s1;
		List<Integer> current = new ArrayList();
		while(!currentStack.empty()){
			TreeNode top = currentStack.pop();
			current.add(top.val);
			if(currentStack == s1){
				if(top.left != null)
					s2.push(top.left);
				if(top.right != null)
					s2.push(top.right);
			}
			else{
				if(top.right != null)
					s1.push(top.right);
				if(top.left != null)
					s1.push(top.left);
			}
			if(currentStack.empty()){
				currentStack = currentStack == s1 ? s2 : s1;
				ans.add(current);
			}	
		}
		return ans;
	}
}
