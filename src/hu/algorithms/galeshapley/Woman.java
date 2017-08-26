package hu.algorithms.galeshapley;

import java.util.List;

public class Woman extends Person {
	public Woman() {
		super();
	}
	
	public Woman(Integer id, String name) {
		super(id, name);
	}
	
	public static void pairGenderChecker(Person person) 
			throws GenderMismatchException {
		if (!(person instanceof Man)) {
			System.err.println("#" + person.getId() + " " + person.getName()
				+ " is not a Man!");
			throw new GenderMismatchException();
		}
	}
	
	public void setPair(Person man) 
			throws GenderMismatchException {
		
		Woman.pairGenderChecker(man);
		System.out.println(this.getName() + " pair is " + man.getName());
		super.setPair(man);
	}
	
	public void setPreferenceList(List<Person> womanList) 
			throws GenderMismatchException {
		
		for(Person w: womanList) {
			Woman.pairGenderChecker(w);
		}
		super.setPreferenceList(womanList);
	}
	
	public Integer getPreferenceIndex(Man man) 
			throws GenderMismatchException {
		Woman.pairGenderChecker(man);
		return super.getPreferenceIndex(man);
	}
	
	public boolean preferredFirstOverSecond(Man firstMan, Man secondMan)
			throws GenderMismatchException {
		return super.preferredFirstOverSecond(firstMan, secondMan);
	}
}
