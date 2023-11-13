package uni.aed.trees.TBT;

public class TBTNode {
    protected int key;
    protected boolean successor;
    protected TBTNode left;
    protected TBTNode right;

    public TBTNode(int key) {
        this(key,null,null);
    }

    public TBTNode(int key, TBTNode left, TBTNode right) {
        this.key = key;
        this.successor = false;
        this.left = left;
        this.right = right;
    }
    
    
    
    
}
