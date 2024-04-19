package org.example;

import java.util.ArrayList;
import java.util.List;

public class Journal {
    private List<Student> studentList;
    private List<Professor> professorList;
    private List<Subject> subjectList;

    public Journal(List<Student> studentList, List<Professor> professorList, List<Subject> subjectList) {
        this.studentList = studentList;
        this.professorList = professorList;
        this.subjectList = subjectList;
    }

    public Journal() {
        studentList=new ArrayList<>();
        professorList=new ArrayList<>();
        subjectList=new ArrayList<>();
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setProfessorList(List<Professor> professorList) {
        this.professorList = professorList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Professor> getProfessorList() {
        return professorList;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "studentList=" + studentList +
                ", professorList=" + professorList +
                ", subjectList=" + subjectList +
                '}';
    }
}
