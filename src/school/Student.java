package school;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    private static int idTemp =10000;
    private int id;
    private String name;
    private String address;
    private String phone;
    private String classes;
    private float gpa;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public Student() {
        this.id = idTemp++;
    }
    public Student(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.id = idTemp++;
    }
    public void nhapthongtinhocsinh(){
        Scanner sc = new Scanner(System.in);
        this.setId(idTemp);
        System.out.println("Nhập tên học sinh ");
        do {
            this.setName(sc.nextLine());
            if (this.getName().length() >= 6 && this.getName().length() <= 30) {
                break;
            } else {
                System.out.println("Tên môn học phải từ 6-30 ký tự, vui lòng nhập lại ");
            }
        } while (true);
        System.out.println("Nhập địa chỉ học sinh ");
        this.setAddress(sc.nextLine());
        System.out.println("Nhập số điện thoại học sinh");
        do {
            this.setPhone(sc.nextLine());
            if (phone.matches("[1234567890]+") && phone.length() >= 5 && phone.length() <= 10) {
                break;
            } else {
                System.err.println("Số điện thoại phải từ 5-10 ký tự, vui lòng nhập lại");
            }
        } while (true);
        System.out.println("Nhập lớp học");
        this.setClasses(sc.nextLine());


    }
    @Override
    public String toString(){
        return "ID: "+ getId()+
                ", Name: "+getName()+
                ", Address: "+getAddress()+
                ", Phone: "+getPhone()+
                ", Level: "+getClasses();
    }



}
