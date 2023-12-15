package uni.aed.trees.softwarestore;

public class SoftwareNode {
    String name;
    String version;
    int quantity;
    int price;
    int filePosition;

    SoftwareNode left;
    SoftwareNode right;

    public SoftwareNode(String name, String version, int quantity, int price, int filePosition) {
        this.name = name;
        this.version = version;
        this.quantity = quantity;
        this.price = price;
        this.filePosition = filePosition;
        this.left = this.right = null;
    }
}
