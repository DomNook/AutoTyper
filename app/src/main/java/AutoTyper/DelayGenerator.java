package AutoTyper;

import java.util.Random;
public class DelayGenerator {

    public static Random random = new Random();
    
    public static int getRandomShort() {
        int delay = 15;
        delay += random.nextInt(50);
        return delay;
    }

    public static int getRandomVeryShort() {
        int delay = 5;
        delay += random.nextInt(25);
        return delay;
    }
}
