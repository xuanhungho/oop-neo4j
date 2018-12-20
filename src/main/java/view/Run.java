package view;

import java.util.Calendar; 

import controller.Neo4j;
import controller.CreateCountry;
import controller.CreateEvent;
import controller.CreateLocation;
import controller.CreateOrganization;
import controller.CreatePerson;
import graph.CreateRelationships;
import controller.CreateTime;
import deployment.TruyVanCoBan;
import deployment.TruyVanNangCao;
import graph.CreateEntity;

public class Run {
	public static int num = 1000;
	
	public static void main(String[] args) {
		
		long begin = Calendar.getInstance().getTimeInMillis();
		
// ==========================================================
				
		// Xoá hết các node hiện có
		
//		System.out.println("Đang xoá các node cũ...");		
//		try {
//			Neo4j.connection.removeData();
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//		}
	
		
// ==========================================================
				
		// Tạo các Node
		
//		System.out.println("Đang tạo node...");
//		
//		CreatePerson per = new CreatePerson();
//		per.CreateNodePerson(num);
//		
//		CreateOrganization Org = new CreateOrganization();
//		Org.CreateNodeOrganization(num);
//		
//		CreateLocation location = new CreateLocation();
//		location.CreateNodeLocation(num);
//		
//		CreateEvent event = new CreateEvent();
//		event.CreateNodeEvent(num);
//		
//		CreateCountry country = new CreateCountry();
//		country.CreateNodeCountry(num);
//		
//		CreateTime time = new CreateTime();
//		time.CreateNodeTime(num);
//
//		System.out.println("Đang tạo quan hệ...");
//		CreateRelationships Rela = new CreateRelationships();
//		Rela.CreateRelationship();
		
		
// ==========================================================
		
		//Tạo các node và quan hệ qua 1 hàm:
		
//		CreateEntity en =new CreateEntity();
//		en.createEntitys(50,50,50,50,50,50);
		
		
// ==========================================================
			
		
		 		
		// -------------- 10 truy vấn cơ bản ---------------
		TruyVanCoBan query1 = new TruyVanCoBan();

		//1. In ra ten cua tat ca nhung nguoi co tuoi 65
//		long begin_query1 = Calendar.getInstance().getTimeInMillis();
//		query1.findPerson(76);
//		long end_query1 = Calendar.getInstance().getTimeInMillis();
//		System.out.println("Truy vấn cơ bản 1: "+ -(begin_query1 - end_query1)+" mili giây!");	
		/*	
		//2. In ra Thông tin cua tat ca nhung nguoi có quốc tịch Lao
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.findPerson("Lao");
		end_query1 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn cơ bản 2: "+ -(begin_query1 - end_query1)+" mili giây!");	
		
		//3. In ra thông tin của tat ca nhung nguoi ten chua tu "Hung"
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.findAllPerson("Hung");
		end_query1 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn cơ bản 3: "+ -(begin_query1 - end_query1)+" mili giây!");	
		
		
		//4. In ra tên của tất cả Person
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.findPerson();
		end_query1 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn cơ bản 4: "+ -(begin_query1 - end_query1)+" mili giây!");	
		
		//5. In ra nhãn của 1 thực thể tùy chọn 
		//Nhập Person, Organization, Event, Location, Country, Time hoặc 1,2,3,4,5,6 để xác định đối 
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.find("Person");
		end_query1 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn cơ bản 5: "+ -(begin_query1 - end_query1)+" mili giây!");	
		
		//6. In ra những link bài viết có viết về Organization nhập vào:
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.findLink("Apple");
		end_query1 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn cơ bản 6: "+ -(begin_query1 - end_query1)+" mili giây!");	
		
		//7. In ra nhãn của những thực thể Person có đề cập trong Link nhập vào:
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.findThucthePerson("https://search.maven.org/artifact/org.neo4j/neo4j-kernel/3.5.0/jar");
		end_query1 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn cơ bản 7: "+ -(begin_query1 - end_query1)+" mili giây!");	
		
		//8. In địa điểm và thời gian tổ chức event:
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.findDiaDiem("Ca múa nhạc tạp kỹ");
		end_query1 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn cơ bản 8: "+ -(begin_query1 - end_query1)+" mili giây!");	

		//9. In các location có trong 1 country:
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.seachLocation("Viet Nam");
		end_query1 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn cơ bản 9: "+ -(begin_query1 - end_query1)+" mili giây!");	

		//10. In ra 20 Person, location, time có trong quan hệ Person đến thăm Lociton vào Time:
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.seach_DEN_THAM();
		end_query1 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn cơ bản 10: "+ -(begin_query1 - end_query1)+" mili giây!");					
		
		*/
		
// ==========================================================
		
		
		// --------------- 10 truy vấn nâng cao ---------------
		TruyVanNangCao query2 = new TruyVanNangCao();
		
		//1. Nhập vào một String bất kì in ra tất cả thông tin của 1 người có liên quan đến String đấy 
		long begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.findPerson("Hung");
		long end_query2 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn nâng cao 1: "+ -(begin_query2 - end_query2)+" mili giây!");	
		/*
		// 2. Nhập vào 1 người xác định in ra thời gian và nước mà người ấy đến thăm
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.finePerson_Country(Hà Xuân Việt");
		end_query2 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn nâng cao 2: "+ -(begin_query2 - end_query2)+" mili giây!");	
		
		// 3. Nhập vào 1 người xác định in ra những địa điểm và thời gian người đó đến thăm vào Tháng 11/2018
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.fine_LOCATION_11_2018("Ho Van Duong");
		end_query2 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn nâng cao 3: "+ -(begin_query2 - end_query2)+" mili giây!");	
		
		// 4. Nhập vào 1 địa điểm in ra tên của những sự kiện và thời gian diễn ra tại đó vào tháng 10/2018
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.fine_EVENT_10_2018("Hồ Gươm");
		end_query2 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn nâng cao 4: "+ -(begin_query2 - end_query2)+" mili giây!");	
		
		//5. In ra nhãn của 10 thực thể có đề cập trong Link nhập vào:
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.findThucthe("https://search.maven.org/artifact/org.neo4j/neo4j-kernel/3.5.0/jar");
		end_query2 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn nâng cao 5: "+ -(begin_query2 - end_query2)+" mili giây!");	
		
		 
		//6. In ra những người và thời gian đến thăm trụ sở của các Organization đã tổ chức 1 sự kiện cụ thể
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.findCloseCustomer("Lễ hội mùa xuân");
		end_query2 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn nâng cao 6: "+ -(begin_query2 - end_query2)+" mili giây!");	
		
		
		//7. In Organization đã tổ chức những sự kiện nào vào tháng 9/2018
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.findEventNov2018("Grab");
		end_query2 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn nâng cao 7: "+ -(begin_query2 - end_query2)+" mili giây!");	
		
		
		//8. In ra những người nước ngoài nào đã đến thăm các location thuộc country nhập vào trong tháng 9/2018
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.findWhoGoTo("Anh");
		end_query2 = Calendar.getInstance().getTimeInMillis();
		System.out.println("Truy vấn nâng cao 8: "+ -(begin_query2 - end_query2)+" mili giây!");	
				
		*/
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("");
		System.out.println("Tổng Thời gian thực hiện: " + (end - begin)+" mili giây!");	
		try {
			Neo4j.connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
