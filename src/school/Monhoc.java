package school;


import java.io.Serializable;
import java.util.Scanner;

public class Monhoc implements Serializable {
    private static int idTemp = 100;
    private int id;
    private String tenmonhoc;
    private int sodonvihoctrinh;

    public Monhoc() {
        this.id = idTemp++;
    }

    public Monhoc(String tenmonhoc, int sodonvihoctrinh) {
        this.tenmonhoc = tenmonhoc;
        this.sodonvihoctrinh = sodonvihoctrinh;
    }

    public static int getIdTemp() {
        return idTemp;
    }

    public static void setIdTemp(int idTemp) {
        Monhoc.idTemp = idTemp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenmonhoc() {
        return tenmonhoc;
    }

    public void setTenmonhoc(String tenmonhoc) {
        this.tenmonhoc = tenmonhoc;
    }

    public int getSodonvihoctrinh() {
        return sodonvihoctrinh;
    }

    public void setSodonvihoctrinh(int sodonvihoctrinh) {
        this.sodonvihoctrinh = sodonvihoctrinh;
    }

    public void inputInfo(){
        Scanner sc = new Scanner(System.in);
        this.setId(idTemp);
        System.out.println("Nhập thông tin môn học : ");
        System.out.println("Nhập tên môn học : ");
        do {
            this.setTenmonhoc(sc.nextLine());
            if (this.getTenmonhoc().length() >= 6 && this.getTenmonhoc().length() <= 30) {
                break;
            } else {
                System.out.println("Tên môn học phải từ 6-30 ký tự, vui lòng nhập lại : ");
            }
        } while (true);
        System.out.println("Nhập số đơn vị học trình : ");
        do {
            this.setSodonvihoctrinh(sc.nextInt());
            if (this.getSodonvihoctrinh() > 0 && this.getSodonvihoctrinh() < 10) {
                break;
            } else {
                System.out.println("Số đơn vị học trình phải lớn hơn  0 và nhỏ hơn 10, vui lòng nhập lại : ");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + tenmonhoc + '\'' +
                ", sodonvihoctrinh='" + sodonvihoctrinh + '\'' +
                '}';
    }

}
