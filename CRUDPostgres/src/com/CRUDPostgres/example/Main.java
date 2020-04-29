package com.CRUDPostgres.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import com.CRUDPostgres.example.db.DbContract;
import com.CRUDPostgres.example.db.PostgresHelper;

public class Main {

	public static void main(String[] args) {
		
		PostgresHelper client = new PostgresHelper(DbContract.HOST,DbContract.DB_NAME,DbContract.USERNAME,DbContract.PASSWORD);
		
		try {
			if (client.connect()) {
				System.out.println("-------------- DB connected ----------------");
				
				//1. For inserting records in database (PostgresSQL)
				LinkedHashMap<String,Object> vals = new LinkedHashMap<String,Object>();
				vals.put("id", 3);
				vals.put("name", "uncharted 3");
				vals.put("type", "story");
				
				if (client.insert("games", vals) == 1) {
					System.out.println("-------------- Record added ----------------");
				}
				
				
				//2. For fetching records from database (PostgresSQL)
				/*ResultSet rs = client.fetchRecords("SELECT * FROM games");
				
				while(rs.next()) {
				    System.out.printf("%d\t%s\t%s\n",rs.getInt(1),rs.getString(2),rs.getString(3));
				}*/
				
				//3. For deleting records from database (PostgresSQL)
				/*int i = client.deleteRecords("DELETE FROM games	WHERE id=3");
				if(i == 1) {
					System.out.println("-------------- Record deleted ----------------");	
				}*/
				
				//4. For updating records in database (PostgresSQL)
				/*int i = client.updateRecords("UPDATE games SET name='Tomb raider' WHERE id=2");
				if(i == 1) {
					System.out.println("-------------- Record updated ----------------");	
				}*/
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}