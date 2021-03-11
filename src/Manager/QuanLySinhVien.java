package Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DataIO.Data;
import Main.SinhVien;

public class QuanLySinhVien {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static String getName(String id, List<SinhVien> sv) {
		for (SinhVien sinhVien : sv) {
			if(sinhVien.getId().equals(id))
				return sinhVien.getFullName();
		}
		return "";
	}
	
	public static String getDate(String id, List<SinhVien> sv) {
		for (SinhVien sinhVien : sv) {
			if(sinhVien.getId().equals(id))
				return sinhVien.getNgaySinh();
		}
		return "";
	}
	
	public static String getMaSV(String id, List<SinhVien> sv) {
		for (SinhVien sinhVien : sv) {
			if(sinhVien.getId().equals(id))
				return sinhVien.getId();
		}
		return "";
	}
	
	public static ArrayList<SinhVien> load_fileSV() {
		ArrayList<SinhVien> sv = new ArrayList<SinhVien>();
		for (SinhVien sinhVien : Data.getSinhViens()) {
			sv.add(sinhVien);
		}
		return sv;
	}
	
	public static void input(SinhVien sinhVien) {
		System.out.println("Nhập thông tin sinh viên (VD: Nguyễn A; 28/9/2000; Nam: ");
		String name = sc.nextLine();
		String[] split = name.split(";");
		sinhVien.setHoDem(Data.getHoDem(split[0]));
		sinhVien.setName(Data.getTen(split[0]));
		sinhVien.setNgaySinh(split[1]);
		sinhVien.setGioiTinh(split[2]);
	}
	
	public static void addSinhVien(String name, List<SinhVien> sv) {
		String[] list = Data.splitString(name);
		SinhVien sinhVien = new SinhVien(list[0], Data.getHoDem(list[1]), Data.getTen(list[1]), list[2], list[3]);
		for (SinhVien sinhviens : sv) {
			if(sinhviens.getId().equals(sinhVien.getId()))
				continue;
			else
			{
				sv.add(sinhVien);
				break;
			}
		}
	}
	
	public static void editSinhVien(String id, List<SinhVien> sv) {
		sv.stream().filter(o -> o.getId().equals(id)).forEach(o -> input(o));
	}
	
	public static void searchById(String idSV, List<SinhVien> sv) {
		sv.stream().filter(o -> o.getId().equals(idSV)).findFirst().
			ifPresent(o -> o.showList());
	}
	
	public static void searchByName(String name, List<SinhVien> sv) {
		
	}

}
