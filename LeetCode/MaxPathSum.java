import java.util.HashMap;
/**
 * Definition for a binary tree node.
 * public static class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaxPathSum{
   
    static HashMap<TreeNode, Integer> map = null;

    public static void main(String args[]){
        int x[] = {1,0,1,1,2,0,-1,0,1,-1,0,-1,0,1,0};
        Tree tree = new Tree(x);
        // Tree tree = new Tree();
        // TreeNode n1 = new TreeNode(1);
        // TreeNode n2 = new TreeNode(2);
        // TreeNode n3 = new TreeNode(3);
        // TreeNode n4 = new TreeNode(4);
        // TreeNode n5 = new TreeNode(5);
        // n1.left = n2;
        // n2.left = n3;
        // n3.left = n4;
        // n4.left = n5;
        // tree.root = n1;


        System.out.println("Ans: "+maxPathSum(tree.root));
    }
    
    public static int maxPathSum(TreeNode root){
    
        map = new HashMap();
        //Initialize max sum paths starting at each node.
        maxSumRN(root);
        return maxPathSumHelper(root);
    }    
    
    public static int maxPathSumHelper(TreeNode root) {
        // if(root.left != null)
        //     System.out.println("Left node rn: "+map.get(root.left));
        // if(root.right != null)
        //     System.out.println("Right node rn: "+map.get(root.right));

        if(root == null)
            return Integer.MIN_VALUE;
        if(isLeaf(root))
            return root.val;
        
        //Max sum path including current node
        int maxIncl = root.val;
        int lsum = 0, rsum = 0;
        if(root.left != null)
            lsum = map.get(root.left);
        if(root.right != null)
            rsum = map.get(root.right);
        if(lsum > 0)
            maxIncl += lsum;
        if(rsum > 0)
            maxIncl += rsum;
        
        //Max sum path excluding current node
        int exclLeft = root.left != null ? maxPathSumHelper(root.left) : Integer.MIN_VALUE;
        int exclRight = root.right != null ? maxPathSumHelper(root.right) : Integer.MIN_VALUE;

        // System.out.println("Curr node: "+root.val);

        // if(root.left != null)
        //     System.out.println("EL: "+exclLeft);
        // if(root.right != null)
        //     System.out.println("ER: "+exclRight);


        // System.out.println("maxIncl: "+ maxIncl + " exclLeft: "+exclLeft + " exclRight: "+exclRight);
        return max(maxIncl, exclLeft, exclRight);
    }
    
    public static int maxSumRN(TreeNode root){
        if(root == null)
            return 0;
        if(isLeaf(root)){
            map.put(root, root.val);
            return root.val;
        }
        int retVal = root.val;
        if(root.left != null)
            retVal = Math.max(maxSumRN(root.left) + root.val, retVal);
        if(root.right != null)
            retVal = Math.max(maxSumRN(root.right) + root.val, retVal);
        map.put(root, retVal);
        return retVal;
    }
    
    public static int max(int a, int b, int c){
        if(a >= b && a >= c)
            return a;
        else if(b >= a && b >= c)
            return b;
        else 
            return c;
    }
    
    public static boolean isLeaf(TreeNode node){return node.left == null && node.right == null;}
}