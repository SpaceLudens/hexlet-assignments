package exercise;

// BEGIN
public class ReversedSequence  implements CharSequence {
    private String str;

    public ReversedSequence(String str) {
        this.str = str;
    }

    public void setStr() {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    @Override
    public  String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(getStr()).reverse().toString();
    }

    @Override
    public int length() {
        return getStr().length();
    }

    @Override
    public char charAt(int index) {
        return getStr().charAt(getStr().length() - index - 1);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new ReversedSequence(getStr().substring(start + 1, end + 1));
    }
}
// END
