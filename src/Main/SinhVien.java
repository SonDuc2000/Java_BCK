package Main;

import Action.Interface;

public class SinhVien implements Interface{
	private String id;
	private String hoDem;
	private String name;
	private String ngaySinh;
	private String gioiTinh;
	
	public SinhVien() {
	}
	
	public SinhVien(String hoDem, String name, String ngaySinh, String gioiTinh) {
		super();
		this.hoDem = hoDem;
		this.name = name;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}

	public SinhVien(String id, String hoDem, String name, String ngaySinh, String gioiTinh) {
		super();
		this.id = id;
		this.hoDem = hoDem;
		this.name = name;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
	public String getFullName() {
		String name = this.hoDem + " " + this.name;
		return name;
	}
	//Hàm toString
	@Override
	public String toString() {
		return "SinhVien [id=" + id + ", name=" + getFullName() +", ngaySinh=" + ngaySinh + ", gioiTinh="
				+ gioiTinh + "]";
	}
	@Override
	public void showList() {
		System.out.println("\n_____________________________________________________________________");
		System.out.format("   %-10s%-30s%-15s%-5s", id, getFullName(), ngaySinh, gioiTinh);
	}

}
