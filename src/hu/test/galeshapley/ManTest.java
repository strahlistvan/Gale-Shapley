package hu.test.galeshapley;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import hu.algorithms.galeshapley.GenderMismatchException;
import hu.algorithms.galeshapley.Man;
import hu.algorithms.galeshapley.Person;
import hu.algorithms.galeshapley.Woman;

public class ManTest extends Person {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test(expected = GenderMismatchException.class)
	public void testMixedPreferenceListError() throws GenderMismatchException {
		Man m1 = new Man();
		LinkedList<Person> personList = new LinkedList<Person>();
		personList.add(new Woman());
		personList.add(new Man());
		personList.add(new Woman());
		
		m1.setPreferenceList(personList);
		
	}

	@Test(expected = GenderMismatchException.class)
	public void testPairGenderCheckerError() throws GenderMismatchException  {
		Man.pairGenderChecker(new Man());
	//	exception.expect(GenderMismatchException.class);
	}

	@Test
	public void testPairGenderCheckerValid() {
		try {
			Man.pairGenderChecker(new Woman());
		} catch (GenderMismatchException ex) {
			fail("testPairGenderCheckerValid failed");
			ex.printStackTrace();
		}
	}

}
