/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/
package assign1;

import java.util.*;

public class Taboo<T> {
	HashMap<T, Set<T> > map = new HashMap<>();
	
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		T prev = null;
		for (T now: rules){
			if (prev!=null && now!=null){
				if (! map.containsKey(prev)){
					map.put(prev, new HashSet<T>() );
				}
				map.get(prev).add(now);
			}
			prev = now;
		}
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		 // return null; // TODO YOUR CODE HERE
		if (map.containsKey(elem)){
			return map.get(elem);
		}
		else{
			return Collections.emptySet();
		}		
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		T prev = null;
		for (Iterator<T> iter = list.listIterator(); iter.hasNext(); ) {
		    T now = iter.next();
//		    System.out.println(now);
		    if (prev!=null && now!=null && map.containsKey(prev) && map.get(prev).contains(now)) {
		        iter.remove();
		    }
		    else{
		    	prev = now;
		    }
		}
		
	}
}
