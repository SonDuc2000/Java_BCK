package Manager;

import java.util.ArrayList;
import java.util.List;
import DataIO.Data;
import Main.Diem;
import Main.MonHoc;

public class QuanLyMonHoc {
	
	public static ArrayList<MonHoc> load_FileMonHoc() {
		ArrayList<MonHoc> monHoc = new ArrayList<MonHoc>();
		try {
			for (MonHoc mh : Data.getMonHocs()) {
				monHoc.add(mh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return monHoc;
	}
	
	public static void showListMonHoc(List<MonHoc> monHocs) {
		for (int i = 0; i < monHocs.size(); i++) {
			monHocs.get(i).showList();
		}
	}
	
	public static List<String> getListSV(String idMH, List<Diem> diem){
		List<String> ds = new ArrayList<String>();
		for (Diem diems : diem) {
			if(diems.getMaMonHoc().equals(idMH)) {
				ds.add(diems.getMaSinhVien());
			}
		}
		return ds;
	}
	
	public static String getTenMH(String id, List<MonHoc> monHocs) {
		for (MonHoc mh : monHocs) {
			if(mh.getMaMonHoc().equals(id)) {
				return mh.getTenMonHoc();
			}
		}
		return "";
	}
	
	public static float getHeSo(String id, List<MonHoc> mh) {
		for (MonHoc monHoc : mh) {
			if(monHoc.getMaMonHoc().equals(id))
				return monHoc.getHeSoDiem();
		}
		return 0.0f;
	}

}
