package graph;

import controller.Neo4j;

public class CreateRelationships {

	public CreateRelationships() {
	}
	
	public void CreateRelationship() {
		try {		
			Neo4j.connection.execute("MATCH (per:Person),(event:Event) WHERE per.Nhan <> event.DaiDien " + 
					"AND per.LinkTrichRut = event.LinkTrichRut AND per.Age>'50' "
					+ " WITH DISTINCT per, event CREATE (per)-[:THAM_GIA]->(event)");
			
			Neo4j.connection.execute("MATCH (org:Organization),(event:Event) WHERE org.LinkTrichRut = event.LinkTrichRut"
					+ " AND org.TruSo = event.DiaDiem WITH DISTINCT org, event CREATE (org)-[:TO_CHUC]->(event)");
			
			Neo4j.connection.execute("MATCH (per:Person),(event:Event) WHERE per.Nhan = event.DaiDien " + 
					"AND per.LinkTrichRut = event.LinkTrichRut CREATE (per)-[:DAI_DIEN]->(event)");
			
			Neo4j.connection.execute("MATCH (per:Person),(country:Country) WHERE per.Quoctich = country.Nhan\r\n" + 
					"AND per.LinkTrichRut = country.LinkTrichRut WITH DISTINCT per, country CREATE (per)-[:QUOC_TICH]->(country)");
			
			Neo4j.connection.execute("MATCH (per:Person),(loca:Location),(time:Time) WHERE per.Quoctich <> loca.Nhan\r\n" + 
					"AND per.LinkTrichRut = loca.LinkTrichRut  "
					+ "AND time.LinkTrichRut = loca.LinkTrichRut AND per.Age>'60' "
					+ " AND per.LinkTrichRut = time.LinkTrichRut WITH DISTINCT per, loca "
					+ "CREATE (per)-[:DEN_THAM]->(loca)");
			
			Neo4j.connection.execute("MATCH (per:Person)-[:DEN_THAM]->(loca:Location),(time:Time) WHERE per.Quoctich <> loca.Nhan\r\n" + 
					"AND per.LinkTrichRut = loca.LinkTrichRut "
					+ "AND time.LinkTrichRut = loca.LinkTrichRut AND per.Age>'60'"
					+ " AND per.LinkTrichRut = time.LinkTrichRut WITH DISTINCT loca,time "
					+ "CREATE (loca)-[:DEN_THAM_VAO]->(time)");
		
			Neo4j.connection.execute("MATCH (event:Event),(loca:Location) WHERE event.DiaDiem = loca.Nhan\r\n" + 
					"AND event.LinkTrichRut = loca.LinkTrichRut "
					+ " WITH DISTINCT event, loca CREATE (event)-[:DIEN_RA_TAI]->(loca)");
			
			Neo4j.connection.execute("MATCH (event:Event),(time:Time) WHERE " + 
					"  event.ThoiGianToChuc = time.Nhan"
					+ " WITH DISTINCT event, time CREATE (event)-[:DIEN_RA_VAO]->(time)");
					
			Neo4j.connection.execute("MATCH (org:Organization),(loca:Location) WHERE org.TruSo = loca.Nhan\r\n" + 
					"AND org.LinkTrichRut = loca.LinkTrichRut WITH DISTINCT org, loca CREATE UNIQUE (org)-[:TRU_SO]->(loca)");
			
			Neo4j.connection.execute("MATCH (loca:Location),(country:Country) WHERE loca.QuocGia = country.Nhan\r\n" + 
					"AND loca.LinkTrichRut = country.LinkTrichRut WITH DISTINCT loca, country CREATE (loca)-[:THUOC]->(country)");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
		}
	}
}
