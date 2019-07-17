class Gamers {
    private final char DOT;

    Gamers(char ch) { DOT = ch; }

    void turn(int x, int y, Field field, Bot bot) {
        if (field.isCellValid(x, y)) {
            if (!field.isGameOver()) field.setDot(x, y, DOT);
            if (!field.isGameOver()) bot.turn(field);
        }
    }
}