import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class DictionaryManagement extends Dictionary {
    Scanner sc = new Scanner(System.in);
    private final File FileDictionary = new File("dictionary.txt");
    public int kich_co = 0, so_tu = 0;

    DictionaryManagement() {
        //super();
//        LinkedList<Word> words = new LinkedList<Word>();
    }

    public void insertFromCommandline(String word, String meaning) {
       System.out.println(" Format: English - Vietnamese ");
       Word node = new Word(word,meaning);
       words.add(node);
    }

    public void sort(Word w) {
        Collections.sort(words, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.getWord_target().compareToIgnoreCase(o2.getWord_target());
            }
        });
    }

    public void insertFromFile() throws ArrayIndexOutOfBoundsException {
        try {
            Scanner du_lieu = new Scanner(FileDictionary);
            while (du_lieu.hasNextLine()) {
                String[] dong_du_lieu = du_lieu.nextLine().split("\\t");
                words.add(new Word(dong_du_lieu[0], dong_du_lieu[1]));
                  kich_co++;
            }
            du_lieu.close();
        } catch (FileNotFoundException evt) {
            System.out.println("Loi o insertFromFile!");
        }
    }

    public String dictionaryLookup(String search) {
        for(int i = 0; i < words.size(); i++) {
            if (search.equals(words.get(i).word_target)) {
                return words.get(i).word_explain;
            }
        }
        return "Khong tim thay!";
    }
    public void addWord(String English, String Vietnamese) {
       
        words.add(new Word(English, Vietnamese));
        dictionaryExportToFile();
    }
    public boolean removeWord(String tu_xoa) {
        for(Word w: words) {
            if (w.word_target.equals(tu_xoa)) {
                words.remove(w);
                return true;
            }
        }
        //dictionaryExportToFile();
        return false;
    }

    public boolean edit(String t,String e) {
        for(Word w : words) {
            if(t.equals(w.word_target)) {
                w.word_explain = e;
                return true;
            }
        }
        dictionaryExportToFile();
        return false;
    }

    public void dictionaryExportToFile() {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(FileDictionary));
            for(Word w: words) {
                bufferedWriter.write(w.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<String> dictionarySearcher(String s) {
        LinkedList<String> string = new LinkedList<String>();
        for(Word w : words) {
            if(w.word_target.startsWith(s)) {
                string.add(w.word_target);
            }
        }
        return  string;
    }

    public void showALlWords(LinkedList<Word> words) {
        int i = 0;
        System.out.printf("%-5s%-20s%s \n", "No", "|English", "|Vietnamese");
        for ( Word w: words) {
            i++;
            System.out.printf("%-5s%-20s%s \n", i, w.getWord_target(),w.getWord_explain());
        }
    }

    public static void main(String[] args) {
        DictionaryManagement dc = new DictionaryManagement();
        Scanner sc = new Scanner(System.in);
//        String a = sc.nextLine();
//        String b = sc.nextLine();
        dc.insertFromFile();
//        dc.showALlWords(dc.words);
        //System.out.println(dc.dictionarySearcher("hello"));
        //System.out.println(dc.dictionaryLookup(""));
        //dc.addWord("hello","xin chao");
        //System.out.println(dc.dictionaryLookup("hello"));


    }

}