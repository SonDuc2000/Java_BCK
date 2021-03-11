package Main;

import java.util.Scanner;

import DataIO.Data;
import Manager.ManagerAll;
import Manager.QuanLySinhVien;


public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Xin lỗi được chưa
		//QuanLySinhVien sinhVien = new QuanLySinhVien();
		//System.out.println(args.length);
		//QuanLyMonHoc monHoc = new QuanLyMonHoc();
		/*
		 * List<SinhVien> sv = new ArrayList<SinhVien>(); List<MonHoc> monHoc = new
		 * ArrayList<MonHoc>(); try { QuanLySinhVien.load_fileSV(getFile(args), sv);
		 * QuanLyMonHoc.load_FileMonHoc(getFile(args), monHoc);
		 * System.out.println("args:" + getFile(args));
		 * 
		 * QuanLyMonHoc.showListMonHoc( monHoc); QuanLySinhVien.showListSv(sv); } catch
		 * (Exception e) { // TODO: handle exception }
		 */
		/*
		 * List<SinhVien> sv = new ArrayList<SinhVien>(); List<Diem> diem = new
		 * ArrayList<Diem>(); List<MonHoc> mh = new ArrayList<MonHoc>();
		 */
		/*
		 * QuanLyBangDiem.load_FileDiem("C:\\data", diem);
		 * QuanLySinhVien.load_fileSV("C:\\data", sv);
		 * QuanLyMonHoc.load_FileMonHoc("C:\\data", mh);
		 */
		/*
		 * int length = QuanLyBangDiem.getDsMH("SV00510", diem).size(); for (int i = 0;
		 * i < length; i++) { String maMH = QuanLyBangDiem.getDsMH("SV00510",
		 * diem).get(i);
		 * System.out.println("\n-----------------------------------------------");
		 * System.out.format("%-10s%-30s%10.2f", maMH , QuanLyMonHoc.getTenMH(maMH, mh)
		 * , QuanLyBangDiem.getDiem("SV00510", maMH, diem)); }
		 */
		String[] file = new String[1];
		file[0] = "-dir=C:\\data";
		
		getFile(file);
		
		Data.openAllData();
		System.out.println("Nhap id sinh vien muon xem: ");
		ManagerAll.showBangDiem();
		System.out.println("Nhap id sinh vien muon xem: ");
		ManagerAll.showMonHoc();
		System.out.println("Nhap id sinh vien muon xem: ");
		//String id = sc.nextLine();
		//managerAll.searchDiemByMonHoc(id);
		
		
		//System.out.println("Nhập id sinh viên cần tìm: ");
		//String id= sc.nextLine();
		//sinhVien.searchById(id);
		//sinhVien.editSinhVien(id);
		
	}
	
	public static void getFile(String[] s) {
		int index = s[0].indexOf("dir=");
		if(s.length > 1) {
			Data.setDirfile(s[0].substring(index + 4).concat(" " + s[1]));
		}
		else
			Data.setDirfile(s[0].substring(index + 4));
	}

}
