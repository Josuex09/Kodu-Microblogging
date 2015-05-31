package connection;

import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

public class OrientDBConnection {
	String dbUrl = "remote:localhost/test";
	String dbUser = "root";
	String dbPassword = "123";
    OObjectDatabaseTx db;
	
	public OrientDBConnection(){
	}
	
	public OObjectDatabaseTx getDB() {
		return db;
	}
	
	public OObjectDatabaseTx openConnection(){
		db = new OObjectDatabaseTx (dbUrl).open(dbUser,dbPassword);
		return db;
	}
	public void closeConnection(){
		db.close();
	}
}
