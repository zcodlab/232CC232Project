package uni.aed.trees;

import java.util.Queue;

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
        if (p!=null)
            System.out.print(p.key+" ");
        else
            System.out.print("Nodo no existe");
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
    public void inorder(){//LVR
        inorder(root);
    }
    public void inorder(BSTNode p){//LVR
        if(p!=null){            
            inorder(p.left);
            visit(p);
            inorder(p.right);}
    }
    
    public void postorder(){//LRV
        postorder(root);
    }
    public void postorder(BSTNode p){//LRV
        if(p!=null){            
            postorder(p.left);
            postorder(p.right);
            visit(p);   
        }         
    }
    public BSTNode search(int e1){
        return search(root,e1);
    }
    public BSTNode search(BSTNode p,int e1){
        while(p!=null){
            if(e1==p.key)
                return p;
            else if(e1<p.key)
                p=p.left;
            else
                p=p.right;                
        }
        return null;
    }
    
    public void breadthFirst(){
        BSTNode p=root;
        QueueTDA queue=new QueueTDA();
        if(p!=null){
            queue.enqueue(p);
            while(!queue.isEmpty()){
                p=(BSTNode)queue.dequeue();
                visit(p);
                if(p.left!=null)
                    queue.enqueue(p.left);
                if(p.right!=null)
                    queue.enqueue(p.right);
            }
        }
    }
    
}
