package controller;

import java.util.Calendar; 
import java.util.Random;

import data.DataExample;
import model.Person;

public class CreatePerson{
	
	private String Tempid;
	DataExample data = new DataExample();
	
	public String randomDinhDanh(int id) {
		return Tempid.replace(" ", "_")+id;
	}

	public String randomMoTa() {
		String des = null;
		des = data.descriptionPerson[new
		                Random().nextInt(data.descriptionPerson.length)];
		return des;
	}
	
	public String randomLink() {
		String link ;
		link = data.link[new Random().nextInt(data.link.length)];
		return link;
	}
	
	
	public String randomThoiGian(int i) {
		Calendar calendar = Calendar.getInstance();
		i = i%6500; //Thời gian trích rút trong vòng 18 năm (6500 ngày) trở lại so với thời gian hiện tại 
		calendar.add(Calendar.DATE, -i);
		String a =  calendar.getTime().toString();
		return a.substring(0,11)+" "+a.substring(24,28);
	}
	
	public String randomNhan() {
		String id;
		id = data.firstName[new Random().nextInt(data.firstName.length)]+" "+
			data.midName[new Random().nextInt(data.midName.length)]
			+" "+data.lastName[new Random().nextInt(data.lastName.length)];
		this.Tempid = id;
		return id;
	}
	
	public int randomAge() {
		
		return new Random().nextInt(90);
	}

	public String randomJob() {
		String job;
		job = data.job[new Random().nextInt(data.job.length)];
		return job;
	}

	public String randomQuocTich() {
		String qt;
		qt = data.quoctich[new Random().nextInt(data.quoctich.length)];
		return qt;
	}
	
	public void CreateNodePerson(int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		Person Person = new Person();
		
		try {
			System.out.println("Đang thêm node Person...");
			for(int i=0; i<num; i++) {	
				Person.setNhan(randomNhan());
				Person.setDinhdanh(randomDinhDanh(i));
				Person.setMota(randomMoTa());
				Person.setLink(randomLink());
				Person.setDate(randomThoiGian(i));
				Person.setAge(randomAge());
				Person.setJob(randomJob());
				Person.setQuoctich(randomQuocTich());

		Neo4j.connection.execute("CREATE ("+Person.getDinhdanh()+":Person { "
					+ "DinhDanh: '"+Person.getDinhdanh()+"', "
					+ "Nhan: '"+Person.getNhan()+"', "
					+ "Mota: '"+Person.getMota()+"', "
					+ "LinkTrichRut: '"+Person.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Person.getDate()+"', "
					+ "Age: '"+Person.getAge()+"', "
					+ "Job: '"+Person.getJob()+"', "
					+ "Quoctich: '"+Person.getQuoctich()+"'})");
//		System.out.println("Đã thêm "+Person.getDinhdanh()+"!");
		}	
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thêm Person: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

}
