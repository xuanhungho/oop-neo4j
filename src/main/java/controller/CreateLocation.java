package controller;

import java.util.Calendar;  
import java.util.Random;

import data.DataExample;
import model.Location;

public class CreateLocation{

	public String Tempid;
	DataExample data = new DataExample();

	public String randomNhan() {
		String nhan = null ;
		nhan = data.location[new Random().nextInt(data.location.length)];
		Tempid = nhan;
		return nhan;
	}

	public String randomMoTa() {
		String des = null;
		des = data.desquoctich[new Random().nextInt(data.desquoctich.length)];
		return des;
	}

	public String randomLink() {
		String link ;
		link = data.link[new Random().nextInt(data.link.length)];
		return link;
	}
	
	public String randomThoiGian(int i) {
		Calendar calendar = Calendar.getInstance();
		i = i%6500;
		calendar.add(Calendar.DATE, -i);
		String a =  calendar.getTime().toString();
		return a.substring(0,11)+" "+a.substring(24,28);
	}
	
	public String randomDinhDanh(int i) {
		String tem = (Tempid).replace(" ", "_");
		return tem+i;
	}
	public String randomQuocGia() {
		String des = null;
		des = data.quoctich[new Random().nextInt(data.quoctich.length)];
		return des;
	}
	
	public void CreateNodeLocation(int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		Location Location = new Location();
		try {
			System.out.println("Đang thêm node Location...");
			for(int i=0; i<num; i++) {	
				Location.setNhan(randomNhan());
				Location.setDinhdanh(randomDinhDanh(i));
				Location.setMota(randomMoTa());
				Location.setLink(randomLink());
				Location.setDate(randomThoiGian(i));
				Location.setQuocGia(randomQuocGia());
				
				Neo4j.connection.execute("CREATE ("+Location.getDinhdanh()+":Location { "
					+ "DinhDanh: '"+Location.getDinhdanh()+"', "
					+ "Nhan: '"+Location.getNhan()+"', "
					+ "Mota: '"+Location.getMota()+"', "
					+ "LinkTrichRut: '"+Location.getLink()+"', "			
					+ "ThoiGianTrichRut:'"+Location.getDate()+"', "
					+ "QuocGia: '"+Location.getQuocGia()+"'})");
//				System.out.println("Da them "+Location.getDinhdanh()+"!");
		}	
			
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thêm Location: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

}
