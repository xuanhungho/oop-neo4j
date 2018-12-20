package controller;

import java.util.Calendar;  
import java.util.Random;

import data.DataExample;
import model.Event;

public class CreateEvent{
	
	public String Tempid;

	DataExample data = new DataExample();

	public String randomNhan() {
		String nhan = null ;
		nhan = data.event[new Random().nextInt(data.event.length)];
		Tempid = nhan;
		return nhan;
	}

	public String randomMoTa() {
		String des = null;
		des = data.event[new Random().nextInt(data.event.length)];
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
	
	public String randomDiaDiem() {
		String nhan = null ;
		nhan = data.location[new Random().nextInt(data.location.length)];
		return nhan;
	}
	
	public String randomDaiDien() {
		String nhan = null ;
		nhan = data.firstName[new Random().nextInt(data.firstName.length)]+" "+
				data.midName[new Random().nextInt(data.midName.length)]+" "+
				data.lastName[new Random().nextInt(data.lastName.length)];
		return nhan;
	}

	public String randomTime(int i) {
		Calendar calendar = Calendar.getInstance();
		i = i%6500+new Random().nextInt(15);
		calendar.add(Calendar.DATE, -i);
		String a =  calendar.getTime().toString();
		return a.substring(0,11)+" "+a.substring(24,28);
	}
	
	public void CreateNodeEvent(int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		Event Event = new Event();
		try {		
			System.out.println("Đang thêm node Event...");
			for(int i=0; i<num; i++) {	
				Event.setNhan(randomNhan());
				Event.setDinhdanh(randomDinhDanh(i));
				Event.setMota(randomMoTa());
				Event.setLink(randomLink());
				Event.setDate(randomThoiGian(i));
				Event.setDaidientochuc(randomDaiDien());
				Event.setDiadiem(randomDiaDiem());
				Event.setTime(randomTime(i));
				
				Neo4j.connection.execute("CREATE ("+Event.getDinhdanh()+":Event { "
					+ "Nhan: '"+Event.getNhan()+"', "
					+ "DinhDanh: '"+Event.getDinhdanh()+"', "
					+ "Mota: '"+Event.getMota()+"', "
					+ "LinkTrichRut: '"+Event.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Event.getDate()+"', "
					+ "DiaDiem: '"+Event.getDiadiem()+"', "
					+ "ThoiGianToChuc: '"+Event.getTime()+"', "
					+ "DaiDien: '"+Event.getDaidientochuc()+"'})");
		
//				System.out.println("Da them "+Event.getDinhdanh()+"!");
		}	
			
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thêm Event: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

}
