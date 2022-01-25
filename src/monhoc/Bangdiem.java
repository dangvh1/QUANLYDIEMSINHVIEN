package monhoc;

import school.Monhoc;
import school.Student;
import school.Subject;

import java.io.Serializable;
import java.util.Arrays;

public class Bangdiem implements Serializable {
    private Student student;
    private Subject[] subjects;
    private int[] number;

    public Bangdiem() {
    }

    public Bangdiem(Student student, Subject[] subjects, int[] number) {
        this.student = student;
        this.subjects = subjects;
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public int[] getNumber() {
        return number;
    }

    public void setNumber(int[] number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Bangdiem{" +
                "student=" + student +
                ", subjects=" + Arrays.toString(subjects) +
                ", number=" + number +
                '}';
    }
}
