package NhanVien;

import AssignmentJava1.QuanLyNhanVien;


public class TruongPhong extends NhanVien {
    private QuanLyNhanVien ql = new QuanLyNhanVien();
    private double luongTrachNhiem;

    public TruongPhong() {
        super("Truong Phong", null, null, 0);
    }

    public TruongPhong(String hoToTen, String maNV, double luong, double luongTrachNhiem) {
        super("Truong Phong", hoToTen, maNV, luong);
        this.luongTrachNhiem = luongTrachNhiem;
    }

    public double getLuongTrachNhiem() {
        return luongTrachNhiem;
    }

    public void setLuongTrachNhiem(double luongTrachNhiem) {
        this.luongTrachNhiem = luongTrachNhiem;
    }

    @Override
    public double getThuNhap() {
        return getLuong() + luongTrachNhiem;
    }

    @Override
    public void inputStaff() {
        super.inputStaff();
        luongTrachNhiem = ql.inputAPositiveDouble("Nhap luong trach nhiem cua truong phong: ");
    }

    @Override
    public void showStaff() {
        super.showStaff();
        System.out.printf("|%15.1f|%10.1f|\n", getThuNhap(), getThue());
    }
}


