// NGUYỄN THÀNH VINH - PS23411 - CP17309
package AssignmentJava1;

import java.util.Scanner;

public class AssignmentJava1 {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        menu();
        
    }
    
    public static void menu() {
        QuanLyNhanVien nv = new QuanLyNhanVien();
        int choice;
        do{ 
            nv.drawLine('_', 100);
            System.out.println("\n\t\t ___________________________________________________\t\t ___________________");
            System.out.println("\t\t|                                                   |\t\t|                   |");
            System.out.println("\t\t|                       MENU                        |\t\t| NGUYEN THANH VINH |");
            System.out.println("\t\t|___________________________________________________|\t\t| LOP: CP17309      |");
            System.out.println("\t\t|                                                   |\t\t| MA SO: PS23411    |");
            System.out.println("\t\t|     1. Nhap danh sach nhan vien.                  |\t\t|___________________|");
            System.out.println("\t\t|     2. Hien thi danh sach nhan vien.              |");
            System.out.println("\t\t|     3. Tim va hien thi nhan vien theo ma.         |");
            System.out.println("\t\t|     4. Xoa nhan vien theo ma                      |");
            System.out.println("\t\t|     5. Cap nhat nhan vien theo ma                 |");
            System.out.println("\t\t|     6. Tim cac nhan vien theo khoang luong        |");
            System.out.println("\t\t|     7. Sap xep nhan vien theo ho ten              |");
            System.out.println("\t\t|     8. Sap xep nhan vien theo thu nhap            |");
            System.out.println("\t\t|     9. Xuat 5 nhan vien co thu nhap cao nhat      |");
            System.out.println("\t\t|     0. Ket thuc chuong trinh                      |");
            System.out.println("\t\t|                                                   |");
            System.out.println("\t\t|______________________ END ________________________|");
            while(true) {
                try {
                    System.out.print("\nNhap lua chon: ");
                    choice = Integer.parseInt(sc.nextLine());
                    break;
                    
                } catch (Exception e) {
                    System.out.println("Vui long nhap dung dinh dang so!\n");
                }
            }
            System.out.println("");
            switch(choice){
                case 1:
                    nv.inputStaffsList();
                    break;
                case 2:
                    nv.showStaffsList();
                    break;
                case 3:
                    nv.findAndShowStaffByID();
                    break;
                case 4:
                    nv.deleteStaffByID();
                    break;
                case 5:
                    nv.updateStaffByID();
                    break;
                case 6:
                    nv.getStaffsInSalaryRange();
                    break;
                case 7:
                    nv.sortStaffsByName();
                    break;
                case 8:
                    nv.sortStaffsByIncome();
                    break;
                case 9:
                    nv.get5StaffsWithHighestSalary();
                    break;
                case 0:
                    System.out.println("CHUONG TRINH KET THUC!\n");
                    System.exit(0);
                default:
                    System.out.println("CHUC NANG KHONG HOP LE, VUI LONG NHAP LAI!");
            }
            System.out.print("Press Enter to continue.... ");
            sc.nextLine();
            System.out.println("\n");
        }while(true);
        
    }
    
}
