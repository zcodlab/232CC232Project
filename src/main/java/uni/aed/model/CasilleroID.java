package uni.aed.model;
/*
Ejemplo del Cap17-pag970
Subclase de una superclase generica
*/
public class CasilleroID<T> extends Casillero<T> {
    private int id;
    private static int contadorId=100;

    public CasilleroID(){
        this(null);
    }
    public CasilleroID(T contenido) {
        super();
        this.id = contadorId++;
        setContenido(contenido);
    }

    public int getId() {
        return id;
    }
}
