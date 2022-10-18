package aurora;

import java.util.Random;

public class RandomStringGen {
    private final Random rng;
    private static final String alphanum = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private final char[] buf;

    public RandomStringGen(Random rng) {
        this.rng = rng;
        buf = new char[5];
    }

    public String generate() {
        for (int i = 0; i < buf.length; i++) {
            buf[i] = alphanum.charAt(rng.nextInt(buf.length));
        }
        return new String(buf);
    }

}
