package uni.aed.trees;

public class TestBST {
    public static void main(String[] args){
        BST arbol=new BST();
        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.insert(20);
        arbol.insert(40);
        arbol.insert(60);
        arbol.insert(80);
        System.out.println("Recorrido preorder del arbol");
        arbol.preorder();
    }
}
