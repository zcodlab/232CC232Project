package uni.aed.cap17TDA;

public class Casillero4<T extends Number> {
    private Object contenido;

    public Casillero4() {
        this(null);
    }

    public Casillero4(Object contenido) {
        this.contenido = contenido;
    }
    
    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public Object getContenido() {
        return contenido;
    }
    
}
