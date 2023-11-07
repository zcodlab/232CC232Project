package uni.aed.trees;

public class BSTNode {
    protected int key;
    protected BSTNode left,right;

    public BSTNode() {
        left=right=null;
    }

    public BSTNode(int key) {
        this.key = key;
    }

    public BSTNode(int key, BSTNode left, BSTNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
    
}
