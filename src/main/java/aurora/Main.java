package aurora;

import spark.Spark;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        URLMapper mapper = new URLMapper(new Random());
        URLMapHandler handler = new URLMapHandler(mapper);

        Spark.post("/", handler::saveUrl);
        Spark.get("/:token", handler::getUrl);
    }
}