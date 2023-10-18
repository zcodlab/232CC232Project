package uni.aed.model;
/*
    Ejemplo del Cap17-pag970
*/
public class Casillero<T> {
    private T contenido;

    public Casillero() {
        this(null);
    }   
    
    public Casillero(T contenido) {
        this.contenido = contenido;
    }
    
    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }
    
}
