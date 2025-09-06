
public class HangmanImpl implements HangmanInterface {
    private char[][] hangmanAsciiTable;
    boolean hangmanHanged = false;

    public HangmanImpl() {
        hangmanAsciiTable = new char[][] {
                {' ', '-', '-', '-', '-', '-', '-', '-', '+', ' '},
                {' ', '|', '/', ' ', ' ', ' ', ' ', ' ', '|', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'/', '|', '\\', '_', '_', '_', '_', '_', '_', '_'}
        };
    }
    public HangmanImpl(char[][] hangmanAsciiTable, boolean hangmanHanged) {
        this.hangmanAsciiTable = hangmanAsciiTable;
        this.hangmanHanged = hangmanHanged;
    }
    @Override
    public void drawHangman(int level) {
        switch(level) {
            case 1 -> {
                hangmanAsciiTable[3][8] = 'O';
                showHangman();
            }
            case 2 -> {
                hangmanAsciiTable[4][8] = '|';
                hangmanAsciiTable[5][8] = '|';
                showHangman();
            }
            case 3 -> {
                hangmanAsciiTable[4][7] = '/';
                showHangman();
            }
            case 4 -> {
                hangmanAsciiTable[4][9] = '\\';
                showHangman();
            }
            case 5 -> {
                hangmanAsciiTable[6][7] = '/';
                showHangman();
            }
            case 6 -> {
                hangmanAsciiTable[6][9] = '\\';
                showHangman();
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }
    @Override
    public void showHangman() {
        System.out.println("ВИСЕЛИЦА");
        for(int i = 0; i < hangmanAsciiTable.length; ++i) {
            for(int j = 0; j < hangmanAsciiTable[i].length; ++j) {
                System.out.print(hangmanAsciiTable[i][j]);
            }
            System.out.println();
        }
    }

    public char[][] getHangmanAsciiTable() {
        return hangmanAsciiTable;
    }

    public void setHangmanAsciiTable(char[][] hangmanAsciiTable) {
        this.hangmanAsciiTable = hangmanAsciiTable;
    }

    public boolean isHangmanHanged() {
        return hangmanHanged;
    }

    public void setHangmanHanged(boolean hangmanHanged) {
        this.hangmanHanged = hangmanHanged;
    }
}
