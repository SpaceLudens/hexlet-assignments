package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
class App {

    public static boolean scrabble(String symbols, String word) {
        int length = word.length();
        String[] letters = symbols.split("");
        List list = new ArrayList(Arrays.asList(letters));

        for (int i = 0; i < length; i++) {
            String currentSymbol = word.substring(i, i + 1);

            if(!list.contains(currentSymbol)) {
                return false;
            }

            list.remove(currentSymbol);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(scrabble("rkqodlw", "woRld"));
    }
}
//END