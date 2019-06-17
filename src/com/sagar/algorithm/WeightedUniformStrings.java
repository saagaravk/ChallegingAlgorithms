package com.sagar.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class WeightedUniformStrings<E> {

	static Function<String, Integer> getWeight = k->{
		int val = k.chars().findAny().getAsInt()-96;
		return val!=0?k.length()*val:0;
	};
	
	static Function<List<String>,String[]> getStringArray = k->{
		String[] sArr = null;
		if(null!=k && !k.isEmpty()){
			sArr = new String[k.size()];
			for (int i=0;i<sArr.length;i++) {
				sArr[i]=k.get(i);
			}
		}
		return sArr;
	};
	
	static Predicate<String> isAlternate = s->{
		String[] split = s.split("");
		for (int i = 1; i < split.length; i++) {
			if(!split[0].equalsIgnoreCase(split[i])){
				return false;
			}
		}
		return true;
	};
	
	public static void main(String[] args) {
	/*	Map<String, Integer> map = new HashMap<>();*/
		String a="aaabbbbcccddd";
		int[] queries = {9,7,8,12,5};
		for(String s:weightedUniformStrings(a,queries)){
			System.out.println(s);
		}
	}
	
	static String[] weightedUniformStrings(String s, int[] queries) {
		Map<String, Integer> map = new HashMap<>();
		String a=s.toLowerCase();
		for (int i = 0; i < a.length(); i++) {
			String aSub = a.substring(0,i+1);
			if(isAlternate.test(aSub)){
				if(!map.containsKey(aSub)){
					map.put(aSub, getWeight.apply(aSub));
				}
			}else{
				a=a.substring(i,a.length());
				i=-1;
			}
		}
		Collection<Integer> values = map.values();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < queries.length; i++) {
			if(values.contains(queries[i])){
				list.add("Yes");
			}else{
				list.add("No");
			}
		}
		return getStringArray.apply(list);
    }
	
}
