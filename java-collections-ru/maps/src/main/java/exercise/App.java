package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String str) {
        String[] words = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        if(str.isEmpty()) {
            return map;
        }
        for (String st1 : words) {
            int value = 1;
            for (String st2 : words) {
                if (st1.equalsIgnoreCase(st2)) {
                    map.put(st1, value++);
                }
            }
        }
return map;
    }
    public static String toString(Map<String, Integer> map) {
        StringBuilder result = new StringBuilder();
        if(map.isEmpty()) {
            return "{}";
        }
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            result.append("  ").append(item.getKey()).append(": ").append(item.getValue()).append("\n");
        }
        return "{\n" + result + "}";
    }
}
//END
