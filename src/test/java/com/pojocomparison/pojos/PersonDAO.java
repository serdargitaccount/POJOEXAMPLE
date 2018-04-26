package com.pojocomparison.pojos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
	
	List<Person> myTextPojoList = new ArrayList<>();
	List<Person> myDBPojoList = new ArrayList<>();
	
	public List<Person> myTextReader() { // List<Person>
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("B:\\myfile.txt"));
			// Virgul ve bezeri isaretlerle ayirilan elementleri ayirmak icin kullandigimiz
			// String.
			String data = br.readLine();
			String[] myValues = data.split(",");
			while (data != null) {
				Person person = new Person();
				person.setFirstName(myValues[0]);
				person.setLastName(myValues[1]);
				person.setAge(myValues[2]);
				person.setId(myValues[3]);
				myTextPojoList.add(person);
				br.readLine(); // bir sonraki line'i oku manasinda
			}
		} catch (Exception e) {
		}
		return myTextPojoList;
	}

	public List<Person> myDbReader() {
		Connection connection = null;
		Statement sqlStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection("", "", "");
			System.out.println("Connection successful...");
			sqlStatement = connection.createStatement();
			resultSet = sqlStatement.executeQuery("Select * from countries where rownum <3");
			while (resultSet.next()) {
				Person dbInstance = new Person();
				dbInstance.setFirstName(resultSet.getString("FirstName"));
				dbInstance.setLastName(resultSet.getString("LastName"));
				dbInstance.setAge(resultSet.getString("Age"));
				dbInstance.setId(resultSet.getString("Id"));

				myDBPojoList.add(dbInstance);
			}
		} catch (Exception e) {
		}
		return myDBPojoList;
	}
}
