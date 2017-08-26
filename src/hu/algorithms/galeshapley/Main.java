package hu.algorithms.galeshapley;

import java.util.*;

public class Main {

	private static ArrayList<Man> manList = new ArrayList<Man>();
	private static ArrayList<Woman> womanList = new ArrayList<Woman>();

	public static void main(String[] args) {
			
		System.out.println("Start");
		try {
	
			Man m1 = new Man(1, "Adam");
			Man m2 = new Man(2, "Bob");
			Man m3 = new Man(3, "Charlie");
			Man m4 = new Man(4, "Dan");
			
			Woman w1 = new Woman(5, "Amy");
			Woman w2 = new Woman(6, "Betty");
			Woman w3 = new Woman(7, "Chloe");
			Woman w4 = new Woman(8, "Diane");
			
			m1.setPreferenceList(Arrays.asList(w1, w2, w3, w4));
			m2.setPreferenceList(Arrays.asList(w1, w4, w3, w2));
			m3.setPreferenceList(Arrays.asList(w2, w1, w3, w4));
			m4.setPreferenceList(Arrays.asList(w2, w1, w3, w4));
			w1.setPreferenceList(Arrays.asList(m4, m3, m1, m2));
			w2.setPreferenceList(Arrays.asList(m2, m4, m1, m3));
			w3.setPreferenceList(Arrays.asList(m4, m1, m2, m3));
			w3.setPreferenceList(Arrays.asList(m3, m2, m1, m4));
			
			manList.add(m1);
			manList.add(m2);
			manList.add(m3);

			womanList.add(w1);
			womanList.add(w2);
			womanList.add(w3);	
			
			//Gale-Shapley algorithm starts here
			
			while (hasSingleWoman()) {
				for (Man man : manList) {
					if (man.isSingle())
						man.proposeBestSingle();
				}

				for (Woman woman : womanList) {
					if (woman.isSingle())
						woman.agreeBestProposal();
				}
				
			}
			System.out.println(w1.getName() +"'s pair = " + w1.getPair().getName());
			System.out.println(w2.getName() +"'s pair = " + w2.getPair().getName());
			System.out.println(w3.getName() +"'s pair = " + w3.getPair().getName());
			System.out.println(w4.getName() +"'s pair = " + w3.getPair().getName());

			
			
			System.out.println("Done");
		} catch (GenderMismatchException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static boolean hasSingleWoman()
	{
		for (Woman woman : womanList) {
			if (woman.isSingle())
				return true;
		}
		return false;
	}

}
