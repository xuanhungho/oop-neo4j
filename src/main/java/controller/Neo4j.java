package controller;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;

import data.Connection;


public class Neo4j {
	
	public final Driver driver;
	
	public final static Neo4j connection = new Neo4j(Connection.host,Connection.username,Connection.password);
	
   
	public Neo4j( String uri, String user, String password ){
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }
    
    public void close() throws Exception{
        driver.close();
    }
	
    public void execute (String s) {
    	  try (Session session = driver.session()){
              try (Transaction tx = session.beginTransaction()){
                  tx.run(s);
                  tx.success();
              }
          }
    }
    
	public void removeData(){
		connection.execute("match (n) detach delete n");
	};
}