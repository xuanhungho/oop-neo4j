package controller;

import java.util.Calendar;  
import java.util.Random;

import data.DataExample;
import model.Time;

public class CreateTime{
	String Tempid;
	
	DataExample data = new DataExample();

	public String randomNhan(int i) {
		Calendar calendar = Calendar.getInstance();
		i = i%6500;
		calendar.add(Calendar.DATE, -i);
		Tempid = calendar.getTime().toString();
		String a =  calendar.getTime().toString();
		return a.substring(0,11)+" "+a.substring(24,28);
	}

	public String randomMoTa() {
		return Tempid;
	}
	
	public String randomLink() {
		String link ;
		link = data.link[new Random().nextInt(data.link.length)];
		return link;
	}
	
	public String randomThoiGian(int i) {
		Calendar calendar = Calendar.getInstance();
		i = i%6500+new Random().nextInt(15);
		calendar.add(Calendar.DATE, -i);
		String a =  calendar.getTime().toString();
		return a.substring(0,11)+" "+a.substring(24,28);
	}
	
	public String randomDinhDanh(int i) {
		String tem = "Time";
		return tem+i;
	}
	
	public void CreateNodeTime(int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		Time Time = new Time();

		try {
			System.out.println("Đang thêm node Time...");
				for(int i=0; i<num; i++) {	
				Time.setNhan(randomNhan(i));
				Time.setDinhdanh(randomDinhDanh(i));
				Time.setMota(randomMoTa());
				Time.setLink(randomLink());
				Time.setDate(randomThoiGian(i));

				Neo4j.connection.execute("CREATE ("+Time.getDinhdanh()+":Time { "
					+ "DinhDanh: '"+Time.getDinhdanh()+"', "
					+ "Nhan: '"+Time.getNhan()+"', "
					+ "Mota: '"+Time.getMota()+"', "
					+ "LinkTrichRut: '"+Time.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Time.getDate()+"'})");
//				System.out.println("Da them "+Time.getDinhdanh()+"!");
		}	
		
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thời gian thực hiện: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
