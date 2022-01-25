package school;

import java.io.Serializable;
import java.util.Scanner;

public class Subject extends Monhoc implements Serializable {
    private int id = super.getId();
    private String subjectType;

    private static final String DAICUONG = "Đại cương";
    private static final String COSONGANH = "Cơ sở ngành";
    private static final String CHUYENNGANH = "Chuyên ngành";

    private static int AUTO_ID = 10000;

    public Subject() {
    }

    public Subject(int id, String tenmonhoc, int sodonvihoctrinh, String subjectType) {
        super(tenmonhoc, sodonvihoctrinh);
        this.id = id;
        this.subjectType = subjectType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static String getDAICUONG() {
        return DAICUONG;
    }

    public static String getCOSONGANH() {
        return COSONGANH;
    }

    public static String getCHUYENNGANH() {
        return CHUYENNGANH;
    }

    public String getsubjectType() {
        return subjectType;
    }

    public void setsubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public void inputMonhoc() {
        Scanner sc = new Scanner(System.in);
        super.inputInfo();
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
                        this.setsubjectType(arr[0]);
                        break;
                    case 2:
                        this.setsubjectType(arr[1]);
                        break;
                    case 3:
                        this.setsubjectType(arr[2]);
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
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + getTenmonhoc() + '\'' +
                ", sodonvihoctrinh='" + getSodonvihoctrinh() + '\'' +
                ", subjectType='" + subjectType + '\'' +
                '}';
    }
}
