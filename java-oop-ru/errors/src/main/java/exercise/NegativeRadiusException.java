package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    private  String string;

    public NegativeRadiusException() {}
    public NegativeRadiusException(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "Не удалось посчитать площадь";
    }
}
// END
