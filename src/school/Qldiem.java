package school;

import java.io.Serializable;
import java.util.Scanner;

public class Qldiem implements Serializable {
    static Scanner in = new Scanner(System.in);
    Student[] students = new Student[100];
    Subject[] subjects = new Subject[100];
    public static Bangdiem[] bangdiems;
    int[] soLop = new int[100];

    public void inputSubject(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng môn học");
        int a = scanner.nextInt();
        subjects = new Subject[a];
        for(int i = 0; i < a; i++){
            Subject subject = new Subject();
            subject.inputMonHoc();
            subjects[i] = subject;
        }
    }

    public void showSubject(){
        System.out.println("Danh sách môn học:");
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] == null){
                break;
            }
            System.out.print("\t");
            System.out.println(subjects[i].toString());
        }
    }

    public void inputStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng học sinh");
        int a = scanner.nextInt();
        students = new Student[a];
        for(int i = 0; i < a; i++){
            Student student = new Student();
            student.nhapthongtinhocsinh();
            students[i] = student;
        }
    }
    public void showStudent(){
        System.out.println("Danh sach mon hoc:");
        for (int i = 0; i < 100; i++) {
            if(students[i]==null) {
                break;
            }
            System.out.println("STT "+i+":"+ students[i].toString());
        }
    }

    public void assignmentStudent(Student[] students,Subject[] subjects) {
        for (int i = 0; i < students.length; i++) {
            if(students[i] == null) {
                System.out.println("Chưa có sinh viên trong danh sach");
                break;
            }
        }
        for (int i = 0; i < subjects.length; i++) {
            if(subjects[i] == null) {
                System.out.println("Chưa có môn học trong danh sách");
                break;
            }
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
            if (studentNumber <= 0 || studentNumber > students.length) {
                System.out.println("Số lượng hoc sinh phải lớn hơn 0 và nhỏ hơn tổng số hoc sinh : ");
                check = false;
            }
        } while (!check);
        bangdiems = new Bangdiem[studentNumber];
        for (int i = 0; i < studentNumber; i++) {
            System.out.println("Nhập id hoc sinh " + (i + 1) + " muốn nhập điểm: ");
            Student student = inputStudentID(students);
            System.out.println("Nhập thông tin môn học cho học sinh " + student.getName());
            System.out.println("Nhập số môn học của học sinh " + student.getName() + " cần nhập điểm ");
            int subjectNumber = inputSubjectNumber(subjects);
            bangdiems = new Bangdiem[subjectNumber];
            for (int j = 0; j < subjectNumber; j++) {
                System.out.println("Nhập id môn học thứ " + (j + 1) + " của học sinh " + student.getName() + " muốn nhập điểm ");
                Subject subject = inputSubjectID(subjects);
                System.out.println(subject);
                System.out.println("Nhập điểm của môn học " + student.getName() + " : ");
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
                    if (turnNumber >= 0 && turnNumber <= 10 ) {
                        System.out.print("Số điểm phải lớn hơn 0 và nhỏ hơn 10! Nhập lại: ");
                        check = false;
                        continue;
                    }
                    int[] diem = new int[turnNumber];
                } while (!check);
                Bangdiem bangdiem = new Bangdiem(subjects, student, turnNumber);
                bangdiems[i] = bangdiem;

            }
        }

    }

    private static Student inputStudentID(Student[] students) {
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
                    System.out.println("học sinh đã có! Nhập lại: ");
                    check = false;
                    break;
                }
            }
        } while (!check);
        System.out.println(students);
        return student;
    }

    private static Student searchStudentId(int tmpID, Student[] students) {
        for (Student driver : students) {
            if (driver.getId() == tmpID) {
                return driver;
            }
        }
        return null;
    }
    private static Subject inputSubjectID(Subject[] subjects) {
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
                    System.out.println("Môn học đã tồn tại! Nhập lại: ");
                    check = false;
                    break;
                }
            }
        } while (!check);
        System.out.println(subjects);
        return subject;
    }

    private static Subject searchSubjectId(int tmpID,Subject[] subjects) {
        for (Subject subject : subjects) {
            if (subject.getId() == tmpID) {
                return subject;
            }
        }
        return null;
    }

    private static int inputSubjectNumber(Subject[] subjects) {
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
            if (SubjectNumber > 0 || SubjectNumber < subjects.length) {
                System.out.print("Số môn học phải lớn hơn 0 và nhỏ hơn tổng số môn học! Nhập lại: ");
                check = false;
            }
        } while (!check);
        return SubjectNumber;
    }


    public void showBangDiem(Bangdiem[] bangdiems){
        System.out.println("    Bảng Điểm   ");
        for(Bangdiem bangdiem:bangdiems) {
            System.out.println(bangdiem);
        }
    }


    public void sortByTenSinhVien(Student[] students,Subject[] subjects){
        Bangdiem sv;
        for(int i = 0; i < bangdiems.length - 1; i++){
            for(int j = i + 1; j < bangdiems.length; j++)
            {
                if(bangdiems[i].getStudent().getName().compareTo(bangdiems[j].getStudent().getName()) > 0)
                {
                    sv = bangdiems[i];
                    bangdiems[i] = bangdiems[j];
                    bangdiems[j] = sv;
                }
            }
        }
    }

    public void sortByTenMonHoc(Student[] students,Subject[] subjects){
        Bangdiem st;
        for(int i = 0; i < bangdiems.length - 1; i++){
            for(int j = i + 1; j < bangdiems.length; j++)
            {
                if(bangdiems[i].getSubject().getTenmon().compareTo(bangdiems[j].getSubject().getTenmon()) > 0)
                {
                    st = bangdiems[i];
                    bangdiems[i] = bangdiems[j];
                    bangdiems[j] = st;
                }
            }
        }
    }

    public void tinhDiemChoSinhVien(){
        int ma1;
        System.out.println("Nhap ma sinh vien can tinh diem");
        ma1 = new Scanner(System.in).nextInt();
        float point=0;
        int stt=0;
        for (Bangdiem bangdiem : bangdiems) {
            if (bangdiem.getStudent().getId() == ma1) {
                    point += bangdiem.getDiem()*bangdiem.getSubject().getSodonvi();
                    stt ++;
            }
        }
        if (stt==0){
            System.out.println("");
        }


    }

}



