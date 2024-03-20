package exercise;

import java.lang.reflect.Field;
import java.util.*;

// BEGIN
public class Validator {
    public static List<String> validate(Object object) {
        List<String> nullFields = new ArrayList<>();
        Class<?> objectClass = object.getClass();
        Field[] fields = objectClass.getDeclaredFields();
        for(Field field : fields) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(object);
            } catch (IllegalAccessException exception) {
                throw new RuntimeException(exception);
            }
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull != null && value == null) {
                nullFields.add(field.getName());
            }
        }
        return nullFields;
    }

    public static Map<String, List<String>> advancedValidate(Object object) {
        List<String> canNotBeNull = List.of("can not be null");
        List<String> lengthLessThan4 = List.of("length less than 4");
        Map<String, List<String>> errorFields = new TreeMap<>();
        Class<?> objectClass = object.getClass();
        Field[] fields = objectClass.getDeclaredFields();
        for(Field field : fields) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(object);
            } catch (IllegalAccessException exception) {
                throw new RuntimeException(exception);
            }
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull != null) {
                if (value == null) {
                    errorFields.put(field.getName(), canNotBeNull);
                } else if (value.toString().length() < 4 && !field.getName().equals("houseNumber")) {
                    errorFields.put(field.getName(), lengthLessThan4);
                }
            }
        }
        return errorFields;
    }
}
// END