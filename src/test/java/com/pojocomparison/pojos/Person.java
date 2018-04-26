package com.pojocomparison.pojos;

import java.util.Comparator;

public class Person {

	private String firstName;
	private String lastName;
	private String age;
	private String id;

	public String getFirstName() {
		return firstName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", id=" + id + "]";
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public static void compareTo(Object o, Object p) {
	}

	public static Comparator<Person> myUniqueComparator = new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
			return p1.getId().compareTo(p2.getId());
		}
	};

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
