package uni.aed.tagsHTML;

import java.io.IOException;

public class TestTagsHTML {
    public static void main(String[] args){
        try{
            HTMLRevisaEtiq revisa =new HTMLRevisaEtiq("src\\main\\java\\uni\\aed\\tagsHTML\\index.html");
            if(revisa.esValido())
                System.out.println("Archivo HTML es VALIDO");
            else
                System.out.println("Archivo HTML es INVALIDO");
            
        }catch(IOException e){
            System.out.println("Error al abrir el archivo");
        }
        
    }
    
}
