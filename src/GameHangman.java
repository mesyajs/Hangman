import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class GameHangman {
    private final HangmanImpl hangman;
    private final DictionaryImpl dictionary;

    public static void main(String[] args) throws IOException {
        GameHangman gameHangman = new GameHangman();
        gameHangman.startGame();
    }

    public GameHangman() {
        hangman = new HangmanImpl();
        dictionary = new DictionaryImpl();
    }

    public void startGame() throws IOException  {
        Scanner scanner = new Scanner(System.in);
        dictionary.generateWords();
        String word = dictionary.selectWord();
        String temp = showWord(word);
        hangman.showHangman();
        int countError = 1;
        System.out.println("Слово: " + temp);
        while(true) {
            System.out.print("Отгадайте букву: ");
            String letter = scanner.next();
            if(checkLetterInWord(word, letter) && !temp.equals(word)) {
                System.out.println("Поздравляем...Вы отгадали букву");
                System.out.print("Слово: ");
                temp = replace(temp, word, letter);
                System.out.println(temp);
            } else if(!gameOver(hangman.getHangmanAsciiTable())) {
                System.out.println(gameOver(hangman.getHangmanAsciiTable()));
                hangman.drawHangman(countError++);
            }
            if(gameOver(hangman.getHangmanAsciiTable())) {
                System.out.println("Виселица повешена");
                break;
            }
            if(temp.equals(word)) {
                System.out.println("Вы победили......");
                break;
            }
        }
    }
    public String showWord(String word) {
        String lastLetter = String.valueOf(word.charAt(word.length() - 1));
        String firstLetter = String.valueOf(word.charAt(0));
        String temp = firstLetter;
        for(int i = 1; i < word.length() - 1; ++i) {
            temp += "_";
        }
        temp += lastLetter;
        return temp;
    }
    public String replace(String temp, String word, String letter) {
        int index = word.indexOf(letter);
        return temp.substring(0, index) + letter + temp.substring(index + 1);
    }
    public boolean checkLetterInWord(String word, String letter) {
        for(int i = 0; i < word.length(); ++i) {
            if(String.valueOf(word.charAt(i)).equals(letter)) {
                return true;
            }
        }
        return false;
    }
    public boolean gameOver(char[][] hangman) {
        return Arrays.deepEquals(hangman, new char[][] {
                {' ', '-', '-', '-', '-', '-', '-', '-', '+', ' '},
                {' ', '|', '/', ' ', ' ', ' ', ' ', ' ', '|', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', 'O', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', '/', '|', '\\'},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' '},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', '/', ' ', '\\'},
                {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'/', '|', '\\', '_', '_', '_', '_', '_', '_', '_'}
        });
    }
    /*
    switch(level) {
            case 1 -> {
                hangmanAsciiTable[1][9] = ' ';
                showHangman();
            }
            case 2 -> {
                hangmanAsciiTable[2][9] = 'O';
                showHangman();
            }
            case 3 -> {
                hangmanAsciiTable[3][9] = '|';
                hangmanAsciiTable[4][9] = '|';
                hangmanAsciiTable[5][9] = '|';
                showHangman();
            }
            case 4 -> {
                hangmanAsciiTable[6][8] = '/';
                hangmanAsciiTable[7][8] = '|';
                hangmanAsciiTable[7][9] = '_';
                showHangman();
            }
            default -> {
                throw new IllegalArgumentException();
            }
     */
}
