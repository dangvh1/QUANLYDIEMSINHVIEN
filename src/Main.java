
import monhoc.Bangdiem;
import school.Student;
import school.Subject;

import java.io.*;
import java.util.Scanner;
public class Main {
    private static int countSubject;
    private static Student[] students;
    private static Subject[] subjects;
    private static Bangdiem[] bangdiems;
    public static Main mn = new Main();


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        mn.inputFileStudent(students);
        mn.inputFileSubject(subjects);
        mn.inputFileBangDiem(bangdiems);
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
                        Main.createNewStudent();
                        Main.displayStudent();
                        break;
                    case 2:
                        Main.createNewSubject();
                        Main.displaySubject();
                        break;
                    case 3:
                        Main.inputbangdiemsinhvien();
                        Main.displayBangdiem();
                        break;
                    case 4:
                        Main.sortbangdiem();
                        break;
                    case 5:
                        Main.GPA();
                        break;
                    case 6:
                        mn.outputFile(subjects,students,bangdiems);
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

    private static void GPA() {
        if (bangdiems == null || bangdiems.length == 0) {
            System.out.println("Nhập bảng diểm trước khi sắp xếp");
            return;
        }
        for (int i = 0; i < bangdiems.length; i++) {
            System.out.print("sinh viên"+(i+1)+". "+bangdiems[i].getStudent().getName()+": ");
            System.out.println(tinhdiem(bangdiems[i]));
        }
    }

    private static float tinhdiem(Bangdiem bangdiem){
        float number = 0;
        int d = 0;
        for (int i = 0; i < bangdiems.length; i++) {
            number += bangdiem.number[i]*bangdiems[i].getSubject(i).getSodonvihoctrinh();
            d += bangdiems[i].getSubject(i).getSodonvihoctrinh();
            System.out.println("diem sinh vien" + number/d);
        }
        return number/d;
    }

    private static void sortbangdiem() {
        if (bangdiems == null || bangdiems.length == 0) {
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

    private static void sortByNameSubject() {
        for (int i=0; i< bangdiems.length;i++){
            for (int j=0; j < bangdiems[i].getSubjects().length;j++){
                for (int k=j+1; k<bangdiems[i].getSubjects().length;k++){
                    if (subjects[j].getTenmonhoc().compareTo(subjects[k].getTenmonhoc())>0){
                        Subject temp = subjects[j];
                        subjects[j] = subjects[k];
                        subjects[k] = temp;
                    }
                }
            }
        }
        for (Bangdiem bangdiem : bangdiems) {
            System.out.println(bangdiem);
        }
    }

    private static void sortByNameStudent() {
        if (bangdiems == null || bangdiems.length == 0){
            System.out.println("Nhập bảng điểm trước khi sắp xếp!");
            return;
        }
        for (int i = 0; i < bangdiems.length; i++) {
            for (int j = i + 1; j < bangdiems.length; j++) {
                if (bangdiems[i].getStudent().getName().compareTo(bangdiems[j].getStudent().getName()) > 0) {
                    Bangdiem temp = bangdiems[i];
                    bangdiems[i] = bangdiems[j];
                    bangdiems[j] = temp;
                }
            }
        }
        for (Bangdiem bangdiem : bangdiems) {
            System.out.println(bangdiem);
        }
    }

    private static void createNewSubject() {
        System.out.println("Nhập số lượng môn học: ");
        countSubject = new Scanner(System.in).nextInt();
        subjects = new Subject[countSubject];
        for (int i = 0; i < subjects.length; i++) {
            Subject subject = new Subject();
            subject.inputMonhoc();
            subjects[i] = subject;
        }
    }

    private static void displaySubject() {
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
    }

    private static void createNewStudent() {
        System.out.println("Nhập số lượng sinh viên: ");
        int countStudent = new Scanner(System.in).nextInt();
        students = new Student[countStudent];
        for (int i = 0; i < students.length; i++) {
            Student student = new Student();
            student.inputStudentInfo();
            students[i] = student;
        }
    }

    private static void displayStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static boolean isValidSubjectAndTeacher() {
        return students != null && subjects != null && students.length != 0 && subjects.length != 0;
    }

    private static void inputbangdiemsinhvien() {
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
            int[] number = new int[subjectNumber];
            for (int j = 0; j < subjectNumber; j++) {
                System.out.println("Nhập id môn học thứ " + (j + 1) + " của học sinh " + student.getName() + " muốn nhập điểm ");
                Subject subject = inputSubjectID(subjects);
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
            Bangdiem bangdiem = new Bangdiem(students[i],subjects, number);
            bangdiems[i] = bangdiem;
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
                    System.out.println("Có ID sinh viên bạn vừa nhập ");
                    check = true;
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
                    System.out.println("Có ID môn học bạn vừa nhập ");
                    check = true;
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
            if (SubjectNumber < 0 || SubjectNumber > subjects.length) {
                System.out.print("Số môn học không được nhỏ hơn 0 và hớn lơn tổng số môn học! Nhập lại: ");
                check = false;
            }
        } while (!check);
        return SubjectNumber;
    }

    private static void displayBangdiem() {
        for (Bangdiem bangdiem : bangdiems) {
            System.out.println(bangdiem);
        }
    }

    public void inputFileStudent(Student[] students) throws IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("sinhvien.txt");
            ois = new ObjectInputStream(fis);
            students = (Student[]) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
    }
    public void inputFileSubject(Subject[] subjects) throws IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("monhoc.txt");
            ois = new ObjectInputStream(fis);
            subjects = (Subject[]) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
    }
    public void inputFileBangDiem(Bangdiem[] bangdiems) throws IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("bangdiem.txt");
            ois = new ObjectInputStream(fis);
            bangdiems = (Bangdiem[]) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
    }

    public void outputFile(Subject[] subjects, Student[] students, Bangdiem[] bangdiems) throws IOException {
        FileOutputStream fot = null;
        FileOutputStream fos = null;
        ObjectOutputStream Cate = null;
        ObjectOutputStream Pro = null;
        try {
            fot = new FileOutputStream("sinhvien.txt");
            Cate = new ObjectOutputStream(fot);
            Cate.writeObject(students);
            fot = new FileOutputStream("monhoc.txt");
            Pro = new ObjectOutputStream(fos);
            Pro.writeObject(subjects);
            fot = new FileOutputStream("bangdiem.txt");
            Pro = new ObjectOutputStream(fos);
            Pro.writeObject(bangdiems);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fot);
            closeStream(Cate);
            closeStream(fos);
            closeStream(Pro);
        }
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
