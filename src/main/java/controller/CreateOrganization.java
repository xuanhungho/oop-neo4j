package controller;

import java.util.Calendar;  
import java.util.Random;

import data.DataExample;
import model.Organization;

public class CreateOrganization {

	String Tempid;
	DataExample data = new DataExample();

	public String randomNhan() {
		String nhan = null ;
		nhan = data.nameOrganization[new Random().nextInt(data.nameOrganization.length)];
		this.Tempid = nhan;
		return nhan;
	}

	public String randomMoTa() {
		String des = null;
		des = data.descriptionOrganization[new
		                Random().nextInt(data.descriptionOrganization.length)];
		return des;
	}

	public String randomLink() {
		String link ;
		link = data.link[new Random().nextInt(data.link.length)];
		return link;
	}

	public String randomTruSo() {
		String truso;
		truso = data.location[new Random().nextInt(data.location.length)];
		return truso;
	}
	
	public String randomThoiGian(int i) {
		Calendar calendar = Calendar.getInstance();
		i = i%6500;
		calendar.add(Calendar.DATE, -i);
		String a =  calendar.getTime().toString();
		return a.substring(0,11)+" "+a.substring(24,28);
	}
	public String randomDinhDanh(int i) {
		String tem = Tempid.replace(" ", "_");
		return tem+i;
	}
	
	public void CreateNodeOrganization(int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		Organization Org = new Organization();
		try {
			System.out.println("Đang thêm node Organization...");
			for(int i=0; i<num; i++) {	
				Org.setNhan(randomNhan());
				Org.setDinhdanh(randomDinhDanh(i));
				Org.setMota(randomMoTa());
				Org.setLink(randomLink());
				Org.setDate(randomThoiGian(i));
				Org.setTruSo(randomTruSo());
				
				Neo4j.connection.execute("CREATE ("+Org.getDinhdanh()+":Organization { "
					+ "DinhDanh: '"+Org.getDinhdanh()+"', "
					+ "Nhan: '"+Org.getNhan()+"', "
					+ "Mota: '"+Org.getMota()+"', "
					+ "LinkTrichRut: '"+Org.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Org.getDate()+"', "
					+ "TruSo: '"+Org.getTruSo()+"'})");
//			System.out.println("Da them Org "+Org.getDinhdanh()+"!");
		}	
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thêm Organization: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
