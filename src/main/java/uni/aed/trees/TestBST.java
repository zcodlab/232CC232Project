package uni.aed.trees;

public class TestBST {
    public static void main(String[] args){        
        //TestBSTdeleteByMergingCase1();
        //TestBSTdeleteByMergingCase2();
        //TestBSTdeleteByMergingCase3();
        //TestBSTdeleteByCopyingCase1();
        //TestBSTdeleteByCopyingCase2();
        //TestBSTdeleteByCopyingCase3();
    }
    public static void TestBSTdeleteByCopyingCase3(){
        BST arbol=new BST();
        arbol.insert(20);
        arbol.insert(12);
        arbol.insert(25);
        arbol.insert(14);
        arbol.insert(23);
        arbol.insert(13);
        arbol.insert(16);
        arbol.insert(22);
        arbol.insert(24);
        System.out.println("\n Recorrido preorder del arbol");
        arbol.preorder();  //VLR      
        System.out.println("\n Realizando la eliminacion");
        arbol.deleteByCopying(20);
        System.out.println("\n Recorrido preorder del arbol-despues de elimnar el nodo");
        arbol.preorder();   //VLR     
    }
    
    public static void TestBSTdeleteByCopyingCase2(){
        BST arbol=new BST();
        arbol.insert(20);
        arbol.insert(12);
        arbol.insert(25);
        arbol.insert(14);
        arbol.insert(23);
        arbol.insert(13);
        arbol.insert(16);
        arbol.insert(22);
        arbol.insert(24);
        System.out.println("\n Recorrido preorder del arbol");
        arbol.preorder();        
        System.out.println("\n Realizando la eliminacion");
        arbol.deleteByCopying(12);
        System.out.println("\n Recorrido preorder del arbol-despues de elimnar el nodo");
        arbol.preorder();             
    }

    public static void TestBSTdeleteByCopyingCase1(){
        BST arbol=new BST();
        arbol.insert(15);
        arbol.insert(12);
        arbol.insert(20);
        arbol.insert(10);
        arbol.insert(14);
        arbol.insert(16);
        arbol.insert(22);
        System.out.println("\n Recorrido preorder del arbol");
        arbol.preorder();        
        System.out.println("\n Realizando la eliminacion");
        arbol.deleteByCopying(22);
        System.out.println("\n Recorrido preorder del arbol-despues de elimnar el nodo");
        arbol.preorder(); 
    }
    
    public static void TestBSTdeleteByMergingCase3(){
        BST arbol=new BST();
        arbol.insert(20);
        arbol.insert(12);
        arbol.insert(25);
        arbol.insert(14);
        arbol.insert(23);
        arbol.insert(13);
        arbol.insert(16);
        arbol.insert(22);
        arbol.insert(24);
        System.out.println("\n Recorrido preorder del arbol");
        arbol.preorder();        
        System.out.println("\n Realizando la eliminacion");
        arbol.deleteByMerging(20);
        System.out.println("\n Recorrido preorder del arbol-despues de elimnar el nodo");
        arbol.preorder();      
        
    }
    
    public static void TestBSTdeleteByMergingCase2(){
        BST arbol=new BST();
        arbol.insert(20);
        arbol.insert(12);
        arbol.insert(25);
        arbol.insert(14);
        arbol.insert(23);
        arbol.insert(13);
        arbol.insert(16);
        arbol.insert(22);
        arbol.insert(24);
        System.out.println("\n Recorrido preorder del arbol");
        arbol.preorder();        
        System.out.println("\n Realizando la eliminacion");
        arbol.deleteByMerging(12);
        System.out.println("\n Recorrido preorder del arbol-despues de elimnar el nodo");
        arbol.preorder();      
        
    }    
    
    public static void TestBSTdeleteByMergingCase1(){
        BST arbol=new BST();
        arbol.insert(15);
        arbol.insert(12);
        arbol.insert(20);
        arbol.insert(10);
        arbol.insert(14);
        arbol.insert(16);
        arbol.insert(22);
        System.out.println("\n Recorrido preorder del arbol");
        arbol.preorder();        
        System.out.println("\n Realizando la eliminacion");
        arbol.deleteByMerging(22);
        System.out.println("\n Recorrido preorder del arbol-despues de elimnar el nodo");
        arbol.preorder();      
        
    }
    public static void TestBST(){
        BST arbol=new BST();
        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.insert(20);
        arbol.insert(40);
        arbol.insert(60);
        arbol.insert(80);
        System.out.println("\n Recorrido preorder del arbol");
        arbol.preorder();
        System.out.println("\n Recorrido inorder del arbol");
        arbol.inorder();
        System.out.println("\n Recorrido postorder del arbol");
        arbol.postorder();
        System.out.println("\n Recorrido en amplitud del arbol");
        arbol.breadthFirst();
        System.out.println("\n Realizando busqueda");
        arbol.visit(arbol.search(70));
        System.out.println("\n Realizando 2° busqueda");
        arbol.visit(arbol.search(71));
    }
}
