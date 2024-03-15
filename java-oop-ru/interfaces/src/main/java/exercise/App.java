package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int n) {
        List<String> result = new ArrayList<>();
        homes.sort(Home::compareTo);
        if (homes.isEmpty()) {
            return result;
        }
        for (int i = 0; i < n; i++) {
            result.add(homes.get(i).toString());
        }
        return result;
    }
}
// END
