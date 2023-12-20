package exercise;

import java.util.*;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> booksList, Map<String, String> words) {
        var listBooks = new ArrayList<Map<String, String>>();
        for(Map<String, String> map : booksList) {
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
                if(entryBooks.getKey().equalsIgnoreCase(entryWord.getKey())
                   && entryBooks.getValue().equalsIgnoreCase(entryWord.getValue()) && !iteratorWord.hasNext()) {
                    listBooks.add(map);
                }
            }

        }
        return listBooks;
    }

    public static void main(String[] args) {
        List<Map<String, String>> books = new ArrayList<>();

        Map<String, String> book1 = new HashMap<>(
                Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611")
        );
        Map<String, String> book2 = new HashMap<>(
                Map.of("title", "Book of Fooos", "author", "FooBar", "year", "1111")
        );
        Map<String, String> book3 = new HashMap<>(
                Map.of("title", "The Tempest", "author", "Shakespeare", "year", "1611")
        );
        Map<String, String> book4 = new HashMap<>(
                Map.of("title", "Book of Foos Barrrs", "author", "FooBar", "year", "2222")
        );
        Map<String, String> book5 = new HashMap<>(
                Map.of("title", "Still foooing", "author", "FooBar", "year", "3333")
        );

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        Map<String, String> where = new HashMap<>(Map.of("author", "Shakespeare", "year", "1611"));

        List<Map<String, String>> result = App.findWhere(books, where);

        System.out.println(result); // =>
    }
}
//END
