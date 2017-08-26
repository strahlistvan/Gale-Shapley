package hu.algorithms.galeshapley;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	protected Integer id;
	protected String name;
	protected List<Person> preferenceList;
	protected Person pair;
	
	public Person() {
		this.preferenceList = new ArrayList<Person>();
	}

	public Person(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.preferenceList = new ArrayList<Person>();
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

	public List<Person> getPreferenceList() {
		return preferenceList;
	}
	
	public void setPreferenceList(List<Person> preferenceList) 
			throws GenderMismatchException {
		this.preferenceList = preferenceList;
	}
	
	public Person getPair() {
		return pair;
	}
	
	public void setPair(Person pair) 
			throws GenderMismatchException {
		this.pair = pair;
	}
	
	public boolean isSingle() {
		return (this.getPair() == null);
	}
	
	public Integer getPreferenceIndex(Person person) 
			throws GenderMismatchException {
		return this.preferenceList.indexOf(person);
	}
	
	public boolean preferredFirstOverSecond(Man firstMan, Man secondMan)
			throws GenderMismatchException {
		return (this.getPreferenceIndex(firstMan) < this.getPreferenceIndex(secondMan));
	}
	
}
