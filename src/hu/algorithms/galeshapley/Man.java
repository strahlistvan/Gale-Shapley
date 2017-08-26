package hu.algorithms.galeshapley;

import java.util.List;

public class Man extends Person {

	public Man() {
		super();
	}
	
	public Man(Integer id, String name) {
		super(id, name);
	}
	
	public static void pairGenderChecker(Person person) 
			throws GenderMismatchException {
		if (!(person instanceof Woman)) {
			System.err.println("#" + person.getId() + " " + person.getName()
				+ " is not a Woman!");
			throw new GenderMismatchException();
		}
	}
	
	public void setPair(Person woman) 
			throws GenderMismatchException {
		Man.pairGenderChecker(woman);
	//	System.out.println(this.getName() + " pair is " + woman.getName());
		super.setPair(woman);
	}
	
	public void setPreferenceList(List<Person> womanList) 
			throws GenderMismatchException {
		
		for(Person w: womanList) {
			Man.pairGenderChecker(w);
		}
		super.setPreferenceList(womanList);
	}
	
	public Integer getPreferenceIndex(Man man) 
			throws GenderMismatchException {
		Man.pairGenderChecker(man);
		return super.getPreferenceIndex(man);
	}
	
	public boolean preferredFirstOverSecond(Man firstMan, Man secondMan)
			throws GenderMismatchException {
		return super.preferredFirstOverSecond(firstMan, secondMan);
	}
	
	public void proposeBestSingle() {
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
}
