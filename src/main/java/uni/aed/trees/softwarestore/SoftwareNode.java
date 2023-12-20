package uni.aed.trees.softwarestore;

/* La clase SoftwareNode: Representa un nodo en un árbol que almacena información de paquetes de software. 
Cada nodo contiene datos como el nombre, versión, cantidad, precio y posición en el archivo. 
También tiene referencias a nodos hijos en el árbol. Esta clase organiza la información de los paquetes de software 
en la tienda.*/
public class SoftwareNode {
    String name;        // Nombre del paquete de software
    String version;     // Versión del paquete de software
    int quantity;       // Cantidad disponible en la tienda
    int price;          // Precio del paquete de software
    int filePosition;   // Posición del registro en el archivo de software

    SoftwareNode left;  // Referencia al nodo izquierdo en el árbol binario
    SoftwareNode right; // Referencia al nodo derecho en el árbol binario

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
