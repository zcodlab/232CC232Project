package uni.aed.model;
/*
Ejemplo del Cap17-pag972
Subclase de Caja
*/
public class CajaMagica<T> extends Caja {
    private T contenido;

    public CajaMagica() {
        super();//asigna numero ID
        setContenido(null);
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }
}
