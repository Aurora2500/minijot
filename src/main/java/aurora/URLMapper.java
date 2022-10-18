package aurora;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class URLMapper {
    private final RandomStringGen rsg;
    private final Map<String, String> URIMap;

    public URLMapper(Random rng) {
        this.rsg = new RandomStringGen(rng);
        this.URIMap = new HashMap<>();
    }

   public String save(String url) {
        String token;

        do {
            token = rsg.generate();
        } while(URIMap.containsKey(token));
        URIMap.put(token, url);
        return token;
   }

   public String get(String token) {
        return URIMap.get(token);
   }
}
