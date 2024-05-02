// Membuat kelas yang merepresentasikan elemen yang terdiri dari String dan integer
public class StringIntegerPair {
    private String stringElement;
    private int integerElement;

    // Konstruktor
    public StringIntegerPair(String stringElement, int integerElement) {
        this.stringElement = stringElement;
        this.integerElement = integerElement;
    }

    // Getter dan setter
    public String getStringElement() {
        return stringElement;
    }

    public void setStringElement(String stringElement) {
        this.stringElement = stringElement;
    }

    public int getIntegerElement() {
        return integerElement;
    }

    public void setIntegerElement(int integerElement) {
        this.integerElement = integerElement;
    }

    @Override
    public String toString() {
        return "String: " + stringElement + ", Integer: " + integerElement;
    }
}

