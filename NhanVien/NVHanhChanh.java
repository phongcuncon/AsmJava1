package NhanVien;

public class NVHanhChanh extends NhanVien{
    
    public NVHanhChanh() {
        super("Hanh Chanh", null, null, 0);
    }
    
    public NVHanhChanh(String hoTen, String maNV, double luong) {
        super("Hanh Chanh", hoTen, maNV, luong);
    }
    
    @Override
    public double getThuNhap() {
        return getLuong();
    }
    
    @Override
    public void showStaff() {
        super.showStaff();
        System.out.printf("|%15.1f|%10.1f|\n", getThuNhap(), getThue());
    }

}
