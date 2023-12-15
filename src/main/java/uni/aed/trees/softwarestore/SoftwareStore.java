package uni.aed.trees.softwarestore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SoftwareStore {
    private SoftwareNode root;
    private String fileName;

    public SoftwareStore(String fileName) {
        this.root = null;
        this.fileName = fileName;
        readFromFile();
    }

    // Method to read software information from the file and build the BST
    private void readFromFile() {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int position = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                String name = parts[0];
                String version = parts[1].toString();
                int quantity = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                SoftwareNode newNode = new SoftwareNode(name, version, quantity, price, position);
                root = insert(root, newNode);
                position++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to insert a new node into the BST
    private SoftwareNode insert(SoftwareNode root, SoftwareNode newNode) {
        if (root == null) {
            return newNode;
        }

        int compareResult = newNode.name.compareTo(root.name);

        if (compareResult < 0) {
            root.left = insert(root.left, newNode);
        } else if (compareResult > 0) {
            root.right = insert(root.right, newNode);
        } else {
            // Node with the same name already exists, update quantity
            root.quantity += newNode.quantity;
        }

        return root;
    }

    // Method to update the tree and file when a software package is sold
    public void sellSoftware(String name, String version, int quantitySold) {
        SoftwareNode node = findNode(root, name, version);

        if (node != null) {
            node.quantity -= quantitySold;
            updateFile();
            if (node.quantity <= 0) {
                // If quantity becomes 0 or less, delete the node
                root = deleteNode(root, name, version);
            }
        } else {
            System.out.println("Software not found.");
        }
    }

    // Method to delete a node from the BST
    private SoftwareNode deleteNode(SoftwareNode root, String name, String version) {
        if (root == null) {
            return root;
        }

        int compareResult = (name + version).compareTo(root.name + root.version);

        if (compareResult < 0) {
            root.left = deleteNode(root.left, name, version);
        } else if (compareResult > 0) {
            root.right = deleteNode(root.right, name, version);
        } else {
            // Node with the given name and version found
            // If the node has one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // If the node has two children, get the inorder successor (smallest in the right subtree)
            root.name = minValueNode(root.right).name;
            root.version = minValueNode(root.right).version;
            root.quantity = minValueNode(root.right).quantity;

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.name, root.version);
        }

        return root;
    }

    // Method to find the node with the minimum value in a BST
    private SoftwareNode minValueNode(SoftwareNode root) {
        SoftwareNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Method to find a node in the BST
    private SoftwareNode findNode(SoftwareNode root, String name, String version) {
        if (root == null || (root.name.equals(name) && root.version.equals(version))) {
            return root;
        }

        int compareResult = (name + version).compareTo(root.name + root.version);

        if (compareResult < 0) {
            return findNode(root.left, name, version);
        } else {
            return findNode(root.right, name, version);
        }
    }

    // Method to update the file with the current BST information
    private void updateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            inorderWriteToFile(root, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Inorder traversal to write nodes to the file
    private void inorderWriteToFile(SoftwareNode root, BufferedWriter writer) throws IOException {
        if (root != null) {
            inorderWriteToFile(root.left, writer);
            writer.write(root.name + " " + root.version + " " + root.quantity + " " + root.price);
            writer.newLine();
            inorderWriteToFile(root.right, writer);
        }
    }    
    // Method to display the menu
    public void displayMenu() {
        System.out.println("1. Sell Software");
        System.out.println("2. Exit");
    }
     // Method to clean up the file by moving entries from the end to positions with 0 quantities
    public void cleanUpFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("cleaned_" + fileName))) {

            String line;
            int position = 0;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                String version = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);

                if (quantity > 0) {
                    writer.write(name + " " + version + " " + quantity + " " + price);
                    writer.newLine();
                }

                position++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rename the cleaned file to the original file
        new File("cleaned_" + fileName).renameTo(new File(fileName));
    }
}
