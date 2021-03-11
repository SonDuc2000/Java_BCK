package Manager;

import java.util.ArrayList;
import java.util.List;

import DataIO.Data;
import Main.Diem;

public class QuanLyBangDiem {
	
	public static ArrayList<Diem> load_FileDiem() {
		ArrayList<Diem> diem = new ArrayList<Diem>();
		for (Diem diem2 : Data.getDiems()) {
			diem.add(diem2);
		}
		return diem;
	}
	
	public static String getMaMH(String idSV, List<Diem> diem) {
		
		for (Diem diem2 : diem) {
			if(diem2.getMaSinhVien().equals(idSV))
			{
				return diem2.getMaMonHoc();
			}
		}
		return "";
	}
	
	public static List<String> getDsMH(String idSV, List<Diem> diem) {
		List<String> ds = new ArrayList<String>();
		for (int i = 0; i < diem.size(); i++) {
			if(diem.get(i).getMaSinhVien().equals(idSV)) {
				ds.add(diem.get(i).getMaMonHoc());
			}
		}
		return ds;
	}
	
	public static float getDiem(String maSV, String maMH, List<Diem> diem) {
		for (Diem diem2 : diem) {
			if(diem2.getMaSinhVien().equals(maSV) && diem2.getMaMonHoc().equals(maMH))
				return diem2.getDiem();
		}
		return 0.0f;
	}

}
