package com.sagar.algorithm;

import java.util.HashMap;
import java.util.Map;

public class HackerRankInString {

	public Map<String,String> getSubString(String h){
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < h.length(); i++) {
			map.put(h.substring(0, i+1),null);
		}
		return map;
	}
	
	public String checkHackerRank(String s){
		Map<String, String> hMap = getSubString("hackerrank");
		for (int i = 0; i < s.length(); i++) {
			String substring = s.substring(0, i+1);
			if(hMap.containsKey(substring)){
				continue;
			}else{
				s=s.substring(0,i)+s.substring(i+1,s.length());
				i=-1;
			}
		}
		if("hackerrank".equalsIgnoreCase(s)){
			return "YES";
		}
		return "NO";
	}
	
	public static void main(String[] args) {
		HackerRankInString stack = new HackerRankInString();
		System.out.println(stack.checkHackerRank("knarrekcah"));
		System.out.println(stack.checkHackerRank("hackerrank"));
		System.out.println(stack.checkHackerRank("hackeronek"));
		System.out.println(stack.checkHackerRank("abcdefghijklmnopqrstuvwxyz"));
		System.out.println(stack.checkHackerRank("rhackerank"));
		System.out.println(stack.checkHackerRank("ahankercka"));
		System.out.println(stack.checkHackerRank("hacakaeararanaka"));
		System.out.println(stack.checkHackerRank("hhhhaaaaackkkkerrrrrrrrank"));
		System.out.println(stack.checkHackerRank("crackerhackerknar"));
		System.out.println(stack.checkHackerRank("hhhackkerbanker"));
		
		//System.out.println(stack.getSubString("hackerrank"));
		
		System.out.println(stack.checkHackerRank("hhhhaaaaackkkkerrrrrrrrank"));
	}
}
