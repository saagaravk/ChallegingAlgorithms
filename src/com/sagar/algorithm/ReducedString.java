package com.sagar.algorithm;

import java.util.Stack;

public class ReducedString {

	public static void main(String[] args) {
		test();
		/*String s ="abcdeedcba";
		Stack<Character> stack = new Stack<>();
		int k=0;
		while(k<s.length()){
			if(k==s.length()-1){
				stack.push(s.charAt(k));
				break;
			}
			if (s.charAt(k)==s.charAt(k+1)) {
				k+=2;
				continue;
			}else{
				stack.push(s.charAt(k));
			}
			k++;
		}
		StringBuilder builder = new StringBuilder();
		while(!stack.isEmpty()){
			Character pop = stack.pop();
			if(!stack.isEmpty()){
				Character peek = stack.peek();
				if(pop==peek){
					stack.pop();
					continue;
				}
			}
			builder.append(pop);
		}
		System.out.println(builder.reverse().toString());*/
	}
	
	public static  void test(){
		String str = "abcdeedcba";
		 for (int i = 1; i < str.length(); i++) {
	            if (str.charAt(i) == str.charAt(i-1)) {
	                str = str.substring(0, i-1) + str.substring(i+1);
	                i = 0;
	            }
	        }
        if (str.length() == 0) {
            System.out.println("Empty String");
        } else {
            System.out.println (str);
        }
	}
}
