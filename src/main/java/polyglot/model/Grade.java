package polyglot.model;

public class Grade {
    private String letter; // ex. A+, B-
    private double value; // ex. 4.33

    public Grade() {

    }

    public Grade(String letter, double value) {
        this.letter = letter;
        this.value = value;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

