package polyglot.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private double cgpa;
    private int totalUnits;
    private List<Course> courses; // list of courses the student is taking

    public Student() {
    }

    public Student(double cgpa, int totalUnits, List<Course> courses) {
        this.cgpa = cgpa;
        this.totalUnits = totalUnits;
        this.courses = courses;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public int getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(int totalUnits) {
        this.totalUnits = totalUnits;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
