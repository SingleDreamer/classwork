import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
        WordSearch w = new WordSearch(15,30);
        w.readWords("wordList.txt");
    }
}
