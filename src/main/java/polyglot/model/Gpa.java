package polyglot.model;

public class Gpa {
    private double currentTerm; // current term gpa
    private double cgpa;

    public Gpa() {

    }

    public Gpa(double currentTerm, double cgpa) {
        this.currentTerm = currentTerm;
        this.cgpa = cgpa;
    }

    public double getCurrentTerm() {
        return currentTerm;
    }

    public void setCurrentTerm(double currentTerm) {
        this.currentTerm = currentTerm;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
