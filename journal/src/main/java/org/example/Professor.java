package org.example;

public class Professor {
    private String name;
    private Subject subject;

    public Professor(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public void toAddARating(Subject subject, int ratting, Student student){
        if(!student.getGradeSheet().containsKey(subject)){
            System.out.println("Данный предемет отсутствует в дисциплинах студента.");
            return;
        }
        student.getGradeSheet().get(subject).add(ratting);
    }


    public String getName() {
        return name;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", subject=" + subject +
                '}';
    }
}
