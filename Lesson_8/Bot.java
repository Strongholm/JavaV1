import java.util.Random;

class Bot {
    private final char DOT;
    private Random random;

    Bot(char ch) {
        DOT = ch;
        random = new Random();
    }

    void turn(Field field) {
        int x, y;
        do {
            x = random.nextInt(field.getSize());
            y = random.nextInt(field.getSize());
        } while (!field.isCellValid(x, y));
        field.setDot(x, y, DOT);
    }
}

