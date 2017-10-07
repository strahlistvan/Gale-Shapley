package hu.test.galeshapley;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import hu.algorithms.galeshapley.*;

public class WomanTest {
	
	Woman woman = new Woman(2, "Sandra Bullock");
	Set<Person> manSet = new HashSet<Person>();
	Set<Person> mixedSet = new HashSet<Person>();

	@Before
	public void setUp() {
		manSet.add(new Man(101, "Ted"));
		manSet.add(new Man(102, "Barney"));
		manSet.add(new Man(103, "Sheldon"));
		
		mixedSet.add(new Man(101, "Ted"));
		mixedSet.add(new Man(102, "Barney"));
		mixedSet.add(new Woman(203, "Penny"));
		}
	
	@Test(expected = GenderMismatchException.class)
	public void testPairGenderCheckerError() throws GenderMismatchException  {
		Woman.pairGenderChecker(new Woman(205, "Jane"));
	}
	
	@Test(expected = GenderMismatchException.class)
	public void tesPairGenderCheckerPerson() throws GenderMismatchException {
		Woman.pairGenderChecker(new Person(999, "Jesse"));
	}

	@Test
	public void testPairGenderCheckerValid() {
		try {
			Woman.pairGenderChecker(new Man(102, "Thomas"));
		} catch (GenderMismatchException ex) {
			fail("testPairGenderCheckerValid failed");
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testSetManProposals() {
		try {
			woman.setProporsals(manSet);
		} catch (GenderMismatchException ex) {
			fail("testSetManProposals failed");
			ex.printStackTrace();
		}
	}
	
	@Test(expected = GenderMismatchException.class)
	public void testSetMixedProporsals() throws GenderMismatchException {
			woman.setProporsals(mixedSet);
	}
	
	@Test
	public void clearProporsalsTest() {
		try {
			woman.setProporsals(manSet);
			
			Set<Person> oldProposals = woman.getProposals();

			woman.clearProporsals();
						
			assertEquals(0, woman.getProposals().size());
			
			for (Person p : oldProposals) {
				assertTrue(p.isSingle());
			}
			
		} catch (GenderMismatchException ex) {
			fail("clearProporsalsTest failed");
			ex.printStackTrace();
		}
	}

}
