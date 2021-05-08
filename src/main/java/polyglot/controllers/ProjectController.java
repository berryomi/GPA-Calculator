package polyglot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import polyglot.model.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {
    private JavaFunctions java = new JavaFunctions();
    private List<Grade> grades = new ArrayList<>();
    private Student student = new Student();
    private List<Course> courses = new ArrayList<>(); // list of courses a student is taking -> 나중에 Student field에 넣어주기
    private int size = 0;

    @GetMapping("/name")
    public ApiNameInfo getAbout() {
        String appName = "Course Schedule & GPA Management System";
        String authorName = "Jiwon Jun";

        return new ApiNameInfo(appName, authorName);
    }

    @GetMapping("/grades")
    public List<Grade> getGrades() {
        grades = java.setGradeValues();
        return grades;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addcourse")
    public void addCourse(@RequestBody Course data) {
        //courses.add(data);
        System.out.println(data.getGrade().getLetter() + " " + data.getGrade().getValue() + " " + data.getName() + " " + data.getUnits());
        java.addToCourseList(data);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addstudent")
    public Gpa addStudent(@RequestBody Student data) {
        //data.setCourses(courses);
        Gpa gpa = java.setStudentCourses(data);
        //student = data;

        return gpa;
    }

    @GetMapping("/reset")
    public void resetValues() {
        java.reset();
    }

}
