package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        int count = 0;
        count = (int) emails.stream()
                .filter(e -> e.endsWith("gmail.com") || e.endsWith("yandex.ru") || e.endsWith("hotmail.com"))
                .count();
        return count;
    }
}
// END
