package assign1;

import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		// return 0; // TODO ADD CODE HERE
		if (a.size()==0 || b.size()==0){
			return 0;
		}
		
		HashMap<T, Integer> mapA = new HashMap<>();
		for (T ele: a){
			if (mapA.containsKey(ele)){
				mapA.put(ele, mapA.get(ele)+1);
			}
			else{
				mapA.put(ele, 1);
			}
		}
		HashMap<T, Integer> mapB = new HashMap<>();
		for (T ele: b){
			if (mapB.containsKey(ele)){
				mapB.put(ele, mapB.get(ele)+1);
			}
			else{
				mapB.put(ele, 1);
			}
		}
		int result = 0;
		for (T key: mapA.keySet()){
			if (mapB.containsKey(key) && mapA.get(key) == mapB.get(key)){
				result++;
			}
		}
		return result;
	}
	
}
