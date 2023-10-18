package uni.aed.cap1710Directorio;

import java.util.Arrays;
import uni.aed.model.Persona;

public class Directorio<T extends Persona>{
    private static final int  DEFAULT_SIZE = 25;
    private static final int  NOT_FOUND    = -1;    
    private Object[]   entry;
    private int   count;   

    public T[] getEntry() {
        return (T[])entry;
    }

    public void setEntry(T[] entry) {
        this.entry = entry;
    }    

    public Directorio( int size )
    {
        count = 0;
        if (size <= 0 ) { //valor invalido, usa default
            throw new IllegalArgumentException("Tamaño debe ser positivo");
        }               
        entry = new Object[size];                
    }

    public void add( T nuevo )
    {
        if (count == entry.length) {
            enlarge( );
        }        
        entry[count] = (Object)nuevo;
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
    
    public void deleteAll( String searchName )
    {
        int i=0;
        while(i< count){            
            if (searchName.equals( ((Persona)entry[i]).getName() ) ) {                
                entry[i] = entry[count-1];                
                entry[count-1]= null;
                count--;        
            }
            i++;
        }     
    }
    
    public void delete(T elemento){
        int loc=NOT_FOUND;
        for (int i = 0; i < entry.length; i++) {
            if (entry[i].equals(elemento)) {
                loc = i;
                break;
            }
        }
        if (loc != NOT_FOUND) {
            for (int i = loc; i < entry.length - 1; i++) {
                entry[i] = entry[i + 1];
            }
            entry[count - 1] = null;
            count--;
        }
    }

    public T search( String searchName )
    {
        T foundPersona;
        int         loc = 0;
        while ( loc < count &&
                !searchName.equals( ((Persona)entry[loc]).getName() ) ) {
            loc++;
        }
        if (loc == count) {
            foundPersona = null;
        }
        else {
            foundPersona = (T)entry[loc];
        }
        return foundPersona;
    }
    
    public T search(T elemento) {
        for (int i = 0; i < entry.length; i++) {
            if (entry[i].equals(elemento)) {
                return (T)entry[i];
            }
        }
        return null;
    }
   
    private void enlarge( )
    {        
        int newLength = (int) (1.5 * entry.length);
        Object[] temp = new Object[newLength];        
        for (int i = 0; i < entry.length; i++) {
            temp[i] = entry[i];
        }        
        entry = temp;   
    }   
    
     private int findIndex( String searchName )
    {
        int loc = 0;
        while ( loc < count &&
                !searchName.equals( ((Persona)entry[loc]).getName() ) ) {
            loc++;
        }
        if (loc == count) {
            loc = NOT_FOUND;
        }
        return loc;
    }
     
    public void imprimir() {
        for (int i = 0; i < entry.length; i++) {
            if (entry[i]!=null)
                  System.out.println(entry[i]);
        }
    }
    
    public void sort(){
        Arrays.sort(entry,0,entry.length);
    }        
}
