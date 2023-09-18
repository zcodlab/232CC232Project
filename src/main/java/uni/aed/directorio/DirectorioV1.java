package uni.aed.directorio;
import uni.aed.model.Persona;

public class DirectorioV1 implements Directorio{
    private static final int DEFAULT_SIZE=25;    
    private Persona[] entry;  
    private int count;

    public DirectorioV1() {
        this(DEFAULT_SIZE);        
    }
    
    public DirectorioV1(int size) {
        count=0;
        if(size<=0){
            throw new IllegalArgumentException("Tamaño debe ser positivo");
        }
        entry=new Persona[size];
    }
    
    public Persona[] getEntry() {
        return entry;
    }

    @Override
    public void add(Persona newPersona) {
        if(count==entry.length)
            enlarge();
        entry[count]=newPersona;
        count++;
    }

    @Override
    public Persona[] sort(int attribute, String algoritmo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void enlarge(){
        int newLenght=(int)(1.5*entry.length);
        Persona[] temp=new Persona[newLenght];
        for(int i=0;i<entry.length;i++)
            temp[i]=entry[i];
        entry=temp;
    }
    
}
