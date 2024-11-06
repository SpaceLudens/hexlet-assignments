package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (Method method : Address.class.getDeclaredMethods()) {

            if (method.isAnnotationPresent(Inspect.class)) {

                try {
                    method.invoke(address);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                var methodType = method.getReturnType().getName();
                String regex = "[^.]+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(methodType);
                if (matcher.find()) {
                    methodType = matcher.group();
                }
                var methodName = method.getName();

                System.out.println("Method " + methodName +  " returns a value of type " + methodType);
            }
        }
        // END
    }
}
