package school;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    private int id;
    private String name;
    private String  address;
    private String phonenumber;
    private int classes;
    private static int AUTO_ID = 100;

    public Student() {
    }

    public Student(int id, String name, String address, String phonenumber, int classes) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.classes = classes;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public void inputStudentInfo() {
        Scanner sc = new Scanner(System.in);
        this.setId(Student.AUTO_ID);
        System.out.println("Nhập tên học sinh ");
        boolean check = true;
        do {
            this.setName(sc.nextLine());
            if (this.getName().length() >= 6 && this.getName().length() <= 30) {
                break;
            } else {
                System.out.println("Tên sinh viên phải từ 6-30 ký tự, vui lòng nhập lại ");
            }
        } while (check);
        System.out.println("Nhập địa chỉ học sinh ");
        this.setAddress(sc.nextLine());
        System.out.println("Nhập số điện thoại học sinh");
        do {
            this.setPhonenumber(sc.nextLine());
            if (phonenumber.matches("[1234567890]+") && phonenumber.length() >= 5 && phonenumber.length() <= 10) {
                break;
            } else {
                System.err.println("Số điện thoại phải từ 5-10 ký tự, vui lòng nhập lại");
            }
        } while (check);
        System.out.println("Nhập lớp học");
        this.setClasses(sc.nextInt());
        Student.AUTO_ID++;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", classes=" + classes +
                '}';
    }
}
