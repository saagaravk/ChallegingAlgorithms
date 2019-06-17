package com.sagar.algorithm;

import java.util.HashMap;

public class StringConstruction{

    private static Integer EMPTY_OBJECT= new Integer(0);
    public static void main(String[] args){
        constructString("ABCDAB");
    }

	private static void constructString(String str) {
		int pay=0;
		HashMap<String, Integer> map = new HashMap<>();
		int start = 0;
		int end = 1;
		while (end<=str.length()) {
			String temp = str.substring(start, end);
			if (!map.containsKey(temp)) {
				pay++;
				map.put(temp, EMPTY_OBJECT);
			} 
				start++;
				end++;
		}
		System.out.println(pay);
	}

}