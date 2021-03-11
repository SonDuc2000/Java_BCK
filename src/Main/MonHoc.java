package Main;

import Action.Interface;

public class MonHoc implements Interface{
	private String maMonHoc;
	private String tenMonHoc;
	private float heSoDiem;
	
	public MonHoc() {}

	public MonHoc(String maMonHoc, String tenMonHoc, float heSoDiem) {
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.heSoDiem = heSoDiem;
	}

	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public float getHeSoDiem() {
		return heSoDiem;
	}

	public void setHeSoDiem(float heSoDiem) {
		this.heSoDiem = heSoDiem;
	}

	@Override
	public String toString() {
		return "MonHoc [maMonHoc=" + maMonHoc + ", tenMonHoc=" + tenMonHoc + ", heSoDiem=" + heSoDiem + "]";
	}

	@Override
	public void showList() {
		System.out.println("\n-------------------------------------------------------------------");
		System.out.format("   %-10s%-30s%.1f", this.maMonHoc, this.tenMonHoc, this.heSoDiem);
	}

}
