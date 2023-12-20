package uni.aed.trees.softwarestore;

// Clase que representa un nodo del árbol de búsqueda binario SoftwareStore para almacenar software.
public class SoftwareNode {
    String name;        // Nombre del software.
    String version;     // Versión del software.
    int quantity;       // Cantidad disponible del software.
    int price;          // Precio del software
    int filePosition;   // Posición del archivo del software en almacenamiento.

    // Nodo hijo izquierdo, siguiendo la estructura de árbol binario.
    SoftwareNode left;
    // Nodo hijo derecho, siguiendo la estructura de árbol binario.
    SoftwareNode right;

    // Constructor del nodo, inicializa los datos del software y establece los nodos hijos a null.
    public SoftwareNode(String name, String version, int quantity, int price, int filePosition) {
        this.name = name;
        this.version = version;
        this.quantity = quantity;
        this.price = price;
        this.filePosition = filePosition;
        this.left = this.right = null;
    }
     public String getName(){
        return this.name;
    }
    public String getVersion(){
        return this.version;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public int getPrice(){
        return this.price;
    }
    @Override
    public String toString() {
        return name + " " + version + " " + quantity + " " + price;
    }
}
