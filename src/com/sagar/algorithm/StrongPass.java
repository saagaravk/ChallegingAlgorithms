package com.sagar.algorithm;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StrongPass {

	private static String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
	private static String SPECIAL_CASE = "!@#$%^&*()-+";
	private static String NUMBER = "0123456789";
	/*private static Object simpleObject = new Object();
	private static Map<String, Object> numberMap = new HashMap<>();
	private static Map<String, Object> lowerCaseMap = new HashMap<>();
	private static Map<String, Object> upperMap = new HashMap<>();
	private static Map<String, Object> specialMap = new HashMap<>();
	
	static{
			String[] split = UPPER_CASE.split("");
			for (int i = 0; i < split.length; i++) {
				upperMap.put(split[i],simpleObject);
			}
			split = LOWER_CASE.split("");
			for (int i = 0; i < split.length; i++) {
				lowerCaseMap.put(split[i],simpleObject);
			}
			split = NUMBER.split("");
			for (int i = 0; i < split.length; i++) {
				numberMap.put(split[i],simpleObject);
			}
			split = SPECIAL_CASE.split("");
			for (int i = 0; i < split.length; i++) {
				specialMap.put(split[i],simpleObject);
			}
	}*/
	
	private static int getChars(int n,String pass){
		int counter=0;
		int length = pass.length();
		if(pass!=null && n==pass.length()){
			for (int i = 0; i < pass.length(); i++) {
				if(SPECIAL_CASE.contains(Character.toString(pass.charAt(i)))){
					break;
				}else if(i==pass.length()-1 && !SPECIAL_CASE.contains(Character.toString(pass.charAt(i))) ){
					counter++;
				}
			}for (int i = 0; i < pass.length(); i++) {
				if(NUMBER.contains(Character.toString(pass.charAt(i)))){
					break;
				}else if(i==pass.length()-1 && !NUMBER.contains(Character.toString(pass.charAt(i))) ){
					counter++;
				}
			}for (int i = 0; i < pass.length(); i++) {
				if(UPPER_CASE.contains(Character.toString(pass.charAt(i)))){
					break;
				}else if(i==pass.length()-1 && !UPPER_CASE.contains(Character.toString(pass.charAt(i))) ){
					counter++;
				}
			}for (int i = 0; i < pass.length(); i++) {
				if(LOWER_CASE.contains(Character.toString(pass.charAt(i)))){
					break;
				}else if(i==pass.length()-1 && !LOWER_CASE.contains(Character.toString(pass.charAt(i))) ){
					counter++;
				}
			}
			if(length<6){
				int remain=6-length;
				while(counter<remain){
					counter++;
				}
			}
		}
		return counter;
	}
	
	public static void main(String[] args) {
		String pass = "0#)+g!";
		System.out.println(getChars(pass.length(),pass));
	}
	
	public String any(String str,Collection<String> collection){
		return null;
	}
}
