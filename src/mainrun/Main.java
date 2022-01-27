package mainrun;

import monhoc.Bangdiem;
import school.Student;
import school.Subject;
import service.BangdiemService;
import service.StudentService;
import service.SubjectService;
import util.DataUtil;
import util.FileUtil;

import java.io.*;
import java.util.Scanner;
public class Main {
    public static int countSubject;
    public static Student[] students;
    public static Subject[] subjects;
    public static Bangdiem[] bangdiems;

    public static StudentService studentService = new StudentService();
    public static SubjectService subjectService = new SubjectService();
    public static BangdiemService bangdiemService = new BangdiemService();

    public static FileUtil fileUtil = new FileUtil();
    private static void initializeData() {
        Object studentFromFile = fileUtil.readDataFromFile(StudentService.STUDENT_DATA_FILE);
        Main.students = DataUtil.isNullOrEmpty(studentFromFile) ? new Student[100] : (Student[]) studentFromFile;

        Object subjectFromFile = fileUtil.readDataFromFile(SubjectService.SUBJECT_DATA_FILE);
        Main.subjects = DataUtil.isNullOrEmpty(subjectFromFile) ? new Subject[100] : (Subject[]) subjectFromFile;

        Object bangdiemFromFile = fileUtil.readDataFromFile(BangdiemService.BANGDIEM_DATA_FILE);
        Main.bangdiems = DataUtil.isNullOrEmpty(bangdiemFromFile) ? new Bangdiem[100] : (Bangdiem[]) bangdiemFromFile;
    }
    
    public static void main(String[] args) throws IOException {
        initializeData();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("***********MENU***********");
            System.out.println("1. Nhập danh sách sinh viên mới");
            System.out.println("2. Nhập danh sách môn học mới");
            System.out.println("3. Nhập điểm cho mỗi học sinh");
            System.out.println("4. Sắp xếp bảng điểm ");
            System.out.println("5. Tính điểm tổng kết chung cho sinh viên");
            System.out.println("6. Thoát và lưu vào file");
            System.out.println("Su lua chon cua ban: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        studentService.createNewStudent();
                        studentService.displayStudent();
                        break;
                    case 2:
                        subjectService.createNewSubject();
                        subjectService.displaySubject();
                        break;
                    case 3:
                        bangdiemService.inputbangdiemsinhvien();
                        bangdiemService.displayBangdiem();
                        break;
                    case 4:
                        bangdiemService.sortbangdiem();
                        break;
                    case 5:
                        Main.GPA();
                        break;
                    case 6:

                        System.exit(0);
                        break;
                    default:
                        System.out.println("Chon menu tu 1-6, vui long chon lai: ");
                        break;
                }
            } catch (NumberFormatException e) {
                // TODO: handle exception
                System.out.println("Su lua chon cua ban phai la dang so, vui long chon lai: ");
            }
        } while (true);

    }

    public static void GPA() {
        if (bangdiems == null || bangdiems.length == 0) {
            System.out.println("Nhập bảng diểm trước khi sắp xếp");
            return;
        }
        for (int i = 0; i < bangdiems.length; i++) {
            System.out.print("sinh viên"+(i+1)+". "+bangdiems[i].getStudent().getName()+": ");
            System.out.println(tinhdiem(bangdiems[i]));
        }
    }

    public static float tinhdiem(Bangdiem bangdiem){
        float number = 0;
        int d = 0;
        for (int i = 0; i < bangdiems.length; i++) {
            number += bangdiem.number[i]*bangdiems[i].getSubject(i).getSodonvihoctrinh();
            d += bangdiems[i].getSubject(i).getSodonvihoctrinh();
            System.out.println("diem sinh vien" + number/d);
        }
        return number/d;
    }


}
