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
    public void deleteByMerging(int e1){
        BSTNode tmp,node,p=root, prev=null;
        //encontrar el nodo p con el elemento e1
        while(p!=null && p.key!=e1){
            prev=p;
            if(p.key<e1)
                p=p.right;
            else
                p=p.left;                        
        }
        node=p;
        if(p!=null && p.key==e1){
            //determinar si el nodo tiene hijo(izq,right,ambos
            if(node.right==null)
                node=node.left;//el nodod tiene hijo izq
            else if(node.left==null)
                node=node.right;//el nodod tiene hijo der
            else {//recurrir a la fusion de subarboles
                tmp=node.left;
                while(tmp.right!=null)
                    tmp=tmp.right;
                //establecer el enlace entre el nodo del extremo derecho 
                //del subarbol izq y el subarbol der
                tmp.right=node.right;
                node=node.left;
            }
            if (p==root)
                root=node;
            else if(prev.left==p)
                prev.left=node;
            else
                prev.right=node;                
        }
        else if(root!=null)
            System.out.println("El valor "+ e1 + "no se encuentra en el arbol" );
        else System.out.println("El arbol esta vacio" );
    }
    //Imlementacion de algoritmo de elimnacion por copiado
    public void deleteByCopying(int e1){
        BSTNode tmp,node,p=root, prev=null,previous;
        //encontrar el nodo p con el elemento e1
        while(p!=null && p.key!=e1){
            prev=p;
            if(p.key<e1)
                p=p.right;
            else
                p=p.left;                        
        }
        node=p;
        if(p!=null && p.key==e1){
            if(node.right==null)//no tiene hijo derecho
                node=node.left;
            else if (node.left==null)//no tiene hijo izq
                node=node.right;
            else{//el nodo tiene dos hijos
                tmp=node.left;
                previous=node;
                while(tmp.right!=null){
                    previous=tmp;
                    tmp=tmp.right;
                }
                node.key=tmp.key;//copia la referencia del nodo que se esta elimnando
                if(previous==node)
                    previous.left=tmp.left;
                else
                    previous.right=tmp.left;                            
            }
            if(p==root)
                root=node;
            else if(prev.left==p)
                prev.left=node;
            else prev.right=node;                
        }
        else if(root!=null)
            System.out.println("El valor "+ e1 + "no se encuentra en el arbol" );
        else System.out.println("El arbol esta vacio" );
            
    }
    
}
