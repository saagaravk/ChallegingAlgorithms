package com.sagar.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Pangrams {

	private static Object DUMMY = new Object();
	Function<String,String> removeDup = a -> {
		
		Map<String, Object> map = new HashMap();
		Arrays.asList(a.split("")).stream().forEach(k -> map.put(k,DUMMY));
		
		return a;
	};
	static  String pangrams(String s) {
		Map<Integer, Object> map = new HashMap();
		char[] sArray = s!=null && s.length()>0?s.toUpperCase().toCharArray():null;
		if(sArray!=null && sArray.length>0){
			Arrays.sort(sArray);
			for (int i = 0; i < sArray.length; i++) {
				int c = sArray[i];
				if(c>=65 && c<=90){
					map.put(c, null);
				}
			}
		}
		if(map!=null && map.keySet()!=null && map.keySet().size()==26){
			return"pangram";
		}else{
			return"not pangram";
		}
	}
	
	public static void main(String[] args) {
		System.out.println(pangrams("The quick brown fox jumps over the lazy dog"));
	}
}
