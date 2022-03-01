package NhanVien;

import AssignmentJava1.QuanLyNhanVien;
public abstract class NhanVien {
    private QuanLyNhanVien ql = new QuanLyNhanVien();
    private String maNV;
    private String hoTen;
    private String loaiNV;
    private double luong;

    // CONSTRUCTOR
    public NhanVien() {
    }

    public NhanVien(String loaiNV, String hoTen, String maNV, double luong) {
        this.loaiNV = loaiNV;
        this.hoTen = hoTen;
        this.maNV = maNV;
        this.luong = luong;
    }

    public String getMaNV() {
        return maNV;
    }
    
    // SETTER AND GETTER
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getLoaiNV() {
        return loaiNV;
    }

    public void setLoaiNV(String loaiNV) {
        this.loaiNV = loaiNV;
    }
    
    // ABSTRACT
    public abstract double getThuNhap();

    public double getThue() {
        double thue;
        if (getThuNhap() < 9000000) {
            thue = 0;
        } else if (getThuNhap() < 15000000) {
            thue = (getThuNhap() - 9000000) * 0.1;
        } else {
            thue = 6000000 * 0.1 + (getThuNhap() - 15000000) * 0.12;
        }
        return thue;
    }
    
    // HAM NHAP NHAN VIEN
    public void inputStaff() {
        System.out.println("\n__________ " + loaiNV + " _________\n");
        hoTen = ql.inputString("Ten nhan vien: ");
        maNV = ql.inputString("Ma nhan vien: ");
        luong = ql.inputAPositiveDouble("Luong nhan vien: ");
    }
    
    // HAM HIEN THI NHAN VIEN
    public void showStaff() {
        System.out.printf("\t|%-14s|%-15s|%-9s|%15.1f", loaiNV, hoTen, maNV, luong);
    }
}
