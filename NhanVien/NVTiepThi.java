package NhanVien;

import AssignmentJava1.QuanLyNhanVien;

public class NVTiepThi extends NhanVien {
    private QuanLyNhanVien ql = new QuanLyNhanVien();
    private double doanhSo, hueHong;

    public NVTiepThi() {
        super("Tiep Thi", null, null, 0);
    }

    public NVTiepThi(String hoTen, String maNV, double luong, double doanhSo, double hueHong) {
        super("Tiep Thi", hoTen, maNV, luong);
        this.doanhSo = doanhSo;
        this.hueHong = hueHong;
    }

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public double getHueHong() {
        return hueHong;
    }

    public void setHueHong(double hueHong) {
        this.hueHong = hueHong;
    }

    @Override
    public double getThuNhap() {
        return getLuong() + doanhSo + hueHong;
    }

    @Override
    public void inputStaff() {
        super.inputStaff();
        doanhSo = ql.inputAPositiveDouble("Nhap doanh so cua nhan vien tiep thi: ");
        hueHong = ql.inputAPositiveDouble("Nhap hue hong cua nhan vien tiep thi: ");

    }

    @Override
    public void showStaff() {
        super.showStaff();
        System.out.printf("|%15.1f|%10.1f|\n", getThuNhap(), getThue());
    }
}

