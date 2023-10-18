package uni.aed.model;
/*
    Ejemplo del Cap17-pag972
*/
public class Caja {
    private static int contadorId=100;
    private int id;

    public Caja() {
        this.id = contadorId++;
    }

    public int getId() {
        return id;
    }
    
    
}
