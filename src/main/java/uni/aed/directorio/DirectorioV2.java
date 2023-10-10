package uni.aed.directorio;

import uni.aed.model.Persona;
import java.util.Arrays;
import java.util.Comparator;

public class DirectorioV2 implements Directorio{
    
    private static final int  DEFAULT_SIZE = 25;    
    private static final int  NOT_FOUND    = -1;
    private Persona[]   entry;
    private int        count;

    public DirectorioV2( ) {
        this( DEFAULT_SIZE );
    }
    
    public DirectorioV2(int size) {
        count = 0;
        if (size <= 0 ) { 
            throw new IllegalArgumentException("Size must be positive");
        }
        entry = new Persona[size]; 
    }
    public void add( Persona newPersona ) {
        if (count == entry.length) {
            enlarge( );             
        }        
        entry[count] = newPersona;
        count++;
    }
    
    public boolean delete( String searchName ) {
        boolean    status;
        int        loc;
        loc = findIndex( searchName );
        if (loc == NOT_FOUND) {
            status = false;
        } else { 
            entry[loc] = entry[count-1];
            status = true;
            count--;        
        }
        return status;
    }    
    public Persona search( String searchName ) {
        Persona foundPersona;
        int    loc = 0;
        while ( loc < count &&
                !searchName.equals( entry[loc].getName() ) ) {
            loc++;
        }

        if (loc == count) {
            foundPersona = null;
        } else {
            foundPersona = entry[loc];
        }
        return foundPersona;
    }
    
    @Override
    public Persona[ ] sort ( int attribute ) {
        if (!(attribute == Persona.NAME || attribute == Persona.AGE) ) {
            throw new IllegalArgumentException( );
        }
        Persona[ ] sortedList = new Persona[ count ];        
        for (int i = 0; i < count; i++) {
            sortedList[i] = entry[i];
        }
        Arrays.sort(sortedList, getComparator(attribute));
        return sortedList;
    }
    @Override
    public Persona[ ] sort ( int attribute,String algoritmo ) {        
        throw new UnsupportedOperationException("Método pendiente de implementar");        
    }

    private void enlarge( )
    {
        int newLength = (int) (1.5 * entry.length);
        Persona[] temp = new Persona[newLength];     
        for (int i = 0; i < entry.length; i++) {
            temp[i] = entry[i];
        }        
        entry = temp;   
    }    
    
    private int findIndex( String searchName )
    {
        int loc = 0;
        while ( loc < count &&
                !searchName.equals( entry[loc].getName() ) ) {
            loc++;
        }
        if (loc == count) {
            loc = NOT_FOUND;
        }
        return loc;
    }
    
    private Comparator getComparator(int attribute) {
        Comparator comp = null;
        if (attribute == Persona.AGE) {
            comp = new AgeComparator( );
        } else {
            assert attribute == Persona.NAME:
                    "Atributo no reconocido por el ordenamiento";
            comp = new NameComparator( );
        }
        return comp;
    }   

    @Override
    public int search(Object searchValue,String algoritmo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}

class AgeComparator implements Comparator {
    private final int LESS = -1;
    private final int EQUAL = 0;
    private final int MORE  = 1;

    @Override
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

class NameComparator implements Comparator {
    @Override
    public int compare(Object p1, Object p2) {
        String p1name = ((Persona)p1).getName( );
        String p2name = ((Persona)p2).getName( );
        return p1name.compareTo(p2name);
    }
}
