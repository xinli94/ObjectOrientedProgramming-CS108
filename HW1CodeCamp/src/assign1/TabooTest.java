// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TabooTest {

	// TODO ADD TESTS
	@Test
	public void testTaboo1(){
		Taboo<Character> a = new Taboo<>(Arrays.asList('a','a','c','a','b'));
		Set<Character> b = new HashSet<>(Arrays.asList('a','b','c'));
		assertEquals(b, a.noFollow('a'));
		
		List<Character> c = new ArrayList<>(Arrays.asList('a','a','c','b','x','c','a'));
		List<Character> d = new ArrayList<>(Arrays.asList('a','x','c'));
		a.reduce(c);
		assertEquals(c,d);
	}
	
	@Test
	public void testTaboo2(){
		Taboo<Character> a = new Taboo<>(Arrays.asList('a','c','a',null,'a','b'));
		Set<Character> b = new HashSet<>(Arrays.asList('b','c'));
		assertEquals(b, a.noFollow('a'));
		
		List<Character> c = new ArrayList<>(Arrays.asList('a','c','b','x','c','a'));
		List<Character> d = new ArrayList<>(Arrays.asList('a','x','c'));
		a.reduce(c);
		assertEquals(c,d);
	}
}
