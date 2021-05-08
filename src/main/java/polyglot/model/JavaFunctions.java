package polyglot.model;

import java.util.ArrayList;
import java.util.List;

public class JavaFunctions {
    private List<Grade> grades = new ArrayList<>();
    private List<Course> courses = new ArrayList<>(); // list of courses a student is taking
    private Student student = new Student();

    public List<Grade> setGradeValues() {
        grades.clear();

        grades.add(new Grade("A+", 4.33));
        grades.add(new Grade("A", 4.00));
        grades.add(new Grade("A-", 3.67));
        grades.add(new Grade("B+", 3.33));
        grades.add(new Grade("B", 3.00));
        grades.add(new Grade("B-", 2.67));
        grades.add(new Grade("C+", 2.33));
        grades.add(new Grade("C", 2.00));
        grades.add(new Grade("C-", 1.67));
        grades.add(new Grade("D", 1.00));
        grades.add(new Grade("F", 0.00));

        return grades;
    }

    //이걸 실행한 뒤에는 courses 완성
    public void addToCourseList(Course newCourse) {
        courses.add(newCourse);

    }

    public Gpa setStudentCourses(Student studentNew) {
        studentNew.setCourses(courses);

        System.out.println("setStudentCourses test CGPA : " + studentNew.getCgpa());
        System.out.println("setStudentCourses test Units : " + studentNew.getTotalUnits());
        System.out.println("setStudentCourses test : " + studentNew.getCourses().size());

        System.out.println("List of courses a student is taking: ");
        for (int i = 0; i < studentNew.getCourses().size(); i++) {
            System.out.println("Course " + i + ": " + studentNew.getCourses().get(i).getName());
        }

        return calculate(studentNew);
    }

    public Gpa calculate(Student aStudent) {
        Gpa result = new Gpa();

        double currentCGPA = aStudent.getCgpa(); // 3.0
        int currentUnits = aStudent.getTotalUnits(); // 30

        double termGradePoint = 0.0; // ex. 12.99 + 12.99 + 12 for A+/3 A+/3 B/4
        int termCredit = 0; // ex. 3 + 3 + 3 for taking 3 three-credit courses
        double gradePoint = 0.0;

        for (int i = 0; i < aStudent.getCourses().size(); i++) {
            gradePoint = aStudent.getCourses().get(i).getGrade().getValue() * aStudent.getCourses().get(i).getUnits();
            termGradePoint = termGradePoint + gradePoint;
            termCredit = termCredit + aStudent.getCourses().get(i).getUnits();
        }

        int totalCredit = termCredit + currentUnits; // ex. 30 + 9

        double termGPA = termGradePoint / termCredit; // ex. 3.89
        double cgpa = ( (currentUnits * currentCGPA) + (termCredit * termGPA) ) / totalCredit;
        //double cgpa = new HelloJNI().callC(currentUnits, currentCGPA, termCredit, termGPA, totalCredit);

        // round them
        termGPA = Math.round(termGPA * 100.0) / 100.0;
        cgpa = Math.round(cgpa * 100.0) / 100.0;

        // write code call c
        result.setCurrentTerm(termGPA);
        result.setCgpa(cgpa);

        System.out.println("Term GPA: " + result.getCurrentTerm());
        System.out.println("CGPA: " + result.getCgpa());

        reset();
        aStudent.getCourses().clear();

        return result;
    }

    public void reset() {
        courses.clear();
    }


}
