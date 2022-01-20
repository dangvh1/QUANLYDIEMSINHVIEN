
import school.Bangdiem;
import school.Qldiem;
import school.Student;
import school.Subject;

import java.io.*;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static Main mn = new Main();


    public static void main(String[] args) throws IOException {
        Qldiem[] qldiems = new Qldiem[100];
        Subject[] subjects = new Subject[100];
        Student[] students = new Student[100];
        Bangdiem[] bangdiems = new Bangdiem[100];
        Qldiem ql = new Qldiem();
        Scanner scanner = new Scanner(System.in);
        mn.inputFileStudent(students);
        mn.inputFileSubject(subjects);
        mn.inputFileBangDiem(bangdiems);
        do {
            System.out.println("***********MENU***********");
            System.out.println("1. Nhập danh sách sinh viên mới");
            System.out.println("2. Nhập danh sách môn học mới");
            System.out.println("3. In danh sách sinh viên mới");
            System.out.println("4. In danh sách môn học mới");
            System.out.println("5. Nhập điểm cho mỗi học sinh");
            System.out.println("6. Sắp xếp bảng điểm theo tên sinh viên");
            System.out.println("7. Sắp xếp bảng điểm theo tên môn học");
            System.out.println("8. Tính điểm tổng kết chung cho sinh viên");
            System.out.println("9. Thoát và lưu vào file");
            System.out.println("Su lua chon cua ban: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        ql.inputStudent();
                        break;
                    case 2:
                        ql.inputSubject();
                        break;
                    case 3:
                        ql.showStudent();
                        break;
                    case 4:
                        ql.showSubject();
                        break;
                    case 5:
                        ql.assignmentStudent(students,subjects);
                        ql.showBangDiem(bangdiems);
                        break;
                    case 6:
                        ql.sortByTenSinhVien(students,subjects);
                        ql.showBangDiem(bangdiems);
                        break;
                    case 7:
                        ql.sortByTenMonHoc(students,subjects);
                        ql.showBangDiem(bangdiems);
                        break;
                    case 8:
                        ql.tinhDiemChoSinhVien();
                        break;
                    case 9:
                        mn.outputFile(subjects,students,bangdiems);
                        System.exit(0);
                    default:
                        System.out.println("Chon menu tu 1-9, vui long chon lai: ");
                        break;
                    }
                } catch (NumberFormatException e) {
                    // TODO: handle exception
                    System.out.println("Su lua chon cua ban phai la dang so, vui long chon lai: ");
                }
        } while (true);


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
