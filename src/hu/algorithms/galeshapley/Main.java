package hu.algorithms.galeshapley;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Man m1 = new Man(1, "Joe");
		Man m2 = new Man(2, "Jack");
		Woman w1 = new Woman(3, "Rose");
		Woman w2 = new Woman(4, "Jane");
		
		System.out.println("Start");
		try {
			m1.setPreferenceList(Arrays.asList(w1, w2));
			m2.setPreferenceList(Arrays.asList(w2, w1));
			w1.setPreferenceList(Arrays.asList(m1, m2));
			w2.setPreferenceList(Arrays.asList(m2, m1));
			
			m1.setPair(w1);
			System.out.println("Done");
		} catch (GenderMismatchException ex) {
			ex.printStackTrace();
		}
		
	}

}
