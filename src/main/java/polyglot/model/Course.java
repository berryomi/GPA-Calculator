package polyglot.model;

public class Course {
    private String name;
    private int units;
    private Grade grade; // anticipated grade

    public Course() {

    }

    public Course(String name, int units, Grade grade) {
        this.name = name;
        this.units = units;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
