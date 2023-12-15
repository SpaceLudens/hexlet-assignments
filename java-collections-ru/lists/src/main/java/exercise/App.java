package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {

    public static boolean scrabble(String symbols, String word) {
        if(word.length() > symbols.length()) {
            return false;
        }
        List<Character> sList = new ArrayList<>();
        for (char c : symbols.toCharArray()) {
            sList.add(c);
        }
        List<Character> wList = new ArrayList<>();
        for (char c : word.toCharArray()) {
            wList.add(c);
        }
        int count = 0;
        for (Character character : wList) {
            String str1 = String.valueOf(character);
            for (int j = 0; j < sList.size(); j++) {
                String str2 = String.valueOf(sList.get(j));
                if (str1.equalsIgnoreCase(str2)) {
                    count++;
                    sList.remove(sList.get(j));
                    j = sList.size();
                }
            }
        }
        return count == word.length();
    }

}
//END
