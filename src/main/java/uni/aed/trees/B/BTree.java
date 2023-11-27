package uni.aed.trees.B;

import java.util.Collection;

public class BTree<T extends Comparable<T>> implements ITree<T> {
    private int minKeySize;//keytally min
    private int minChildrenSize;//keytally children min
    private int maxKeySize;//keytally max
    private int maxChildrenSize;//keytally children max
    protected Node<T> root = null;
    private int size = 0;
    
    public BTree() {
    }
    
    public BTree(int m) {
        this.minKeySize = (m/2) - 1;
        this.minChildrenSize = (m/2) ;
        this.maxKeySize = m - 1;
        this.maxChildrenSize = m;
    }

    @Override
    public boolean add(T value) {
        if (root == null) {
            root = new Node<>(null, maxKeySize, maxChildrenSize);
            root.addKey(value);
        } else {
            Node<T> node = root;
            while (node != null) {
                if (node.numberOfChildren() == 0) {
                    node.addKey(value);
                    if (node.numberOfKeys() <= maxKeySize)
                        break;                    
                    // necesita dividirse
                    split(node);
                    break;
                }
                // es menor o igual
                T lesser = node.getKey(0);
                if (value.compareTo(lesser) <= 0) {
                    node = node.getChild(0);
                    continue;
                }
                // es mayor que
                int numberOfKeys = node.numberOfKeys();
                int last = numberOfKeys - 1;
                T greater = node.getKey(last);
                if (value.compareTo(greater) > 0) {
                    node = node.getChild(numberOfKeys);
                    continue;
                }
                // busca nodos internos
                for (int i = 1; i < node.numberOfKeys(); i++) {
                    T prev = node.getKey(i - 1);
                    T next = node.getKey(i);
                    if (value.compareTo(prev) > 0 && value.compareTo(next) <= 0) {
                        node = node.getChild(i);
                        break;
                    }
                }
            }
        }
        size++;
        return true;
    }
    /**
     * El tamaño de la clave del nodo es mayor que maxKeySize, dividido por la mitad.     
     * @param nodeToSplit a split     
     */
    private void split(Node<T> nodeToSplit) {
        Node<T> node = nodeToSplit;
        int numberOfKeys = node.numberOfKeys();
        int medianIndex = numberOfKeys / 2;
        T medianValue = node.getKey(medianIndex);

        Node<T> left = new Node<>(null, maxKeySize, maxChildrenSize);
        for (int i = 0; i < medianIndex; i++)
            left.addKey(node.getKey(i));        
        
        if (node.numberOfChildren() > 0) {
            for (int j = 0; j <= medianIndex; j++) {
                Node<T> c = node.getChild(j);
                left.addChild(c);
            }
        }

        Node<T> right = new Node<>(null, maxKeySize, maxChildrenSize);
        for (int i = medianIndex + 1; i < numberOfKeys; i++)
            right.addKey(node.getKey(i));
        
        if (node.numberOfChildren() > 0) {
            for (int j = medianIndex + 1; j < node.numberOfChildren(); j++) {
                Node<T> c = node.getChild(j);
                right.addChild(c);
            }
        }

        if (node.parent == null) {
            // new root, height del arbol es incrementado
            Node<T> newRoot = new Node<>(null, maxKeySize, maxChildrenSize);
            newRoot.addKey(medianValue);
            node.parent = newRoot;
            root = newRoot;
            node = root;
            node.addChild(left);
            node.addChild(right);
        } else {            
            //Mueve el valor medio hacia el padre
            Node<T> parent = node.parent;
            parent.addKey(medianValue);
            parent.removeChild(node);
            parent.addChild(left);
            parent.addChild(right);

            if (parent.numberOfKeys() > maxKeySize) split(parent);
        }
    }

    @Override
    public T remove(T value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean contains(T value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<T> toCollection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String toString() {
        TreePrinter tp=new TreePrinter();
        return tp.getString(this);
    }
}
