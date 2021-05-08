package polyglot.model;

public class HelloJNI {

    static {
        System.loadLibrary("hello"); //
    }

    private native double calculateInC(int currentUnits, double currentGPA, int termCredit, double termGPA, int totalCredit);

    //calculate cgpa
    public double callC(int currentUnits, double currentGPA, int termCredit, double termGPA, int totalCredit) {
        double cgpa = new HelloJNI().calculateInC(currentUnits, currentGPA, termCredit, termGPA, totalCredit);
        return cgpa;
    }
}
