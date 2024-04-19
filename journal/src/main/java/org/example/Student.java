package org.example;

import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private int course;
    private Map<Subject, List<Integer>> gradeSheet;


    public Student(String name, int course, Map<Subject, List<Integer>> gradeSheet) {
        this.name = name;
        this.course = course;
        this.gradeSheet = gradeSheet;

    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void setGradeSheet(Map<Subject, List<Integer>> gradeSheet) {
        this.gradeSheet = gradeSheet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Map<Subject, List<Integer>> getGradeSheet() {
        return gradeSheet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                ", gradeSheet=" + gradeSheet +
                ", subjectList=" +
                '}';
    }
}
