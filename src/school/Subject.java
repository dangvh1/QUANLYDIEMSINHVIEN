package school;

import monhoc.Monhoc;

import java.io.Serializable;
import java.util.Scanner;

public class Subject extends Monhoc implements Serializable {
    private int id = super.getId();
    public String getLoaimon() {
        return loaimon;
    }

    public void setLoaimon(String loaimon) {
        this.loaimon = loaimon;
    }

    private String loaimon;

    public Subject() {
        super();

    }

    public Subject(int id, String tenmon, int sodonvi, String loaimon) {
        super(id, tenmon, sodonvi);
        this.loaimon = loaimon;
    }

    public void inputMonHoc(){
        Scanner sc = new Scanner(System.in);
        super.nhapMonHoc();
        System.out.println("Trình độ: ");
        String[] arr = {"Đại Cương", "Cơ Sở Ngành", "Chuyên Ngành"};
        boolean check = true;
        do {
            int a = 0;
            System.out.println(" Chọn loại môn học:");
            System.out.println("1: Đại Cương");
            System.out.println("2: Cơ Sở Ngành");
            System.out.println("3: Chuyên Ngành");
            a = sc.nextInt();
            try {
                switch (a){
                    case 1:
                        this.setLoaimon(arr[0]);
                        break;
                    case 2:
                        this.setLoaimon(arr[1]);
                        break;
                    case 3:
                        this.setLoaimon(arr[2]);
                        break;
                    default:
                        System.out.println("Chỉ được chọn từ 1-3, vui lòng chọn lại : ");
                        check = false;
                        break;
                }
            }catch (NumberFormatException e) {
                // TODO: handle exception
                System.out.println(" Vui lòng chọn lại : ");
            }
        }while (!true);
    }

    @Override
    public String toString(){
        return "Subject{" +
                "ID : " + getId() +
                ", tenmon : '" + getTenmon() + '\'' +
                ", sodonvi : " + getSodonvi() +'\'' +
                ", loaimon : '" + getLoaimon() + '\'' +
                '}';
    }



}
