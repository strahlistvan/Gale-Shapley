package hu.algorithms.galeshapley;

import java.util.*;

public class Woman extends Person {
	
	private Set<Man> proposals = new HashSet<Man>();
	
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
	//	System.out.println(this.getName() + " pair is " + man.getName());
		super.setPair(man);
	}
	
	public void setPreferenceList(List<Person> womanList) 
			throws GenderMismatchException {
		
		for(Person w: womanList) {
			Woman.pairGenderChecker(w);
		}
		super.setPreferenceList(womanList);
	}
	
	public Set<Man> getProposals() {
		return proposals;
	}
	
	public void addProposal(Person man) 
			throws GenderMismatchException {
		Woman.pairGenderChecker(man);
		
		this.proposals.add((Man) man);
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
	
	public void agreeBestProposal() {
		try {
			for (int i=0; i<this.preferenceList.size(); ++i) {
				Man man = (Man) this.preferenceList.get(i);
				if (this.proposals.contains(man)) {
					this.setPair(man);
					man.setPair(this);
					this.proposals.clear();
					return;
				}
			}
			this.proposals.clear();
		} catch (GenderMismatchException ex) {
			ex.printStackTrace();
		}
	}
}
