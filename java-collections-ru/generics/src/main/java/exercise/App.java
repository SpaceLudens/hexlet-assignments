package exercise;

import java.util.*;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> booksList, Map<String, String> words) {
        var listBooks = new ArrayList<Map<String, String>>();
        for (Map<String, String> map : booksList) {
            var iteratorBooks = map.entrySet().iterator();
            var iteratorWord = words.entrySet().iterator();
            var entryWord = iteratorWord.next();
            while (iteratorBooks.hasNext()) {
                var entryBooks = iteratorBooks.next();
                if (entryBooks.getKey().equalsIgnoreCase(entryWord.getKey())
                    && entryBooks.getValue().equalsIgnoreCase(entryWord.getValue()) && iteratorWord.hasNext()) {
                    entryWord = iteratorWord.next();
                    continue;
                }
                if (entryBooks.getKey().equalsIgnoreCase(entryWord.getKey())
                   && entryBooks.getValue().equalsIgnoreCase(entryWord.getValue()) && !iteratorWord.hasNext()) {
                    listBooks.add(map);
                }
            }

        }
        return listBooks;
    }
}
//END
