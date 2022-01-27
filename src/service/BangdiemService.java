package service;

import monhoc.Bangdiem;
import school.Student;
import school.Subject;
import mainrun.Main;
import java.util.Scanner;

public class BangdiemService {
    public static final String BANGDIEM_DATA_FILE = "bangdiem.dat";

    public static void sortbangdiem() {
        if (Main.bangdiems == null || Main.bangdiems.length == 0) {
            System.out.println("Nhập bảng điểm trước khi sắp xếp");
            return;
        }
        do {
            System.out.println("Sắp xếp danh sách bảng điểm");
            System.out.println("1.Theo tên sing viên");
            System.out.println("2.Theo số tên môn học");
            System.out.println("3.Thoát");
            System.out.println("Nhập sự lựa chọn của bạn");
            int choice = 0;
            boolean checkChoice = true;
            do {
                try {
                    choice = new Scanner(System.in).nextInt();
                    checkChoice = true;
                } catch (Exception e) {
                    System.out.println("không được phép có ký tự khác ngoài ký tự số! Nhập lại");
                    checkChoice = false;
                    continue;
                }
                if (choice <= 0 || choice > 3) {
                    System.out.print("Nhập trong khoảng từ 1 đến 3! Nhập lại: ");
                    checkChoice = false;
                }
            } while (!checkChoice);
            switch (choice) {
                case 1:
                    sortByNameStudent();
                    break;
                case 2:
                    sortByNameSubject();
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    public static void sortByNameSubject() {
        for (int i=0; i< Main.bangdiems.length;i++){
            for (int j=0; j < Main.bangdiems[i].getSubjects().length;j++){
                for (int k=j+1; k<Main.bangdiems[i].getSubjects().length;k++){
                    if (Main.subjects[j].getTenmonhoc().compareTo(Main.subjects[k].getTenmonhoc())>0){
                        Subject temp = Main.subjects[j];
                        Main.subjects[j] = Main.subjects[k];
                        Main.subjects[k] = temp;
                    }
                }
            }
        }
        for (Bangdiem bangdiem : Main.bangdiems) {
            System.out.println(bangdiem);
        }
    }

    public static void sortByNameStudent() {
        if (Main.bangdiems == null || Main.bangdiems.length == 0){
            System.out.println("Nhập bảng điểm trước khi sắp xếp!");
            return;
        }
        for (int i = 0; i < Main.bangdiems.length; i++) {
            for (int j = i + 1; j < Main.bangdiems.length; j++) {
                if (Main.bangdiems[i].getStudent().getName().compareTo(Main.bangdiems[j].getStudent().getName()) > 0) {
                    Bangdiem temp = Main.bangdiems[i];
                    Main.bangdiems[i] = Main.bangdiems[j];
                    Main.bangdiems[j] = temp;
                }
            }
        }
        for (Bangdiem bangdiem : Main.bangdiems) {
            System.out.println(bangdiem);
        }
    }

    public static boolean isValidSubjectAndTeacher() {
        return Main.students != null && Main.subjects != null && Main.students.length != 0 && Main.subjects.length != 0;
    }

    public static void inputbangdiemsinhvien() {
        if (!isValidSubjectAndTeacher()) {
            System.out.println("Bạn cần nhập môn học và sinh viên trước khi nhập điểm ");
            return;
        }
        boolean check = true;
        System.out.println("Nhập số lượng học sinh muốn nhập điểm : ");
        int studentNumber = 0;
        do {
            try {
                studentNumber = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài chữ:");
                check = false;
                continue;
            }
            if (studentNumber <= 0 || studentNumber > Main.students.length) {
                System.out.println("Số lượng hoc sinh phải lớn hơn 0 và nhỏ hơn tổng số hoc sinh : ");
                check = false;
            }
        } while (!check);
        Main.bangdiems = new Bangdiem[studentNumber];
        for (int i = 0; i < studentNumber; i++) {
            System.out.println("Nhập id hoc sinh " + (i + 1) + " muốn nhập điểm: ");
            Student student = inputStudentID(Main.students);
            System.out.println("Nhập thông tin môn học cho học sinh " + student.getName());
            System.out.println("Nhập số môn học của học sinh " + student.getName() + " cần nhập điểm ");
            int subjectNumber = inputSubjectNumber(Main.subjects);
            Main.bangdiems = new Bangdiem[subjectNumber];
            int[] number = new int[subjectNumber];
            for (int j = 0; j < subjectNumber; j++) {
                System.out.println("Nhập id môn học thứ " + (j + 1) + " của học sinh " + student.getName() + " muốn nhập điểm ");
                Subject subject = inputSubjectID(Main.subjects);
                System.out.println(subject);
                System.out.println("Nhập điểm của môn học của sinh viên " + student.getName() + " : ");
                int turnNumber = 0;
                do {
                    try {
                        turnNumber = new Scanner(System.in).nextInt();
                        check = true;
                    } catch (Exception e) {
                        System.out.println("Không được có ký tự khác ngoài số! Nhập lại: ");
                        check = false;
                        continue;
                    }
                    if (turnNumber < 0 || turnNumber > 10 ) {
                        System.out.print("Số điểm phải lớn hơn 0 và nhỏ hơn hoặc bằng 10! Nhập lại: ");
                        check = false;
                        continue;
                    }
                    number[j] = turnNumber;
                } while (!check);
            }
            Bangdiem bangdiem = new Bangdiem(Main.students[i],Main.subjects, number);
            Main.bangdiems[i] = bangdiem;
            Main.fileUtil.writeDataToFile(Main.bangdiems, BANGDIEM_DATA_FILE);
        }
    }

    public static Student inputStudentID(Student[] students) {
        int tmpID = 0;
        boolean check = true;
        Student student = null;
        do {
            try {
                tmpID = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("không được có ký tự khác ngoài số! Nhập lại: ");
                check = false;
                continue;
            }
            student = searchStudentId(tmpID,students);
            if (student.getId() == 0) {
                System.out.print("Không có ID học sinh vừa nhập! Nhập lại: ");
                check = false;
            }
            for (Student s : students) {
                if (s.getId() == tmpID) {
                    System.out.println("Có ID sinh viên bạn vừa nhập ");
                    check = true;
                    break;
                }
            }
        } while (!check);
        System.out.println(students);
        return student;
    }
    public static Student searchStudentId(int tmpID, Student[] students) {
        for (Student driver : students) {
            if (driver.getId() == tmpID) {
                return driver;
            }
        }
        return null;
    }
    public static Subject inputSubjectID(Subject[] subjects) {
        int tmpID = 0;
        boolean check = true;
        Subject subject = null;
        do {
            try {
                tmpID = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("không được có ký tự khác ngoài số! Nhập lại: ");
                check = false;
                continue;
            }
            subject = searchSubjectId(tmpID, subjects);
            if (subject.getId() == 0) {
                System.out.print("Không có id môn học vừa nhập! Nhập lại: ");
                check = false;
            }
            for (Subject s : subjects) {
                if (s.getId() == tmpID) {
                    System.out.println("Có ID môn học bạn vừa nhập ");
                    check = true;
                    break;
                }
            }
        } while (!check);
        System.out.println(subjects);
        return subject;
    }

    public static Subject searchSubjectId(int tmpID,Subject[] subjects) {
        for (Subject subject : subjects) {
            if (subject.getId() == tmpID) {
                return subject;
            }
        }
        return null;
    }
    public static int inputSubjectNumber(Subject[] subjects) {
        int SubjectNumber = 0;
        boolean check = true;
        do {
            try {
                SubjectNumber = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                check = false;
                continue;
            }
            if (SubjectNumber < 0 || SubjectNumber > subjects.length) {
                System.out.print("Số môn học không được nhỏ hơn 0 và hớn lơn tổng số môn học! Nhập lại: ");
                check = false;
            }
        } while (!check);
        return SubjectNumber;
    }

    public static void displayBangdiem() {
        for (Bangdiem bangdiem : Main.bangdiems) {
            System.out.println(bangdiem);
        }
    }
}
