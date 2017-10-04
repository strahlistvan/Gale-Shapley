package hu.test.galeshapley;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hu.algorithms.galeshapley.GenderMismatchException;
import hu.algorithms.galeshapley.Person;
  
  
public class PersonTest {
	
	Person m1 = new Person();
	Person m2 = new Person();
	
	Person w1 = new Person();
	Person w2 = new Person();
	
	@Before
	public void setUp() throws Exception {
		m1.getPreferenceList().add(w1);
		m1.getPreferenceList().add(w2);
		
		w2.getPreferenceList().add(w2);
		w2.getPreferenceList().add(w1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		try {
			assertTrue("OK", m1.preferredFirstOverSecond(w1, w2));
			assertFalse("Not ok", m2.preferredFirstOverSecond(w1, w2));
			
		} catch (GenderMismatchException e) {
			e.printStackTrace();
		}
	}

}
