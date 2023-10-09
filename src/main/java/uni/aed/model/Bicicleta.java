package uni.aed.model;

public class Bicicleta implements Comparable{
    private String nomPropietario;
    
    public Bicicleta(String nombre) {
        nomPropietario=nombre;
    }

    public void setNomPropietario(String nombre) {
        this.nomPropietario = nombre;
    }

    public String getNomPropietario() {
        return nomPropietario;
    }
    
    public String toString( )  {
        return this.nomPropietario;
    }
    
    public int compareTo(Bicicleta o) {
        String    p2name = o.getNomPropietario();
        return this.nomPropietario.compareTo(p2name);
    }
    
    @Override
    public int compareTo(Object o) {
        return compareTo((Bicicleta)o);
    }
    
    
}
