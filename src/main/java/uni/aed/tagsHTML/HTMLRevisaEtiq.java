package uni.aed.tagsHTML;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uni.aed.stack.ArrayStackTDA;
import uni.aed.stack.StackTDA;
public class HTMLRevisaEtiq {
    private StackTDA<HTMLEtiq> etiquetasEnPila;
    private HTMLRecuperaEtiq etiqRecuperada;

    public HTMLRevisaEtiq(String nomArchivo) throws IOException{
        etiquetasEnPila = new ArrayStackTDA<>();
        etiqRecuperada = new HTMLRecuperaEtiq(nomArchivo);
    }

    public StackTDA<HTMLEtiq> getEtiquetasEnPila() {
        return etiquetasEnPila;
    }

    public HTMLRecuperaEtiq getEtiqRecuperada() {
        return etiqRecuperada;
    }
    public boolean esValido(){
        HTMLEtiq etiqSiguiente=null, etiqTope=null;
        boolean nohayError=true, termina=false;
        etiquetasEnPila.clear();
        while(!termina){
            if(!etiqRecuperada.hayMasEtiq()){
                termina=true;
                if(!etiquetasEnPila.isEmpty())
                    nohayError=false;
            }else{
                try{
                    etiqSiguiente=etiqRecuperada.etiqSiguiente();
                }catch(IOException e){
                    Logger.getLogger(HTMLRevisaEtiq.class.getName()).log(Level.SEVERE,null,e);
                }
                if(etiqSiguiente.esEtiquetaApertura())
                    etiquetasEnPila.push(etiqSiguiente);
                else if(etiqSiguiente.esEtiquetaCierre()){
                    etiqTope=etiquetasEnPila.pop();
                    if(!etiqTope.compara(etiqSiguiente)){
                        nohayError=false;
                        termina=true;
                    }
                }                    
                    
            }
        }        
        return nohayError;
    }
}
