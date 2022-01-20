package monhoc;


import java.io.Serializable;
import java.util.Scanner;

public class Monhoc implements Serializable {
    private static int idTemp = 100;
    private int id;
    private String tenmon;
    private int sodonvi;

    public Monhoc() {
        this.id = idTemp++;
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

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getSodonvi() {
        return sodonvi;
    }

    public void setSodonvi(int sodonvi) {
        this.sodonvi = sodonvi;
    }

    public Monhoc(int id, String tenmon, int sodonvi) {
        this.id = id;
        this.tenmon = tenmon;
        this.sodonvi = sodonvi;
    }
    public void nhapMonHoc(){
        Scanner sc = new Scanner(System.in);
        this.setId(idTemp);
        System.out.println("Nhập thông tin môn học : ");
        System.out.println("Nhập tên môn học : ");
        do {
            this.setTenmon(sc.nextLine());
            if (this.getTenmon().length() >= 6 && this.getTenmon().length() <= 30) {
                break;
            } else {
                System.out.println("Tên môn học phải từ 6-30 ký tự, vui lòng nhập lại : ");
            }
        } while (true);
        System.out.println("Nhập số đơn vị học trình : ");
        do {
                this.setSodonvi(sc.nextInt());
                if (this.getSodonvi() > 0 && this.getSodonvi() < 10) {
                    break;
                } else {
                    System.out.println("Số đơn vị học trình phải lớn hơn  0 và nhỏ hơn 10, vui lòng nhập lại : ");
                }
        } while (true);
    }

    @Override
    public String toString() {
        return "Monhoc{" +
                "id=" + id +
                ", tenmon='" + tenmon + '\'' +
                ", sodonvi=" + sodonvi + '\'' +
                '}';
    }
}
