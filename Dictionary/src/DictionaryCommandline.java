import java.util.LinkedList;
import java.util.Scanner;

public class DictionaryCommandline extends DictionaryManagement {

    public void dictionaryBasic() {
        showALlWords(words);
    }
    public void dictionaryAdvanced() {
        //insertFromFile();
        showALlWords(words);
        dictionaryLookup("hello");
    }


}
