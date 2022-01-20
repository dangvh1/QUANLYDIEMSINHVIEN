package school;

import java.io.Serializable;

public class Bangdiem implements Serializable {
    public  Subject subject;
    public  Student[] students;
    public Student student;
    public Subject[] subjects;
    public int diem;

    public Bangdiem() {
    }

    public Bangdiem(Subject[] subjects, Student student, int diem) {
        this.subjects = subjects;
        this.student = student;
        this.diem = diem;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
}
