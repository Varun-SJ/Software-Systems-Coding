package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapUtil {

	/*@
	  @ requires (map.keySet().size() == valueSet(map).size());
	  @ ensures \result == true || false;
	 */
	public static <K, V> boolean isOneOnOne(Map<K, V> map) {

		// TODO: implement, see exercise P-5.1
		return (map.keySet().size() == valueSet(map).size());
	}

	public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
		return (valueSet(map).size() <= map.keySet().size());
		// TODO: implement, see exercise P-5.2
	}

	public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
		Map<V, K> newMap = new HashMap<V, K>();
		Set<K> keys = map.keySet();
		for (K key : keys) {
			newMap.put(map.get(keys), key);
		}
		// TODO: implement, see exercise P-5.3
		return (Map<V, Set<K>>) newMap;
	}

	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		// TODO: implement, see exercise P-5.3
		Map<V, K> newMap = new HashMap<V, K>();
		for (Entry<K, V> entry : map.entrySet()) {
			newMap.put(entry.getValue(), entry.getKey());
		}
		return newMap;
	}

	/*@
	 @ ensures (\forall V value; f.values().contains(value); (\exists V key2;
	  g.keySet().contains(value); value.equals(value))) ==> \result == true || false;
	 */
	/* @ pure @ */
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
		boolean isCompatible = true;
		Set<V> keys2 = g.keySet();
		for (V value : f.values()) {
			if (!keys2.contains(value)) {
				isCompatible = false;
			}

		}
		return isCompatible;

		// TODO: implement, see exercise P-5.4
	}

	/*@
	  @ ensures (\forall K key; f.keySet().contains(key);
	  \result.get(key).equals(g.get(f.get(key))));
	 */

	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		if (!compatible(f, g)) {
			return null;
		}
		Map<K, W> newMap = new HashMap<K, W>();
		for (Entry<K, V> entry : f.entrySet()) {
			newMap.put(entry.getKey(), g.get(entry.getValue()));
		}
		// TODO: implement, see exercise P-5.5
		return newMap;
	}

	public static <K, V> Set<V> valueSet(Map<K, V> map) {
		Set<V> values = new HashSet<V>();
		for (V value : map.values()) {
			values.add(value);
		}
		return values;
	}
}
