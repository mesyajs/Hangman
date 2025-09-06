import java.io.*;
import java.util.*;

public class DictionaryImpl implements DictionaryInterface {
    private final List<String> words = new ArrayList<>();

    @Override
    public void generateWords()  {
        try(Scanner scanner = new Scanner(new FileReader("C:\\Users\\Asus\\Desktop\\dictionary.txt"))) {
            while(scanner.hasNextLine()) {
                String word = scanner.next();
                words.add(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String selectWord() {
        Random random = new Random();
        return words.get(random.nextInt(0, words.size() - 1));
    }
}
