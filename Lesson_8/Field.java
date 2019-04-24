import java.awt.*;

class Field {
    private final int FIELD_SIZE;
    private final int CELL_SIZE;
    private final char GAMERS_DOT = 'x';
    private final char BOT_DOT = 'o';
    private final char EMPTY_DOT = '.';
    private final String MSG_DRAW = "Ничья, но можно считать, что бот победил";
    private final String MSG_GAMERS_WON = "Вы победили, вам повезло просто!";
    private final String MSG_BOT_WON = "Победил бот, которого создавали 2 часа...";

    private char[][] map;
    private String gameOverMsg;

    Field(int field_size, int cell_size) {
        FIELD_SIZE = field_size;
        CELL_SIZE = cell_size;
        map = new char[FIELD_SIZE][FIELD_SIZE];
        init();
    }

    void init() {
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
                map[i][j] = EMPTY_DOT;
        gameOverMsg = null;
    }

    int getSize() { return FIELD_SIZE; }

    char getGamersDot() { return GAMERS_DOT; }

    char getBotDot() { return BOT_DOT; }

    boolean isGameOver() { return gameOverMsg != null; }

    String getGameOverMsg() { return gameOverMsg; }

    void setDot(int x, int y, char dot) {
        map[x][y] = dot;
        if (checkWin(GAMERS_DOT))
            gameOverMsg = MSG_GAMERS_WON;
        else if (checkWin(BOT_DOT))
            gameOverMsg = MSG_BOT_WON;
        else if (isMapFull())
            gameOverMsg = MSG_DRAW;
    }

    boolean isMapFull() {
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
                if (map[i][j] == EMPTY_DOT)
                    return false;
        return true;
    }

    boolean checkWin(char dot) {
        for (int i = 0; i < FIELD_SIZE; i++)
            if ((map[i][0] == dot && map[i][1] == dot && map[i][2] == dot) ||
                    (map[0][i] == dot && map[1][i] == dot && map[2][i] == dot))
                return true;
        if ((map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) ||
                (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot))
            return true;
        return false;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > FIELD_SIZE - 1 || y > FIELD_SIZE - 1)
            return false;
        if (map[x][y] == EMPTY_DOT)
            return true;
        return false;
    }

    public void paint(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.lightGray);
        for (int i = 1; i < FIELD_SIZE; i++) {
            g.drawLine(0, i*CELL_SIZE, FIELD_SIZE*CELL_SIZE, i*CELL_SIZE);
            g.drawLine(i*CELL_SIZE, 0, i*CELL_SIZE, FIELD_SIZE*CELL_SIZE);
        }

        g.setStroke(new BasicStroke(5));

        for (int y = 0; y < FIELD_SIZE; y++) {
            for (int x = 0; x < FIELD_SIZE; x++) {
                if (map[x][y] == GAMERS_DOT) {
                    g.setColor(Color.blue);
                    g.drawLine(x*CELL_SIZE+CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4,
                            (x+1)*CELL_SIZE-CELL_SIZE/4, (y+1)*CELL_SIZE-CELL_SIZE/4);
                    g.drawLine(x*CELL_SIZE+CELL_SIZE/4, (y+1)*CELL_SIZE-CELL_SIZE/4,
                            (x+1)*CELL_SIZE-CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4);
                }
                if (map[x][y] == BOT_DOT) {
                    g.setColor(Color.red);
                    g.drawOval(x*CELL_SIZE+CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4,
                            CELL_SIZE/2,
                            CELL_SIZE/2);
                }
            }
        }
    }
}