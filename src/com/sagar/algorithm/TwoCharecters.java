package com.sagar.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoCharecters {

	public static void main(String[] args) {
		alternateStr("beabeefeab");
	}
	
	public static void alternateStr(String input){
		List<String> list = new ArrayList<>();
		Map<String, Integer> mapFromString = getMapFromString(input);
		for (String st : mapFromString.keySet()) {
			String replace = input.replace(st, "");
			list.add(isAlternateString(replace));
		}
		System.out.println(list);
	}
	
	public static String isAlternateString(String str){
		if(isAlternate(str) || str.length()<=2){
			return str;
		}
		Map<String, Integer> mapFromString = getMapFromString(str);
		String newStr = mapFromString.keySet().stream().findFirst().get();
		return isAlternateString(str.replace(newStr, ""));
	}
	
	private static Map<String, Integer> getMapFromString(String str) {
		String[] split = str.split("");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < split.length; i++) {
			if(map.containsKey(split[i])){
				map.put(split[i], map.get(split[i])+1);
			}else{
				map.put(split[i], 1);
			}
		}
		return map;
	}


	public static boolean isAlternate(String st){
		boolean alt = true;
		for (int i = 1; i < st.length()-1; i++) {
			if(st.charAt(i-1)!=st.charAt(i+1)){
				alt=false;
				break;
			}
		}
		return alt;
	}
}
