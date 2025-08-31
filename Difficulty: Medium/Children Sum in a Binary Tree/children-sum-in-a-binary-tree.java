/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    private int helper(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.data;
        
        int lsum=helper(root.left);
        if(lsum==Integer.MAX_VALUE) return lsum;
        int rsum=helper(root.right);
        if(rsum==Integer.MAX_VALUE) return rsum;
        
        if(root.data!=lsum+rsum) return Integer.MAX_VALUE;
        return root.data;
    }
    public boolean isSumProperty(Node root) {
        if(root==null) return true;
        if(helper(root)==Integer.MAX_VALUE) return false;
        return true;
        
    }
}