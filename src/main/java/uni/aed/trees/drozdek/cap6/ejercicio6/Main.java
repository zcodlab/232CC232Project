package uni.aed.trees.drozdek.cap6.ejercicio6;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] treeHeights = {500, 1000, 1500, 2000};
        int numIterations = 8;
        for (int height : treeHeights) {
            System.out.println("Altura del Arbol: " + height);
            System.out.println("------------------------------------------------------------------------------");

            for (int i = 0; i < numIterations; i++) {
                Random random1 = new Random(1);
                Random random2 = new Random(2);
                BinarySearchTree tree = generateRandomTree(height, random1);
                if (i % 2 == 0) {
                    System.out.println("Iteracion " + (i + 1) + " - Insercion (Eliminacion Asimetrica)");
                    performAlternatingOperations(tree, random2, true);
                } else {
                    System.out.println("Iteracion " + (i + 1) + " - Insercion (Eliminacion Simetrica)");
                    performAlternatingOperations(tree, random2, false);
                }
                int expectedIPL = calculateExpectedIPL(height);
                System.out.println("IPL Esperada: " + expectedIPL);
                System.out.println("IPL Final: " + tree.getInternalPathLength());
                System.out.println("-----------------------------");
            }
        }
    }    
    private static BinarySearchTree generateRandomTree(int height, Random random) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < (1 << height - 1); i++) {
            tree.insert(random.nextInt(1000000));
        }
        return tree;
    }

    private static int calculateExpectedIPL(int height) {
        return (int) ((1 << (height + 1)) - 1) * (height + 1) / 2; //(2^(h+1) - 1)(h+1) / 2
    }
    
    private static void performAlternatingOperations(BinarySearchTree tree, Random random, boolean asymmetricDeletion) {
        int numOperations = (1 << tree.getHeight()) - 1;//(2^h)-1

        for (int i = 0; i < numOperations; i++) {
            boolean isInsertion = random.nextBoolean();
            int key = random.nextInt(1000000);
            if (isInsertion) {
                tree.insert(key);
            } else {
                if (asymmetricDeletion) {
                    tree.deleteAsymmetric(key);
                } else {
                    tree.deleteSymmetric(key);
                }
            }
        }
    }
}
