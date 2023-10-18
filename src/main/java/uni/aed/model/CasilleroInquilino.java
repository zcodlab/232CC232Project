package uni.aed.model;
/*
Ejemplo del Cap17-pag970
Subclase con dos tipos de parametros, 
el primero heredado de la superclase
*/
public class CasilleroInquilino<T,R> extends Casillero<T> {
    private R inquilino;

    public CasilleroInquilino() {
        this(null,null);
    }

    public CasilleroInquilino(T contenido,R inquilino) {
        super();
        setContenido(contenido);
        setInquilino(inquilino);        
    }

    public void setInquilino(R inquilino) {
        this.inquilino = inquilino;
    }

    public R getInquilino() {
        return inquilino;
    }
    
    
    
}
