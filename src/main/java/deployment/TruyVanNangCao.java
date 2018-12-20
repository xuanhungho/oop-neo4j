package deployment;

import static org.neo4j.driver.v1.Values.parameters;

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import controller.Neo4j;

public class TruyVanNangCao {

	public void findPerson(String Ho) {
    	String q = "MATCH (e:Person) WHERE e.Nhan CONTAINS {Ho} OR e.Age CONTAINS {Ho} OR e.Quoctich CONTAINS {Ho} OR e.Mota CONTAINS {Ho} "
    			+ "RETURN e.Nhan AS Nhan, e.Age AS Age, e.Mota AS Mota, e.Job AS Job, e.Quoctich AS qt";
    	System.out.println("Người có thông tin trên là: "+Ho+":");
    	 try (Session session = Neo4j.connection.driver.session()){
             StatementResult result = session.run(q,parameters("Ho", Ho));
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("-----");
                 System.out.println("Tên: "+record.get("Nhan").asString());
                 System.out.println("Tuổi: "+record.get("Age").asString());
                 System.out.println("Nghề nghiệp: "+record.get("Job").asString());
                 System.out.println("SĐT: "+record.get("Mota").asString());
                 System.out.println("Quốc tịch: "+record.get("qt").asString());
             }
         }
    }

	public void finePerson_Country(String ten) {
		String q = "MATCH (per:Person)-[:DEN_THAM]->(country:Location)-[:DEN_THAM_VAO]->(time:Time) WHERE per.Nhan = {ten} "
				+ " WITH DISTINCT country, time RETURN country.Nhan AS locaNhan, time.Nhan AS timeNhan";
		System.out.println("Những địa điểm "+ten+" đã đến thăm là:");
   	 try (Session session = Neo4j.connection.driver.session()){
            StatementResult result = session.run(q,parameters("ten", ten));
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println("Địa điểm: "+record.get("locaNhan").asString()+" - Thời gian: "+record.get("timeNhan").asString());
                
            }
        }
	}

	public void fine_LOCATION_11_2018(String ten) {
		String q = "MATCH (per:Person)-[:DEN_THAM]->(loca:Location)-[:DEN_THAM_VAO]->(time:Time) WHERE per.Nhan = {ten}"
				+ " AND time.Nhan CONTAINS 'Nov' "
				+ " AND time.Nhan ENDS WITH '2018' "
				+ " WITH DISTINCT loca, time RETURN loca.Nhan AS locaNhan, time.Nhan AS timeNhan ";
		System.out.println(" ");
		System.out.println("Những nơi "+ten+" đến thăm vào tháng 11/2018 là:");
   	 try (Session session = Neo4j.connection.driver.session()){
            StatementResult result = session.run(q,parameters("ten", ten));
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println(record.get("locaNhan").asString()+" - Thời gian: "+record.get("timeNhan").asString());
                
            }
        }
	}
	
	public void fine_EVENT_10_2018(String location) {
		String q = "MATCH (event:Event)-[:DIEN_RA_TAI]->(loca:Location), (event:Event)-[:DIEN_RA_VAO]->(time:Time) WHERE loca.Nhan = {location}"
				+ " AND time.Nhan CONTAINS 'Oct' "
				+ " AND time.Nhan ENDS WITH '2018' "
				+ " WITH DISTINCT event, time RETURN event.Nhan AS locaNhan, time.Nhan AS timeNhan ";
		System.out.println(" ");
		System.out.println("Những sự kiện diễn ra tại "+location+" vào tháng 10/2018 là:");
   	 try (Session session = Neo4j.connection.driver.session()){
            StatementResult result = session.run(q,parameters("location", location));
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println(record.get("locaNhan").asString()+" - Thời gian: "+record.get("timeNhan").asString());
                
            }
        }
	}
	public void findThucthe(String link) {
    	System.out.println("Những thực thể đề cập đến bài viết trong "+link+" là:");
    	
    	String q = "MATCH (per:Person) WHERE per.LinkTrichRut = {link}\n" + 
    			"MATCH (Org:Organization) WHERE Org.LinkTrichRut = {link}\n" + 
    			"MATCH (loca:Location) WHERE loca.LinkTrichRut = {link}\n" + 
    			"MATCH (event:Event) WHERE event.LinkTrichRut = {link}\n" + 
    			"MATCH (country:Country) WHERE country.LinkTrichRut = {link}\n" + 
    			"MATCH (time:Time) WHERE time.LinkTrichRut = {link}\n" + 
    			"WITH DISTINCT per, Org, loca, event,country, time \n" + 
    			"RETURN per.Nhan AS perNhan, Org.Nhan AS OrgNhan, loca.Nhan AS locaNhan,\n" + 
    			"event.Nhan AS eventNhan, country.Nhan AS countryNhan, time.Nhan AS timeNhan LIMIT 10\n";

    	 try (Session session = Neo4j.connection.driver.session()){
             StatementResult result = session.run(q,parameters("link", link));
             while (result.hasNext()){
                 Record record = result.next();
                 if(record.get("perNhan").asString() != "null") System.out.println("Person: "+record.get("perNhan").asString());
                 if(record.get("OrgNhan").asString() != "null") System.out.println("Organization: "+record.get("OrgNhan").asString());
                 if(record.get("locaNhan").asString() != "null") System.out.println("location: "+record.get("locaNhan").asString());
                 if(record.get("eventNhan").asString() != "null") System.out.println("Event: "+record.get("eventNhan").asString());
                 if(record.get("countryNhan").asString() != "null") System.out.println("Country: "+record.get("countryNhan").asString());
                 if(record.get("timeNhan").asString() != "null") System.out.println("Time: "+record.get("timeNhan").asString());
                 System.out.println("----");}
         }
    }

	public void findCloseCustomer(String event) {
		String q = "MATCH (org:Organization)-[:TO_CHUC]->(event:Event), "
				+ "(per:Person)-[:DEN_THAM]->(loca:Location)-[:DEN_THAM_VAO]->(time:Time) WHERE "
				+ " event.Nhan = {event} AND org.TruSo = loca.Nhan "
				+ " WITH DISTINCT per, org, time RETURN per.Nhan AS perNhan, org.TruSo AS truso,"
				+ " org.Nhan AS orgNhan, time.Nhan AS time";
		System.out.println(" ");
		System.out.println("Truy vấn 6: ");
   	 try (Session session = Neo4j.connection.driver.session()){
            StatementResult result = session.run(q,parameters("event", event));
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println(record.get("perNhan").asString()+" đến thăm trụ sở của "
                +record.get("orgNhan").asString()+" tại "+record.get("truso").asString()
                +" vào "+record.get("time").asString());
                
            }
        }
	}

	public void findEventNov2018(String org) {
		String q = "MATCH (org:Organization)-[:TO_CHUC]->(event:Event)-[:DIEN_RA_VAO]->(time:Time) "
				+ " WHERE org.Nhan = {org} "
				+ " AND time.Nhan CONTAINS 'Nov' "
				+ " AND time.Nhan ENDS WITH '2018' "
				+ " WITH DISTINCT event, time RETURN event.Nhan AS eventNhan, time.Nhan AS timeNhan ";
		System.out.println(" ");
		System.out.println("Những sự kiện "+org+" tổ chức vào tháng 9/2018 là:");
   	 try (Session session = Neo4j.connection.driver.session()){
            StatementResult result = session.run(q,parameters("org", org));
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println(record.get("eventNhan").asString()+" - Thời gian: "+record.get("timeNhan").asString());
                
            }
        }
	}

	public void findWhoGoTo(String cou) {
		String q = "MATCH (per:Person)-[:DEN_THAM]->(loca:Location)-[:DEN_THAM_VAO]->(time:Time), (loca:Location)-[:THUOC]->(country:Country) "
				+ " WHERE country.Nhan = {cou} AND per.Quoctich <> country.Nhan"
				+ " AND time.Nhan CONTAINS 'Nov' "
				+ " AND time.Nhan ENDS WITH '2018' "
				+ " WITH DISTINCT per, loca, time RETURN per.Nhan AS perNhan, time.Nhan AS timeNhan, loca.Nhan AS locaNhan ";
		System.out.println(" ");
		System.out.println("Những người nước ngoài đến "+cou+" vào tháng 9/2018 là:");
   	 try (Session session = Neo4j.connection.driver.session()){
            StatementResult result = session.run(q,parameters("cou", cou));
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println(record.get("perNhan").asString()+" đến thăm "+record.get("locaNhan").asString()+" vào "+record.get("timeNhan").asString());
                
            }
        }
	}
	
}