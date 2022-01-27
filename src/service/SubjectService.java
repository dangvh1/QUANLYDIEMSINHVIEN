package service;

import school.Subject;
import mainrun.Main;
import java.util.Scanner;

public class SubjectService {
    public static final String SUBJECT_DATA_FILE = "subject.dat";
    public static void createNewSubject() {
        System.out.println("Nhập số lượng môn học: ");
        Main.countSubject = new Scanner(System.in).nextInt();
        Main.subjects = new Subject[Main.countSubject];
        for (int i = 0; i < Main.subjects.length; i++) {
            Subject subject = new Subject();
            subject.inputMonhoc();
            Main.subjects[i] = subject;
        }
        Main.fileUtil.writeDataToFile(Main.subjects, SUBJECT_DATA_FILE);
    }

    public static void displaySubject() {
        for (Subject subject : Main.subjects) {
            System.out.println(subject);
        }
    }
}
