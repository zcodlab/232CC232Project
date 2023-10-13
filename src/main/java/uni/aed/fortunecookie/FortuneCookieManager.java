package uni.aed.fortunecookie;

import java.util.List;
import java.util.Random;

public class FortuneCookieManager {
    List<String> fortunas;

    public FortuneCookieManager() {
        FortuneCookieFile fortuneCookieFile=new FortuneCookieFile();
        fortunas=fortuneCookieFile.getLista();
    }
    
    public String nexFortune() {
        Random random = new Random();
        int index = random.nextInt(fortunas.size());
        return fortunas.get(index);
    }
}
