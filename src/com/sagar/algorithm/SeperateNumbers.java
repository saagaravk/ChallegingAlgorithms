package com.sagar.algorithm;

import java.util.function.Function;

public class SeperateNumbers {

	public static void main(String[] args) {
		String s = "1234";
		/*System.out.println(s.substring(0,1));
		System.out.println(s.substring(1,2));
		System.out.println(s.substring(0,2));
		System.out.println(s.substring(2,4));
		int k =1;
		while(k<3){
			for (int i = 0; i < s.length()-k; i=i+k) {
				System.out.println(s.substring(i*k,i*k+k)+"**"+s.substring(i*k+k,i*k+k+k));
			}
			k++;
		}*/
	/*	separateNumbers("12345678910");	
		separateNumbers("121314");*/
		//separateNumbers("99910001001");
		separateNumbers("1981992005");
	}
	
	static Function<String,Boolean> isNumber = n -> {
		if(null!=n && n.length()>0){
			try {
				long num = Long.parseLong(n);
				return true;
			} catch (Exception e) {
				System.out.println("Not a number");
			}	
		}
		return false;
	};
	
	/**
	 *	7
		1234
		91011
		99100
		101103
		010203
		13
		1
	 * @param s
	 */
	/*static void separateNumbers(String s) {
		if(isNumber.apply(s)){
			int k= 1;
			while(k<(s.length()+1)/2){
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < s.length()-k; i=i+k) {
					if(Integer.parseInt(s.substring(i*k+k,i*k+k+k))-Integer.parseInt(s.substring(i*k,i*k+k))!=1){
						builder = new StringBuilder();
						break;
					}else{
						builder.append(s.substring(i*k,i*k+k));
					}
				}
				if(builder.toString().length()==s.length()-1){
					System.out.println(builder.charAt(0)+" YES");
				}
				k++;
			}
			
		}

    }*/
	
	static void separateNumbers(String s) {
		if(isNumber.apply(s)){
			int k= 1;
			while(k<(s.length()+1)/2){
				boolean fl = true;
				StringBuilder builder = new StringBuilder();
				for (int i = 0; (i < (s.length()-k) && (i*k+k)<s.length()); i++) {
					/*int a = isNumber.apply(s.substring(k*i, i*k+k))?Integer.parseInt(s.substring(k*i, i*k+k)):0;
					int b = isNumber.apply(s.substring(i*k+k, i*k+k+k))?Integer.parseInt(s.substring(i*k+k, i*k+k+k)):0;*/
					
					int a = Integer.parseInt(s.substring(k*i, i*k+k));
					int b = Integer.parseInt(s.substring(i*k+k, i*k+k+k));
					if(b-a!=1 && a%10==9 && i*k+k+k+1<s.length()){
						b=Integer.parseInt(s.substring(i*k+k, i*k+k+k+1));
						if(b-a!=1){
							fl=false;
							break;
						}
						i++;
					}
					if(b-a!=1){
						fl = false;
						break;
					}
					builder.append(a);
				}
				if(fl){
					System.out.println(builder.toString().substring(0,k)+" YES");
				}
				k++;
			}
		}
    }
}
