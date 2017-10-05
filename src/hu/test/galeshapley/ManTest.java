package hu.test.galeshapley;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Test;
import hu.algorithms.galeshapley.*;

public class ManTest extends Person {

	Man man = new Man(1, "Chuck Norris");
	LinkedList<Person> womanList = new LinkedList<Person>();
	LinkedList<Person> mixedList = new LinkedList<Person>();

	
	public ManTest() {
		womanList.add(new Woman(200, "Anne"));
		womanList.add(new Woman(201, "Bella"));
		womanList.add(new Woman(202, "Zynthia"));
		
		mixedList.add(new Woman(210, "Anne"));
		mixedList.add(new Man(101, "Bela"));
		mixedList.add(new Woman(220, "Zynthia"));	}
	
	@Test(expected = GenderMismatchException.class)
	public void testMixedPreferenceListError() throws GenderMismatchException {
		man.setPreferenceList(mixedList);
	}
	
	@Test
	public void testWomanPreferenceIsValid() {

		try {
			man.setPreferenceList(womanList);	
		} catch (GenderMismatchException ex) {
			fail("testWomanPreferenceIsValid failed");
			ex.printStackTrace();
		}
	}

	@Test(expected = GenderMismatchException.class)
	public void testPairGenderCheckerError() throws GenderMismatchException  {
		Man.pairGenderChecker(new Man());
	}

	@Test
	public void testPairGenderCheckerValid() {
		try {
			Man.pairGenderChecker(new Woman(205, "Jane"));
		} catch (GenderMismatchException ex) {
			fail("testPairGenderCheckerValid failed");
			ex.printStackTrace();
		}
	}
	
	@Test(expected = GenderMismatchException.class)
	public void tesPairGenderCheckerUnisexPerson() throws GenderMismatchException {
		Man.pairGenderChecker(new Person());
	}
	
	@Test 
	public void proposeNextWomanTest() {
		try {
		
		man.proposeNextWoman();
		man.proposeNextWoman();
		man.proposeNextWoman();
		man.proposeNextWoman();
		
		assertEquals(man.getPreferenceList().size(), 0);
		} catch (IndexOutOfBoundsException ex) {
			ex.printStackTrace();
			fail("Index out of bounds in preference list");
			
		}
	}

}
