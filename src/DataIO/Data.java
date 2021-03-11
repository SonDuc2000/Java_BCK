package DataIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Main.Diem;
import Main.MonHoc;
import Main.SinhVien;

public class Data{
	public static String Dirfile;
	public static ArrayList<SinhVien> sinhViens;
	public static ArrayList<Diem> diems;
	public static ArrayList<MonHoc> monHocs;
	
	public static String getDirfile() {
		return Dirfile;
	}

	public static void setDirfile(String dirfile) {
		Dirfile = dirfile;
	}

	public static ArrayList<SinhVien> getSinhViens() {
		return sinhViens;
	}

	public static void setSinhViens(ArrayList<SinhVien> sinhViens) {
		Data.sinhViens = sinhViens;
	}

	public static ArrayList<Diem> getDiems() {
		return diems;
	}

	public static void setDiems(ArrayList<Diem> diems) {
		Data.diems = diems;
	}

	public static ArrayList<MonHoc> getMonHocs() {
		return monHocs;
	}

	public static void setMonHocs(ArrayList<MonHoc> monHocs) {
		Data.monHocs = monHocs;
	}

	public static void openAllData() {
		try {
			Data.setDiems(Data.openFileDiem(getDirfile()));
			Data.setMonHocs(Data.openFileMonHoc(getDirfile()));
			Data.setSinhViens(Data.openFileSinhVien(getDirfile()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getHoDem(String name) {
		int index = name.lastIndexOf(" ");
		if(index == -1)
			return "";
		return name.substring(0, index);
	}
	
	public static String getTen(String name) {
		int index = name.lastIndexOf(" ");
		if(index == -1)
			return "";
		return name.substring(index + 1);
	}
	
	public static ArrayList<SinhVien> openFileSinhVien(String dirFile) throws IOException {
		ArrayList<SinhVien> sv = new ArrayList<SinhVien>();
		String toFile = dirFile.concat("\\sinhvien_en.txt");
		FileReader file = new FileReader(toFile);
		BufferedReader bur = new BufferedReader(file);
		String line;
		
		while((line = bur.readLine()) != null) {
			if(line.startsWith("#"))
				continue;
			String[] split = line.split(";");
			SinhVien s = new SinhVien(split[0], split[1], split[2], split[3], split[4]);
			sv.add(s);
		}
		
		if(bur != null) bur.close();
		
		if(file != null) file.close();
		return sv;
	}
	
	public static ArrayList<Diem> openFileDiem(String dirFile) throws IOException {
		ArrayList<Diem> diems = new ArrayList<Diem>();
		String toFile = dirFile.concat("\\diem.txt");
		FileReader file = new FileReader(toFile);
		BufferedReader bur = new BufferedReader(file);
		String line;
		while((line = bur.readLine()) != null) {
			if(line.startsWith("#"))
				continue;
			else {
				String[] split = line.split(";");
				Diem diem = new Diem(split[0], split[1], Float.parseFloat(split[2]));
				diems.add(diem);
			}
		}
		
		if(bur != null) bur.close();
		
		if(file != null) file.close();
		return diems;
	}
	
	public static ArrayList<MonHoc> openFileMonHoc(String dirFile) throws IOException{
		ArrayList<MonHoc> monHoc = new ArrayList<MonHoc>();
		String toFile = dirFile.concat("\\monhoc_en.txt");
		FileReader file = new FileReader(toFile);
		BufferedReader bur = new BufferedReader(file);
		String line;
		while((line = bur.readLine()) != null) {
			if(line.startsWith("#"))
				continue;
			String[] split = line.split(";");
			MonHoc mh = new MonHoc(split[0], split[1], Float.parseFloat(split[2]));
			monHoc.add(mh);
		}
		
		if(bur != null) bur.close();
		if(file != null) file.close();
		
		return monHoc;
	}
	
	public static String[] splitString(String data) {
		String[] split = data.split(";");
		return split;
	}

}
