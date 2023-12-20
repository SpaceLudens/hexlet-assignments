package exercise;

import java.util.*;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> booksList, Map<String, String> words) {
        var listBooks = new ArrayList<Map<String, String>>();
        for(Map<String, String> map : booksList) {
            Iterator<Map.Entry<String, String>> iteratorBooks = map.entrySet().iterator();
            Iterator<Map.Entry<String, String>> iteratorWord = words.entrySet().iterator();
            Map.Entry<String, String> FirstEntryWord = iteratorWord.next();
            Map.Entry<String, String> SecondEntryWord = iteratorWord.next();
            while (iteratorBooks.hasNext()) {
                Map.Entry<String, String> entryBooks = iteratorBooks.next();
                if((entryBooks.getKey().equalsIgnoreCase(FirstEntryWord.getKey()) &&
                   entryBooks.getValue().equalsIgnoreCase(FirstEntryWord.getValue())) ||
                   (entryBooks.getKey().equalsIgnoreCase(SecondEntryWord.getKey()) &&
                   entryBooks.getValue().equalsIgnoreCase(SecondEntryWord.getValue()))) {
                    listBooks.add(map);
                    break;
                }
            }

        }
        return listBooks;
    }
}
//END
