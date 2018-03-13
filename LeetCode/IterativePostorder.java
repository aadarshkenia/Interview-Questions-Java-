import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;

class IterativePostorder{
    public static void main(String args[]){
        int x[] = {1,2,-1, 3};
        Tree tree = new Tree(x);
        //tree.dfs(tree.root);
        List<Integer> ans = null;
        try{
            ans = postorderTraversal(tree.root);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(ans);
    }


     public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        Stack<Integer> stack = new Stack();
		HashMap<TreeNode, TreeNode> map = new HashMap();
				
		TreeNode curr = root;
		while(curr != null){
			stack.push(curr.val);
			if(curr.right != null){
				if(curr.left != null)
					map.put(curr.right, curr.left);
				else
					map.put(curr.right, map.get(curr));
			}
			if(map.containsKey(curr) && curr.left != null)
				map.put(curr.left, (TreeNode)map.get(curr));
			
			TreeNode successor = curr.right != null ? curr.right : curr.left;
			successor = successor == null ? (TreeNode)map.get(curr) : successor;

			curr = successor;
		}
		
		while(!stack.empty())
			result.add(stack.pop());

        return result;
     }

}
