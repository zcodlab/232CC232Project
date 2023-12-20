package uni.aed.trees.softwarestore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*Clase SoftwareStore: Gestiona un inventario de software como un árbol binario de búsqueda (BST).
 Permite operaciones de lectura desde archivo, inserción, venta y eliminación de software,
 así como actualización del archivo de datos basado en cambios en el BST.*/
public class SoftwareStore {
    private SoftwareNode root;
    private String fileName;
    
    // Constructor para inicializar la tienda de software con un archivo de datos.g
    public SoftwareStore(String fileName) {
        this.root = null;
        this.fileName = fileName;
        readFromFile();
    }

    // Método para leer información de software desde el archivo y construir el BST
    /*En la linea 39, se da lectura a cada linea del archivo, esta linea leida se 
    divide en 4 partes utilizando un separador(puede ser un espacio, una tabulacion, u otro mecanismo)
    Por ejemplo: AdobePhotoshop 7.0 21 580
    Se observa que existen 4 columnas. Esta información
    se descarga en un arreglo de tamaño 4 parseando como corresponde.
    Luego, se creará un nodo en el BST que guarde toda esta información.*/
    private void readFromFile() {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int position = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+");
                if (parts.length!= 4) {
                        System.err.println("Invalid line format: " + line);
                        continue; 
                }
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

    // Método para insertar un nuevo nodo en el Arbol de busqueda binaria(BST)
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

    // Método para actualizar el árbol BST y el archivo cuando se vende un paquete de software
    public void sellSoftware(String name, String version, int quantitySold) {
        SoftwareNode node = findNode(root, name, version);

        if (node != null) {
            node.quantity -= quantitySold;
            updateFile();
            if (node.quantity <= 0) {
                // Si la cantidad es 0 o menor, se elimina el nodo
                root = deleteNode(root, name, version);
            }
        } else {
            System.out.println("Software not found.");
        }
    }
    
    // Metodo para agregar software a la tienda
    public void addSoftware(String name, String version, int quantity, int price) {
        SoftwareNode newNode = new SoftwareNode(name, version, quantity, price, -1); 
        root = insert(root, newNode); //Inserta o suma la cantidad de software
        updateFile(); //Actualiza archivo .txt
    }

    // Metodo para eliminar un nodo del arbol BST
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
            // Nodo con nombre y versión ha sido encontrado
            // Si el nodo tiene un hijo o ningun hijo
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;            
            
            //Si el nodo tiene dos hijos, obtenga el sucesor inorder (el más pequeño en el subárbol derecho)
            root.name = minValueNode(root.right).name;
            root.version = minValueNode(root.right).version;
            root.quantity = minValueNode(root.right).quantity;

            // Elimina el sucesor del orden
            root.right = deleteNode(root.right, root.name, root.version);
        }

        return root;
    }

    // Metodo para ubicar el nodo con el minimo valor en un arbol BST
    private SoftwareNode minValueNode(SoftwareNode root) {
        SoftwareNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Metodo para buscar un nodo en el arbol BST
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

    // Metodo para actualizar el archivo con informacion actualizada del arbol BST
    private void updateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            inorderWriteToFile(root, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Recorrido Inorder para escribir nodos en el archivo
    private void inorderWriteToFile(SoftwareNode root, BufferedWriter writer) throws IOException {
        if (root != null) {
            inorderWriteToFile(root.left, writer);
            writer.write(root.name + " " + root.version + " " + root.quantity + " " + root.price);
            writer.newLine();
            inorderWriteToFile(root.right, writer);
        }
    }   
    
    // Metodo para visualizar el inventario de software
    public void inventarioSoftware() {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            System.out.printf("%-30s %-15s %-10s %-10s%n", "Nombre", "Versión", "Cantidad", "Precio");
            System.out.println("--------------------------------------------------------------------------------");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                if (parts.length >= 4) {
                    String name = parts[0];
                    String version = parts[1];
                    String quantity = parts[2];
                    String price = parts[3];

                    System.out.printf("%-30s %-15s %-10s %-10s%n", name, version, quantity, price);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se pudo encontrar el archivo: " + fileName);
        }
    }
    
    // Metodo para visualizar el menu de opciones
    public void displayMenu() {
        System.out.println("1. Sell Software");//Vender software 
        System.out.println("2. Add Software"); //Agregar software
        System.out.println("3. Ver Inventario");//Visualizar estado actual del inventario u stock 
        System.out.println("4. Exit");
    }
     
    //Método para limpiar el archivo moviendo entradas desde el final a posiciones con 0 cantidades       
    public void cleanUpFile() {        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".tmp"))) {

            String line;
            int position = 0;            
            //se descargar en un arraylist la data del inventario de software del archivo origen
            //con la finalidad de aplicar el requisito de mover todas las entradas desde el final 
            //del archivo a las posiciones marcadas con cantidades 0
            List<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);               
            } 
            //logica para mover todas las entradas desde el final 
            //del archivo a las posiciones marcadas con cantidades 0
            boolean stock=false;            
            while(position<lines.size()){
                line=lines.get(position);
                String[] parts = line.split("\\s+");                  
                int quantity = Integer.parseInt(parts[2]);                
                if (quantity == 0)
                {    
                    while(position<lines.size() && !stock){
                        String lineLast=lines.get(lines.size()-1);
                        String[] partsLast = lineLast.split("\\s+");                
                        int quantityLast = Integer.parseInt(partsLast[2]);
                        if (quantityLast>0){
                            stock=true;
                            lines.set(position, lineLast);//se reemplaza la linea de texto de la ultima ubicacion a la ubicacion actual con stock cero
                        }    
                        lines.remove(lines.size()-1);//se elimina la ultima linea del arraylist                            
                    }
                }
                position++;
            }
            //Descargamos en el archivo de escritura(cleaned) el contenido del arraylist en el cual se a cumplido
            //con el requisito de mover todas las entradas desde el final del archivo a las posiciones marcadas con cantidades 0
            for (String fline : lines) {
                String[] parts = fline.split("\\s+");
                String name = parts[0];
                String version = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                if (quantity > 0) {
                    writer.write(name + " " + version + " " + quantity + " " + price);
                    writer.newLine();
                }                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Renombrando el cleaned file al original file        
        File originalFile = new File(fileName);
        if (originalFile.delete()) {
            File tempFile = new File(fileName + ".tmp");//se aplico un artificio para evitar conflicto por la ruta absoluta de filename
            if (tempFile.renameTo(originalFile))
                System.out.println("Archivo limpiado y actualizado correctamente.");
            else
                System.out.println("Error al renombrar el archivo temporal.");            
        } else
            System.out.println("Error al borrar el archivo original.");
        
    }
}
