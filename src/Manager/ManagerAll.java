package Manager;

import java.util.ArrayList;

import Main.Diem;
import Main.MonHoc;
import Main.SinhVien;

public class ManagerAll {
	
	private static ArrayList<SinhVien> sinhViens = QuanLySinhVien.load_fileSV();
	private static ArrayList<Diem> diems = QuanLyBangDiem.load_FileDiem();
	private static ArrayList<MonHoc> monHocs = QuanLyMonHoc.load_FileMonHoc();
	
	public float getDiemTB() {

		float diemTB = 0.00f;
		if(diems.size() == 0) 
			return 0.00f;
		for (Diem diem : diems) {
			diemTB += diem.getDiem();
		}
		return diemTB/diems.size();
	}
	
	public static void showBangDiem() {
		
		for (int i = 0; i < sinhViens.size(); i++) {
			int length = QuanLyBangDiem.getDsMH(sinhViens.get(i).getId(), diems).size();
			if(length == 0) {
				System.out.println("\n__________________________________________________________");
				System.out.format("  Ma: %-10s│%-25s│%15s\n", sinhViens.get(i).getId(), 
						sinhViens.get(i).getFullName()
						, sinhViens.get(i).getNgaySinh());
				System.out.println("----------------------------------------------------------");
				System.out.format("  Diem tong ket: %36.2f\n", 0f);
				System.out.println("----------------------------------------------------------");
				System.out.println("  Chua co diem\n");
				continue;
			}
				
			else {
				float tongHeSo = 0.00f;
				float tongDiem = 0.00f;
			
				System.out.println("\n__________________________________________________________");
				System.out.format("  Ma: %-10s│%-25s│%15s\r", sinhViens.get(i).getId(), 
						sinhViens.get(i).getFullName()
						, sinhViens.get(i).getNgaySinh());
				System.out.println("__________________________________________________________");
				for (int j = 0; j < length; j++) {
					String maMH = QuanLyBangDiem.getDsMH(sinhViens.get(i).getId(), diems).get(j);
					String tenMH = QuanLyMonHoc.getTenMH(maMH, monHocs);
					float diem = QuanLyBangDiem.getDiem(sinhViens.get(i).getId(), maMH, diems);
					
					tongHeSo += QuanLyMonHoc.getHeSo(maMH, monHocs) ;
					tongDiem += diem*QuanLyMonHoc.getHeSo(maMH, monHocs);
					
					System.out.format("  %-14s│%-25s│%10.2f\r", maMH, tenMH, diem);
				}
				System.out.println("---------------------------------------------------------");
				System.out.format("  Diem tong ket: %36.2f\n\n", tongDiem/tongHeSo);
			}
		}
	}
	
	public static void showMonHoc() {
		
		for (int i = 0; i < monHocs.size(); i++) {
			float sum = 0;
			float diemTB = 0.00f;
			String maMH = monHocs.get(i).getMaMonHoc();
			System.out.println("\n_____________________________________________________");
			System.out.format("  %-10s%40s\n", monHocs.get(i).getMaMonHoc(), monHocs.get(i).getTenMonHoc());
			System.out.println("-----------------------------------------------------");
			int length = QuanLyMonHoc.getListSV(monHocs.get(i).getMaMonHoc(), diems).size();
			if(length == 0) {
				System.out.format("  %50s\n", "Chua co diem");
				System.out.format("  Diem trung binh mon hoc:%26.2f\n", 0.0f);
				System.out.println("_____________________________________________________\n");
				continue;
			} else {
				for (int j = 0; j < length; j++) {
					String id = QuanLyMonHoc.getListSV(monHocs.get(i).getMaMonHoc(), diems).get(j);
					sum += 1;
					if(sum < 10) {
						System.out.format("\n  %-10s%30s%10.2f\r", id
								, QuanLySinhVien.getName(id, sinhViens), QuanLyBangDiem.getDiem(id, maMH, diems));
					}
					
					diemTB += QuanLyBangDiem.getDiem(id, maMH, diems);
				}
				System.out.format("  . . .\r  Con %.0f sinh vien nua . . .\r", sum-10);
				System.out.println("------------------------------------------------------");
				System.out.format("  Diem trung binh mon hoc:%26.2f\r", diemTB/sum);
				System.out.println("_____________________________________________________\n\n");
			}
		}
	}
	
	public void searchDiemBySinhVien(String idSV) {
		
		int length = QuanLyBangDiem.getDsMH(idSV, diems).size();
		if(length == 0) {
			System.out.println("\n_________________________________________________________");
			System.out.format("\n  Ma: %-10s│%-25s│%15s\n", idSV, 
					QuanLySinhVien.getName(idSV, sinhViens)
					, QuanLySinhVien.getDate(idSV, sinhViens));
			System.out.println("-----------------------------------------------------------");
			System.out.format("  Diem tong ket: %36.2f\n", 0f);
			System.out.println("-----------------------------------------------------------");
			System.out.println("  Chua co diem\n");
		} else {
			float tongHeSo = 0;
			float tongDiem = 0.0f;
		
			System.out.println("\n__________________________________________________________");
			System.out.format("\n  Ma: %-10s│%-25s│%15s\n", idSV, 
					QuanLySinhVien.getName(idSV, sinhViens)
					, QuanLySinhVien.getDate(idSV, sinhViens));
			for (int j = 0; j < length; j++) {
				String maMH = QuanLyBangDiem.getDsMH(idSV, diems).get(j);
				String tenMH = QuanLyMonHoc.getTenMH(maMH, monHocs);
				float diem = QuanLyBangDiem.getDiem(idSV, maMH, diems);
				
				tongHeSo += QuanLyMonHoc.getHeSo(maMH, monHocs);
				tongDiem += diem*QuanLyMonHoc.getHeSo(maMH, monHocs);;
				
				System.out.format("\n  %-14s│%-25s│%10.2f\n", maMH, tenMH, diem);
			}
			System.out.println("----------------------------------------------------------");
			System.out.format("  Diem tong ket: %36.2f\n\n", tongDiem/tongHeSo);
		}
		
	}
	
	public void searchDiemByMonHoc(String idMH) {
		float sum = 0.0f;
		float diemTB = 0.0f;
		
		int length = QuanLyMonHoc.getListSV(idMH, diems).size();
		System.out.println("\n_____________________________________________________");
		System.out.format("  %-10s%40s\n", idMH, QuanLyMonHoc.getTenMH(idMH, monHocs));
		System.out.println("-----------------------------------------------------");
		if(length == 0) {
			System.out.format("  %50s\n", "Chua co diem");
			System.out.format("  Diem trung binh mon hoc:%26.2f\n", 0.0f);
			System.out.println("_____________________________________________________\n");
		} else {
			for (int j = 0; j < length; j++) {
				sum += 1;
				String id = QuanLyMonHoc.getListSV(idMH, diems).get(j);
				System.out.format("\n  %-10s%30s%10.2f\r", id
							, QuanLySinhVien.getName(QuanLySinhVien.getMaSV(id, sinhViens), sinhViens), QuanLyBangDiem.getDiem(id, idMH, diems));
				
				diemTB += QuanLyBangDiem.getDiem(id, idMH, diems);
			}
			System.out.println("------------------------------------------------------");
			System.out.format("  Diem trung binh mon hoc:%26.2f\r", diemTB/sum);
			System.out.println("_____________________________________________________\n\n");
		}
	}
	
	

}
