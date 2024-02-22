package test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author vz Create a timebased key-value store class TimeMap, that supports
 *         two operations.
 */
class BiSearch {
	private Map<String, Map<Integer, Pair>> timeMap;

	private static class Pair {
		String key, value;

		public Pair(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

	}

	/** Initialize your data structure here. */
	public BiSearch() {
		timeMap = new HashMap<String, Map<Integer, Pair>>();
	}

	/*
	 * 1. set(string key, string value, int timestamp)
	 * 
	 * Stores the key and value, along with the given timestamp.
	 */
	public void set(String key, String value, int timestamp) {
		Map<Integer, BiSearch.Pair> map = timeMap.get(key);
		if (map == null) {
			map = new TreeMap<Integer, BiSearch.Pair>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {

					return -o1.compareTo(o2);
				}
			});
			timeMap.put(key, map);
		}
		map.put(timestamp, new Pair(key, value));
	}

	/*
	 * Returns a value such that set(key, value, timestamp_prev) was called
	 * previously, with timestamp_prev <= timestamp. If there are multiple such
	 * values, it returns the one with the largest timestamp_prev. If there are no
	 * values, it returns the empty string ("").
	 */
	public String get(String key, int timestamp) {
		Map<Integer, BiSearch.Pair> map = timeMap.get(key);
		if (map != null) {
			return getLargestTimestampPrevious(map, timestamp);
		}
		return "";
	}

	private String getLargestTimestampPrevious(Map<Integer, Pair> map, int timestamp) {
		for (Integer key : map.keySet()) {
			if (key <= timestamp) {
				return map.get(key).value;
			}
		}
		return "";
	}
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */