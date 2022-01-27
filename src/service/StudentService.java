package service;

import school.Student;
import mainrun.Main;
import java.util.Scanner;

public class StudentService {
    public static final String STUDENT_DATA_FILE = "student.dat";
    public static void createNewStudent() {
        System.out.println("Nhập số lượng sinh viên: ");
        int countStudent = new Scanner(System.in).nextInt();
        Main.students = new Student[countStudent];
        for (int i = 0; i < Main.students.length; i++) {
            Student student = new Student();
            student.inputStudentInfo();
            Main.students[i] = student;
        }
        Main.fileUtil.writeDataToFile(Main.students, STUDENT_DATA_FILE);
    }

    public static void displayStudent() {
        for (Student student : Main.students) {
            System.out.println(student);
        }
    }

}
