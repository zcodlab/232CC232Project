package uni.aed.directorio;
import uni.aed.model.Persona;
import java.util.*;

public class DirectorioV3 implements Directorio{
    private static final int  DEFAULT_SIZE = 25;
    
    private Map   entry;

    public DirectorioV3( ) {
        this( DEFAULT_SIZE );
    }
  
    public DirectorioV3(int size) {
        entry = new HashMap(size); 
    }

public void add( Persona newPersona ) {
    entry.put(newPersona.getName(), newPersona);
}

public boolean delete( String searchName ) {
    boolean status;
    Persona  p = (Persona) entry.remove(searchName);
    if (p == null) {
        status = false;
    } else {
        status = true;
    }
    return status;
}

public Persona search( String searchName ) {
    return (Persona) entry.get(searchName);
}

public Persona[ ] sort ( int attribute) {

    if (!(attribute == Persona.NAME || attribute == Persona.AGE) ) {
        throw new IllegalArgumentException( );
    }
    Persona[ ] sortedList = new Persona[entry.size()];
    entry.values().toArray(sortedList);
    Arrays.sort(sortedList, getComparator(attribute));
    return sortedList;
}

public Persona[ ] sort ( int attribute, String algoritmo) {
    throw new UnsupportedOperationException("Método pendiente de implementar");        
}
    
private Comparator getComparator(int attribute) {
    Comparator comp = null;
    if (attribute == Persona.AGE) {
        comp = new AgeComparator( );
    } else {
        assert attribute == Persona.NAME:
                "Attribute not recognized for sorting";
        comp = new NameComparator( );
    }
    return comp;
}

@Override
public int search(Object searchValue, String algoritmo) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
}
    
//Clase interna para comparar Edad
class AgeComparator implements Comparator {

    private final int LESS = -1;
    private final int EQUAL = 0;
    private final int MORE  = 1;

    public int compare(Object p1, Object p2) {
        int comparisonResult;

        int p1age = ((Persona)p1).getAge( );
        int p2age = ((Persona)p2).getAge( );

        if (p1age < p2age) {
            comparisonResult = LESS;
        } else if (p1age == p2age) {
            comparisonResult = EQUAL;
        } else {
            assert p1age > p2age;
            comparisonResult = MORE;
        }

        return comparisonResult;
    }
}

//Clase interna para comparar Nombre
class NameComparator implements Comparator {

    public int compare(Object p1, Object p2) {

        String p1name = ((Persona)p1).getName( );
        String p2name = ((Persona)p2).getName( );

        return p1name.compareTo(p2name);

    }
}

}