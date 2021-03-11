package Main;

import Action.Interface;

public class Diem implements Interface{
	private String maSinhVien;
	private String maMonHoc;
	private float diem;
	
	public Diem() {}

	public Diem(String maSinhVien, String maMonHoc, float diem) {
		super();
		this.maSinhVien = maSinhVien;
		this.maMonHoc = maMonHoc;
		this.diem = diem;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public float getDiem() {
		return diem;
	}

	public void setDiem(float diem) {
		this.diem = diem;
	}

	@Override
	public String toString() {
		return "Diem [maSinhVien=" + maSinhVien + ", maMonHoc=" + maMonHoc + ", diem=" + diem + "]";
	}

	@Override
	public void showList() {
		System.out.println("--------------------------------------------------------");
		System.out.format("");
		
	}
	
	

}
