package com.pojocomparison.pojos;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Test;


public class TestClass {
	PersonDAO dao=new PersonDAO();
	
	@Test
	public void Test1() {
		

		List<Person> myPersonList=dao.myTextReader();
		List<Person> myDbList=dao.myDbReader();
		
		
		Collections.sort(myPersonList, Person.myUniqueComparator);
		Collections.sort(myDbList, Person.myUniqueComparator);
		
		assertEquals(myPersonList.toString(), myDbList.toString()); // Toplu olarak butun bilgiyi String formatinda karsilastirma.
		
		
//		for (int i = 0; i < dao.myTextPojoList.size(); i++) {
//			for (int j = 0; j < dao.myDBPojoList.size(); j++) {
//				if(dao.myTextPojoList.get(i).getId().equals(dao.myDBPojoList.get(j).getId()))
//				assertEquals(myPersonList.get(i).toString(), myDbList.get(j).toString());// Bire bir karsilastirma.
//				
//			}
//		}
		
		
	}
	
}
