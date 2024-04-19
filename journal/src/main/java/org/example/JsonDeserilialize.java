package org.example;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonDeserilialize  {
    public Journal parse(){
        Journal journal=new Journal();
        JsonParser parser=new JsonParser();
        try(FileReader fileReader=new FileReader("journal.json");) {
            JsonObject jsonObject=(JsonObject) parser.parse(fileReader);

            JsonArray studentArray=(JsonArray) jsonObject.get("studentList");
            List<Student> studentList=new ArrayList<>();
            for (JsonElement studentElement : studentArray) {
                JsonObject student = studentElement.getAsJsonObject();
                String name = student.get("name").getAsString();
                int course = student.get("course").getAsInt();
                JsonObject gradeSheet=student.getAsJsonObject("gradeSheet");
                Map<Subject, List<Integer>> subjectGradesMap=new HashMap<>();
                for (Map.Entry<String, JsonElement> entry : gradeSheet.entrySet()) {
                    String subjectName = entry.getKey();
                    JsonArray gradesJsonArray = entry.getValue().getAsJsonArray();

                    Subject subject = new Subject(subjectName);
                    List<Integer> grades = new ArrayList<>();

                    for (JsonElement gradeElement : gradesJsonArray) {
                        grades.add(gradeElement.getAsInt());
                    }
                    subjectGradesMap.put(subject, grades);
                }
                Student studentOne=new Student(name,course,subjectGradesMap);
                studentList.add(studentOne);
            }

            JsonArray professorList=(JsonArray) jsonObject.get("professorList");
            List<Professor> professorArrayList=new ArrayList<>();
            for (JsonElement professorElement:professorList) {
                JsonObject professor = professorElement.getAsJsonObject();
                String name=professor.get("name").getAsString();

                JsonObject jsonSubject=professor.getAsJsonObject("subject");
                String nameSubject=jsonSubject.get("name").getAsString();
                Subject subject=new Subject(nameSubject);
                Professor professorOne=new Professor(name,subject);
                professorArrayList.add(professorOne);
            }
            JsonArray subjectList=(JsonArray) jsonObject.get("subjectList");
            List<Subject> subjects=new ArrayList<>();
            for (JsonElement subject:subjectList) {
                JsonObject subjectObject=subject.getAsJsonObject();
                String name=subjectObject.get("name").getAsString();
                Subject subjectOne=new Subject(name);
                subjects.add(subjectOne);
            }
            journal.setProfessorList(professorArrayList);
            journal.setStudentList(studentList);
            journal.setSubjectList(subjects);




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return journal;
    }

}
