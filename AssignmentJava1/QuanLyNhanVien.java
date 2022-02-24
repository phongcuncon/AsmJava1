// thepv4@fe.edu.vn
package AssignmentJava1;

import NhanVien.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyNhanVien {

    private final ArrayList<NhanVien> ls = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    private NhanVien nv;
    
    // VE DUONG THANG
    public void drawLine(char c, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
        System.out.println("");
    }
    
    // NHAP SO NGUYEN > 0
    public int inputAPositiveInteger(String s) {
        int i;
        do {
            while (true) {
                try {
                    System.out.print(s);
                    i = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Vui long nhap dung dinh dang so!\n");
                }
            }
            
            if (i > 0)
                break;
            else 
                System.out.println("\nNhap sai, vui long nhap lai!\n");
        } while (true);
        
        return i;
    }
//       
    // NHAP SO THUC > 0
    public double inputAPositiveDouble(String s) {
        double d;
        do {
            while (true) {
                try {
                    System.out.print(s);
                    d = Double.parseDouble(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Vui long nhap dung dinh dang so!\n");
                }
            }
            
            if (d > 0)
                break;
            else 
                System.out.println("\nNhap sai, vui long nhap lai!\n");
        } while (true);
        
        return d;
    }
    
    // NHAP CHUOI
    public String inputString(String s) {
        String str;
        System.out.print(s);
        str = sc.nextLine();
        return str;
    }
    
    // NHAP LUA CHON LOAI NHAN VIEN
    public int chooseStaff() {
        int choice;
        System.out.print("\n\t\t");
        drawLine('=', 26);
        System.out.println("\t\t| BANG NHAN VIEN");
        System.out.println("\t\t|1. Nhan vien hanh chinh");
        System.out.println("\t\t|2. Nhan vien tiep thi");
        System.out.println("\t\t|3. Truong phong");
        System.out.print("\t\t");
        drawLine('=', 26);
        while (true) {
            try {
                do {  // XET DIEU KIEN NHAP LUONG < 0
                    System.out.print("\nMoi nhap loai nhan vien: ");
                    choice = Integer.parseInt(sc.nextLine());
                        
                    if (choice < 1 || choice > 3) {
                        System.out.println("Chuc nang khong hop le vui long chon lai!\n");
                    }
                } while (choice < 1 || choice > 3);
                break;
            } catch (Exception e) {
                System.out.println("Vui long nhap dung dinh dang so!\n");
            }
        }
        return choice;
    }
    
    // HIEN THI TIEU DE
    public void showStaffsListTitle() {
        System.out.printf("\t|%-14s|%-15s|%-9s|%15s|%15s|%10s|\n", "Loai NV", "Ten NV", "Ma NV", "Luong", "Thu nhap", "Thue");
        System.out.print("\t");
        drawLine('_', 85);
    }
    
    //////////////////  ASSIGNMENT /////////////////
    
    // KIEM TRA MA NHAN VIEN, NEU TIM THAY THI RETURN LAI VI TRI DO,
    // KHONG TIM THAY THI RETURN -1
    public int checkStaffID(ArrayList<NhanVien> ls, String find) { 
        for (int i = 0; i < ls.size(); i++) {
            if(ls.get(i).getMaNV().equalsIgnoreCase(find)) {
                return i;
            }
        }
        return -1;
    }
    
    // Y1: NHAP DANH SACH NHAN VIEN TU BAN PHIM
    public void inputStaffsList() {
        drawLine('=', 100);
        int i = 0;
        System.out.println("\nNHAP THONG TIN NHAN VIEN");
        do {
            int choice = chooseStaff();
            switch (choice) {
                case 1:
                    nv = new NVHanhChanh();
                    break;
                case 2:
                    nv = new NVTiepThi();
                    break;
                case 3:
                    nv = new TruongPhong();
                    break;
            }
            System.out.println("\nNhan vien " + (i + 1) + ": ");
            nv.inputStaff();
            ls.add(nv);

            OUTER: do {
                int check = inputAPositiveInteger("\nBan co muon nhap tiep (1: Yes/ 2: No): ");
                switch (check) {
                    case 1:
                        break OUTER;
                    case 2:
                        System.out.println("Nhap danh sach thanh cong. Chon 2 de xuat danh sach!\n");
                        drawLine('=', 100);
                        return;
                    default: 
                        System.out.println("Nhap khong hop le. Vui long nhap lai!\n");
                        break;
                }
    
            } while (true);
            
            i++;
        } while (true);   
    }
    
    // Y2: XUAT DANH SACH NHAN VIEN
    public void showStaffsList() {
        drawLine('=', 120);
        if (!ls.isEmpty()) {
            System.out.println("\n\t\t\t\t\tDANH SACH NHAN VIEN\n");
            showStaffsListTitle();
            for (NhanVien nv : ls) {
                nv.showStaff();
                
                System.out.print("\t");
                drawLine('_', 85);
            }
            System.out.println("\n\n");
        } else {
            System.out.println("\nDanh sach trong! Vui long chon 1 de nhap danh sach nhan vien!\n");
        }
        
        drawLine('=', 120);
    }
    
    // Y3: TIM VA HIEN THI NHAN VIEN THEO MA
    public void findAndShowStaffByID() {
        drawLine('=', 100);
        if (!ls.isEmpty()) {
            String find = inputString("Nhap ma nhan vien muon tim: ");
            int index = checkStaffID(ls, find);
            
            if(index != -1) {
                System.out.print("\nKet qua tim thay:");
                ls.get(index).showStaff();
            }  
            else 
                System.out.println("\nKhong tim thay ma nhan vien trong danh sach!\n");
            
        } else {
            System.out.println("\nDanh sach trong! Vui long chon 1 de nhap danh sach nhan vien!\n");
        }
        drawLine('=', 100);
    }
    
    // Y4: XOA NHAN VIEN THEO MA
    public void deleteStaffByID() {
        if (!ls.isEmpty()) {
            showStaffsList();
            String find = inputString("Nhap ma nhan vien muon xoa: ");
            
            int index = checkStaffID(ls, find);
            if(index != -1) {
                ls.remove(ls.get(index));
                System.out.println("\nXoa thanh cong, chon 2 de hien thi lai danh sach\n");
            }    
            else 
                System.out.println("\nKhong tim thay ma nhan vien trong danh sach!\n");
        } else {
            drawLine('=', 100);
            System.out.println("\nDanh sach trong! Vui long chon 1 de nhap danh sach nhan vien!\n");
        }
        drawLine('=', 100);
    }

    // Y5: CAP NHAT NHAN VIEN THEO MA
    public void updateStaffByID() {
        if (!ls.isEmpty()) {
            showStaffsList();
            String find = inputString("\nNhap ma nhan vien muon cap nhat: ");
            
            int index = checkStaffID(ls, find);
            if (index != -1) {
                int choice = chooseStaff();
                switch(choice) {
                    case 1:
                        nv = new NVHanhChanh();
                        break;
                    case 2:
                        nv = new NVTiepThi();
                        break;
                    case 3:
                        nv = new TruongPhong();
                        break;
                    }
                nv.inputStaff();
                ls.set(index, nv);
                System.out.println("Cap nhat thanh cong, chon 2 de hien thi danh sach!\n");
            }
            else
                System.out.println("\nKhong tim ma nhan vien trong danh sach!\n");

        } else {
            drawLine('=', 100);
            System.out.println("\nDanh sach trong! Vui long chon 1 de nhap danh sach nhan vien!\n");
            
        }
        drawLine('=', 100);
        
    }

    // Y6: TIM NHAN VIEN THEO KHOANG LUONG
    
    // TIM RA CAC NHAN VIEN TRONG KHOANG LUONG ROI TRA VE MOT MANG RIENG
    public ArrayList<NhanVien> findStaffsInSalaryRange(double slrBegin, double slrEnd) {
        ArrayList<NhanVien> newLs = new ArrayList<>();
        for (NhanVien nv : ls) {
            if (nv.getLuong() >= slrBegin && nv.getLuong() <= slrEnd) {
                newLs.add(nv);
            }
         }
        return newLs;
    }
 
    // KIEM TRA XEM MANG MOI CO BI TRONG KHONG
    public int checkStaffsInSalaryRangeIsEmpty(ArrayList<NhanVien> newLs) {
        if(!newLs.isEmpty()) {
            return 1;
        }
        return 0;
    }
    
    public void getStaffsInSalaryRange() {
        drawLine('=', 100);
        if (!ls.isEmpty()) {
            double slrBegin, slrEnd;
            slrBegin = inputAPositiveDouble("\nNhap luong bat dau: ");

            do {
                slrEnd = inputAPositiveDouble("Nhap luong ket thuc: ");
                if (slrEnd > slrBegin)
                    break;
                else
                    System.out.println("Luong ket thuc be hon luong bat dau, vui long nhap lai!\n");
            } while(true);
            
            System.out.println("\nKET QUA\n");
            drawLine('=', 120);
            System.out.println("\n\t\t\t\t\tDANH SACH NHAN VIEN\n");
            showStaffsListTitle();
            
            ArrayList<NhanVien> newLs = findStaffsInSalaryRange(slrBegin, slrEnd);
            
            if(checkStaffsInSalaryRangeIsEmpty(newLs) == 1) {
                for (NhanVien nv : newLs) {
                    nv.showStaff();
                    System.out.print("\t");
                    drawLine('_', 85);
                }
                System.out.println("\n\n");
            } else 
                System.out.println("\tKHONG TIM THAY NHAN VIEN TRONG KHOANG LUONG DO!\n");
            
        } else {
            System.out.println("\nDanh sach trong! Vui long chon 1 de nhap danh sach nhan vien!\n");
        }
        drawLine('=', 100);
    }

    // Y7: SAP XEP NHAN VIEN THEO HO TEN
    public void sortStaffsByName() {
        drawLine('=', 100);
        if (!ls.isEmpty()) {
            Collections.sort(ls, (a, b) -> a.getHoTen().compareTo(b.getHoTen()));
            System.out.println("\nSap xep thanh cong. Chon 2 de xuat danh sach nhan vien!\n");
        } else {
            System.out.println("\nDanh sach trong! Vui long chon 1 de nhap danh sach nhan vien!\n");
        }
        drawLine('=', 100);
    }

    // Y8: SAP XEP NHAN VIEN THEO THU NHAP
    public void sortStaffsByIncome() {
        drawLine('=', 100);
        if (!ls.isEmpty()) {
            Collections.sort(ls, (a, b) -> (int) (b.getThuNhap() - a.getThuNhap()));
            System.out.println("\nSap xep giam dan thanh cong. Chon 2 de xuat lai danh sach!\n");
        } else {
            System.out.println("\nDanh sach trong! Vui long chon 1 de nhap danh sach nhan vien!\n");
        }
        drawLine('=', 100);
    }

    // Y9: XUAT 5 NHAN VIEN CO THU NHAP CAO NHAT
    public int getLengthStaffsList(ArrayList<NhanVien> nv) {
    // KIỂM TRA ĐỘ DÀI ARRAY LIST ĐỂ TRÁNH TÌNH TRẠNG DÍNH EXCEPTION TRÀN LIST
        if (nv.size() < 5) {
            return nv.size();
        }
        return 5;
    }
    
    public void get5StaffsWithHighestSalary() {
        drawLine('=', 100);
        if (!ls.isEmpty()) {
            Collections.sort(ls, (a, b) -> (int) (b.getThuNhap() - a.getThuNhap()));

            int len = getLengthStaffsList(ls);
            
            System.out.println("\n\t\t\t\t\tTOP 5 NHAN VIEN CO THU NHAP CAO NHAT\n");
            showStaffsListTitle();
            for (int i = 0; i < len; i++) {
                ls.get(i).showStaff();
                System.out.print("\t");
                drawLine('_', 85);
            }
            System.out.println("\n\n");
        } else {
            System.out.println("\nDanh sach trong! Vui long chon 1 de nhap danh sach nhan vien!\n");
        }
        drawLine('=', 100);
        System.out.println("");
    }

}
