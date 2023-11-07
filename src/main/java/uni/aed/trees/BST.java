package uni.aed.trees;

public class BST {
    protected BSTNode root;

    public BST() {
        root=null;
    }
    //algoritmo de insercion
    public void insert(int e1){
        BSTNode p=root, prev=null;
        while(p!=null){//buscando un lugar para insertar el elemento
            prev=p;
            if(p.key<e1)
                p=p.right;
            else
                p=p.left;
        }
        if(root==null)
            root=new BSTNode(e1);
        else if(prev.key<e1)
            prev.right=new BSTNode(e1);
        else
            prev.left=new BSTNode(e1);
    }
    public void visit(BSTNode p){
        System.out.print(p.key+" ");
    }
    public void preorder(){
        preorder(root);
    }
    public void preorder(BSTNode p){//VLR
        if(p!=null){
            visit(p);
            preorder(p.left);
            preorder(p.right);}
    }
}
