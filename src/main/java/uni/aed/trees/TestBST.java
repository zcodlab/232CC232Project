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
