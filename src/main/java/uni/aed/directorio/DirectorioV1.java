package uni.aed.directorio;

import uni.aed.model.Persona;
import uni.aed.ordenamiento.SortObject;
import uni.aed.ordenamiento.SortObjectPerson;
import uni.aed.search.SearchObject;

public class DirectorioV1 implements Directorio{
    private static final int  DEFAULT_SIZE = 25;
    private static final int  NOT_FOUND    = -1;
    private Persona[]   entry;

    public Persona[] getEntry() {
        return entry;
    }
    private int        count;
    
    public DirectorioV1( )
    {
        this( DEFAULT_SIZE );
    }

    public DirectorioV1( int size )
    {
        count = 0;
        if (size <= 0 ) { //valor invalido, usa default
            throw new IllegalArgumentException("Tamaño debe ser positivo");
        }
        entry = new Persona[size];        
    }

    public void add( Persona newPersona )
    {
        if (count == entry.length) {
            enlarge( );
        }        
        entry[count] = newPersona;
        count++;
    }

    public boolean delete( String searchName )
    {
        boolean    status;
        int        loc;
        loc = findIndex( searchName );
        if (loc == NOT_FOUND) {
            status = false;
        }
        else {
            entry[loc] = entry[count-1];
            status = true;
            count--;        
        }
        return status;
    }

    public Persona search( String searchName )
    {
        Persona foundPersona;
        int         loc = 0;
        while ( loc < count &&
                !searchName.equals( entry[loc].getName() ) ) {
            loc++;
        }
        if (loc == count) {
            foundPersona = null;
        }
        else {
            foundPersona = entry[loc];
        }
        return foundPersona;
    }
    public Persona[ ] sort ( int attribute) {
        if (!(attribute == Persona.NAME || attribute == Persona.AGE) ) {
            throw new IllegalArgumentException( );
        }
        Persona[ ] sortedList = new Persona[ count ];
        Persona p1, p2, temp;
        //copiamos las referencias a la lista ordenada
        for (int i = 0; i < count; i++) {
            sortedList[i] = entry[i];
        }
        //establecemos el atributo de comparacion
        entry[0].setCompareAttribute( attribute );
        //iniciamos el ordenamiento metodo de la burbuja en sortedList
        int       bottom, comparisonResult;
        boolean   exchanged = true;
        bottom = sortedList.length - 2;
        while ( exchanged )  {
            exchanged = false;
            for (int i = 0; i <= bottom; i++) {
                p1 = sortedList[i];
                p2 = sortedList[i+1];
               // comparisonResult = p1.compareTo( p2, attribute );
                comparisonResult = p1.compareTo( p2 );
                if ( comparisonResult > 0 ) { //p1 es mayor que p2, intercambiar
                    sortedList[i]    = p2;    
                    sortedList[i+1]  = p1;
                    exchanged  = true; //exchange is made
                }
            }
            bottom--;
        }
        return sortedList;
    }

    public Persona[] sort ( int attribute,String algoritmo ) {
        if (!(attribute == Persona.NAME || attribute == Persona.AGE) ) {
            throw new IllegalArgumentException( );
        }  
        Persona[] sortedList = new Persona[ count ];        
        //copiamos las referencias a la lista ordenada
        entry[0].setCompareAttribute(attribute);
        for (int i = 0; i < count; i++)
            sortedList[i] = entry[i];        
        SortObjectPerson o=new SortObjectPerson(); 
        switch(algoritmo.toUpperCase()){
            case "BURBUJA"->{//burbuja                
                o.Burbuja(sortedList, attribute);                
            }
            case "INSERCION"->{
                o.Insercion(sortedList, attribute);                
            }
            case "HEAPSORT"->{
                Object[ ] sortedObjectList;
                sortedObjectList=(Object[])sortedList;                              
                SortObject sortObject=new SortObject();                 
                sortedList=(Persona[])sortObject.HeapSort(sortedObjectList);                
            }
        }//end switch
        return sortedList;
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

    @Override
    public int search(Object searchValue,String algoritmo) {
        Object[ ] searchList = new Persona[ count ];    
        int result=NOT_FOUND;
        //copiamos las referencias a la lista ordenada        
        for (int i = 0; i < count; i++) {
            searchList[i] = entry[i];
        }
        SearchObject s=new SearchObject();    
        switch(algoritmo.toUpperCase()){
            case "LINEAL"->{
                result= s.Lineal(searchList, searchValue);
            }
            case "BINARIA"->{
                result= s.Binaria(searchList, searchValue);
            }
        }
        return result;
    }
}
