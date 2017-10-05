package hu.test.galeshapley;

import static org.junit.Assert.fail;

import org.junit.Test;

import hu.algorithms.galeshapley.GenderMismatchException;
import hu.algorithms.galeshapley.Man;
import hu.algorithms.galeshapley.Person;
import hu.algorithms.galeshapley.Woman;

public class WomanTest {
	
	@Test(expected = GenderMismatchException.class)
	public void testPairGenderCheckerError() throws GenderMismatchException  {
		Woman.pairGenderChecker(new Woman());
	}
	
	@Test(expected = GenderMismatchException.class)
	public void tesPairGenderCheckerPerson() throws GenderMismatchException {
		Woman.pairGenderChecker(new Person());
	}

	@Test
	public void testPairGenderCheckerValid() {
		try {
			Woman.pairGenderChecker(new Man());
		} catch (GenderMismatchException ex) {
			fail("testPairGenderCheckerValid failed");
			ex.printStackTrace();
		}
	}

}
