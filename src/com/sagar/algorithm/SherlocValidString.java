package com.sagar.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SherlocValidString {

	public static void main(String[] args) {
		System.out.println(isValid("aaabbbcddd"));
		System.out.println(isValid("abcdefghhgfedcba"));
		System.out.println(isValid("aabbcd"));
		System.out.println(isValid("abcdefghhgfedecba"));
	}
	
	public static Predicate<Set<Integer>> keyDiff = k -> {
		Iterator<Integer> itr= k.iterator();
		Integer next = itr.next();
		Integer further = itr.next();
		int abs = Math.abs(further.compareTo(next));
		if(abs==1){
			return true;
		}
		return false;
	};
	
	static String isValid(String s) {
		Map<String, Integer> basicMap = new HashMap<>();
		for (String str : s.split("")) {
			if(basicMap.containsKey(str)){
				basicMap.put(str, basicMap.get(str)+1);
			}else{
				basicMap.put(str,1);
			}
		}

		Map<Integer,Set<String>> modifiedMap = new HashMap<>();
		for (String key : basicMap.keySet()) {
			if(modifiedMap.containsKey(basicMap.get(key))){
				modifiedMap.get(basicMap.get(key)).add(key);
				modifiedMap.put(basicMap.get(key),modifiedMap.get(basicMap.get(key)) );
			}else{
				HashSet<String> set = new HashSet<>();
				set.add(key);
				modifiedMap.put(basicMap.get(key), set);
			}
		}
		
		//aab -> 2-a,1-b
		//ababa -> 3-a, 2-b
		//abcdefghhgfedecba -> a-2;b-2;c-2;d-2;e-3;f-2;g-2;h-2 -> 2-abcdfgh;3-e
		if(null!=modifiedMap && !modifiedMap.isEmpty()){
			if(modifiedMap.size()==1){
				return "YES";
			}else if(modifiedMap.size()>2){
				return "NO";
			}else if(modifiedMap.size()==2 && keyDiff.test(modifiedMap.keySet())){
				return "YES";
			}
		}
		return "NO";
    }
}
