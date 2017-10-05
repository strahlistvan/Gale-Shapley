package hu.algorithms.galeshapley;

import java.util.*;

public class Man extends Person {

	public Man() {
		super();
	}
	
	public Man(Integer id, String name) {
		super(id, name);
	}
	
	public static void pairGenderChecker(Person person) 
			throws GenderMismatchException {
		if (person == null)
			return;
		if (!(person instanceof Woman)) {
			System.err.println("#" + person.getId() + " " + person.getName()
				+ " is not a Woman!");
			throw new GenderMismatchException();
		}
	}
	
	public void setPair(Person woman) 
			throws GenderMismatchException {
		Man.pairGenderChecker(woman);
		super.setPair(woman);
	}
	
	public void setPreferenceList(LinkedList<Person> womanList) 
			throws GenderMismatchException {
		
		for(Person w: womanList) {
			Man.pairGenderChecker(w);
		}
		super.setPreferenceList(womanList);
	}
	
	public Integer getPreferenceIndex(Person man) 
			throws GenderMismatchException {
		Man.pairGenderChecker(man);
		return super.getPreferenceIndex(man);
	}
	
	public boolean preferredFirstOverSecond(Person first, Person second)
			throws GenderMismatchException {
		return super.preferredFirstOverSecond(first, second);
	}
	
/*	public void proposeBestSingle() {
		try {
			for (int i=0; i<this.preferenceList.size(); ++i) {
				Woman woman = (Woman) this.preferenceList.get(i);
				if (woman.isSingle()) {
					woman.addProposal(this);
					return;
				}
			}
		} catch (GenderMismatchException ex) {
			ex.printStackTrace();
		}
	}
*/	
	public void proposeNextWoman() {
		try {
			if (this.preferenceList == null || this.preferenceList.size() == 0) {
				 return;
			}
			Woman woman = (Woman) this.preferenceList.get(0);
			woman.addProposal(this);
			this.preferenceList.removeFirst();
		} catch (GenderMismatchException ex) {
			ex.printStackTrace();
		}
	}
	
}
