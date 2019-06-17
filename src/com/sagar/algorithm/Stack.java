package com.sagar.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stack {

	private String[] arr;
	public void push(String str){
		
		int len = 0;
		if(null==arr || arr.length==0){
			arr= new String[1];
			arr[0]=str;
		}else{
			String[] bArr = Arrays.copyOf(arr, arr.length+1);
			bArr[bArr.length-1]=str;
			arr=bArr;
			/*len = arr.length;
			String[] dupArr = new String[len+1];
			copyAllToDup(dupArr,arr);
			dupArr[len]=str;
			arr=dupArr;*/
		}
	}
	
	public String peek(){
		if(null!=arr && arr.length>0){
			return arr[arr.length-1];
		}	
		return null;
	}	
	
	public String pop(){
		if(null==arr || arr.length==0){
			return null;
		}else{
			String s =arr[arr.length-1]; 
			arr = Arrays.copyOf(arr, arr.length-1);
			return s;
		}
	}
	
	public String[] getStack(){
		return arr;
	}

	private void copyAllToDup(String[] dupArr,String[] arr) {
		for (int i=0;i<arr.length;i++) {
			dupArr[i]=arr[i];
		}
	}
	
	/**
	 * @param s
	 * @return
	 */
	public String isHackerRank(String s){
		Map<String, List<String>> hMap = new HashMap<>();
		hMap.put("h", Arrays.asList("a"));
		hMap.put("a", Arrays.asList("c","n"));
		hMap.put("c", Arrays.asList("k","n"));
		hMap.put("k", Arrays.asList("e"));
		hMap.put("e", Arrays.asList("r"));
		hMap.put("r", Arrays.asList("r","a"));
		hMap.put("n", Arrays.asList("k"));
		
		for (int i = 0; i < s.length()-1; i++) {
			String k = Character.toString(s.charAt(i));
			String next = Character.toString(s.charAt(i+1));
			if(hMap.get(k)==null || !hMap.get(k).contains(next) || ("r".equalsIgnoreCase(k) && s.substring(0,i).equalsIgnoreCase("hacke") && !"r".equalsIgnoreCase(next))){
				s = s.substring(0,i)+k+s.substring(i+2, s.length());
				i=-1;
			}
		}
		if("hackerrank".equalsIgnoreCase(s)){
			return "YES";
		}
		return "NO";
	}
		
	private boolean isEmpty() {
		if(arr==null || arr.length==0){
			return true;
		}
		return false;
	}

	private Object addToTemp(String e, StringBuilder tempBuilder) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		/*stack.push("Sagar");
		stack.push("S");
		stack.push("a");
		stack.push("g");
		stack.push("a");
		stack.push("r");
		
		String[] stackArr = stack.getStack();
		for (int i = 0; i < stackArr.length; i++) {
			System.out.println(stackArr[i]);
		}
		
		System.out.println("Popping the stack");
		String s = null;
		while((s=stack.pop())!=null){
			System.out.println(s);
		}*/
		//hackerrank
		//hackeraraannk
		//hackerrank
		//System.out.println(stack.isHackerRank("haacckkerrannkk"));
		//System.out.println(stack.isHackerRank("hhaacckkekraraannk"));
	/*	System.out.println(stack.isHackerRank("knarrekcah"));
		System.out.println(stack.isHackerRank("hackerrank"));
		System.out.println(stack.isHackerRank("hackeronek"));
		System.out.println(stack.isHackerRank("abcdefghijklmnopqrstuvwxyz"));
		System.out.println(stack.isHackerRank("rhackerank"));
		System.out.println(stack.isHackerRank("ahankercka"));
		System.out.println(stack.isHackerRank("hacakaeararanaka"));*/
		//System.out.println(stack.isHackerRank("hhhhaaaaackkkkerrrrrrrrank"));
	/*	System.out.println(stack.isHackerRank("crackerhackerknar"));
		System.out.println(stack.isHackerRank("hhhackkerbanker"));*/
		
		//System.out.println(stack.getSubString("hackerrank"));
		
		System.out.println(stack.checkHackerRank("hhhhaaaaackkkkerrrrrrrrank"));
	}
	
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
}
