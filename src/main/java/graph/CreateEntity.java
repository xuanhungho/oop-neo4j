package graph;

import java.util.Calendar;

import controller.Neo4j;
import controller.CreateCountry;
import controller.CreateEvent;
import controller.CreateLocation;
import controller.CreateOrganization;
import controller.CreatePerson;
import graph.CreateRelationships;
import controller.CreateTime;

public class CreateEntity {

	public CreateEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public void createEntitys(int personCount, int OrganizatuionCount, int locationCount, int eventCount, int countryCount, int timeCount ) {
		
		long begin = Calendar.getInstance().getTimeInMillis();
		System.out.println("Đang xoá các node cũ...");
		try {
			Neo4j.connection.removeData();
			} catch (Exception e) {
				System.out.println(e.getMessage());
		}
		System.out.println("Đang tạo node...");
		CreatePerson per = new CreatePerson();
		per.CreateNodePerson(personCount);
		
		CreateOrganization Org = new CreateOrganization();
		Org.CreateNodeOrganization(OrganizatuionCount);
		
		CreateLocation location = new CreateLocation();
		location.CreateNodeLocation(locationCount);
		
		CreateEvent event = new CreateEvent();
		event.CreateNodeEvent(eventCount);
		
		CreateCountry country = new CreateCountry();
		country.CreateNodeCountry(countryCount);
		
		CreateTime time = new CreateTime();
		time.CreateNodeTime(timeCount);
		
//		Tạo node Link bài viết và quan hệ tới các node sẵn có
		System.out.println("Đang tạo quan hệ...");
		CreateRelationships Rela = new CreateRelationships();
		Rela.CreateRelationship();
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Done: " + (end - begin)+" mili giây!");

	}
}
