package hu.algorithms.galeshapley;

import java.util.*;

public class Person {
	

	protected Integer id;
	protected String name;
	protected LinkedList<Person> preferenceList;
	protected Person pair;
	
	public Person() {
		this.preferenceList = new LinkedList<Person>();
	}

	public Person(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.preferenceList = new LinkedList<Person>();
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
	

	public LinkedList<Person> getPreferenceList() {
		return preferenceList;
	}
	
	public void setPreferenceList(LinkedList<Person> preferenceList) 
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
	
	public boolean preferredFirstOverSecond(Person first, Person second)
			throws GenderMismatchException {
		return (this.getPreferenceIndex(first) < this.getPreferenceIndex(second));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}	
	
	@Override
	public boolean equals(Object p) {
        boolean retVal = false;

        if (p instanceof Person){
            Person person = (Person) p;
            retVal = person.getId().equals(this.getId());            
        }
        return retVal;
	}
	
	@Override
	public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;		
	}
	
}
