package aurora;

import spark.Request;
import spark.Response;

public class URLMapHandler {
    private final URLMapper map;

    public URLMapHandler(URLMapper map) {
        this.map = map;
    }

    public Object saveUrl(Request request, Response response) {
        String url = request.body();
        String token = map.save(url);
        response.status(200);
        response.body(token);
        return token;
    }

    public Object getUrl(Request request, Response response) {
        String token = request.params(":token");
        String url = map.get(token);
        if (url == null) {
            response.status(404);
            return false;
        } else {
            response.redirect(url);
        }
        return url;
    }


}
