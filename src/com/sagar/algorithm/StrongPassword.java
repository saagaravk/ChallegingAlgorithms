package com.sagar.algorithm;

import java.util.function.Function;

public class StrongPassword {

	private static String UPPER_CASE = "[A-Z]+";
	private static String LOWER_CASE = "[a-z]+";
	private static String SPECIAL_CASE = "[!@#$%^&*()-+]+";
	private static String NUMBER = "[1-9]+";

	enum PasswordType{
		STRONG,BETTER,GOOD,WEAK;
	}
	
	class NumStr{
		private String str;
		private int num;
		public String getStr() {
			return str;
		}
		public void setStr(String str) {
			this.str = str;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		
	}
	static Function<String, NumStr> UpperFunction = password -> {
		int counter=0;
		String[] split = password.split(UPPER_CASE);
		String buildString = buildString(split);
		if (password.length() == buildString.length()) {
			counter++;
		}
		return generateNumStr(counter, buildString);
	};
	
	static Function<String, NumStr> LowerFunction = password -> {
		int counter=0;
		String[] split = password.split(LOWER_CASE);
		String buildString = buildString(split);
		counter = getCounter(password, counter, buildString);
		return generateNumStr(counter, buildString);
	};
	private static int getCounter(String password, int counter, String buildString) {
		if (password.length() == buildString.length()) {
			counter++;
		}
		return counter;
	}
	
	static Function<String, NumStr> SpecialFunction = password -> {
		int counter=0;
		String[] split = password.split(SPECIAL_CASE);
		String buildString = buildString(split);
		if (password.length() == buildString.length()) {
			counter++;
		}
		return generateNumStr(counter, buildString);
	};
	
	static Function<String, NumStr> NumberFunction = password -> {
		int counter=0;
		String[] split = password.split(NUMBER);
		String buildString = buildString(split);
		if (password.length() == buildString.length()) {
			counter++;
		}
		return generateNumStr(counter, buildString);
	};
	private static NumStr generateNumStr(int counter, String buildString) {
		StrongPassword strPwd = new StrongPassword();
		NumStr numStr = strPwd.new NumStr();
		numStr.setNum(counter);
		numStr.setStr(buildString);
		return numStr;
	}
	static int minimumNumber(int n, String password) {
		int counter = 0;
		// Return the minimum number of characters to make the password strong
		if (null != password && n > 0 && password.length() == n) {
			int len = n;
			NumStr numStr = UpperFunction.apply(password);
			String buildString = numStr.getStr();
			counter+= numStr.getNum();
			password = buildString;
			numStr = LowerFunction.apply(password);
			buildString = numStr.getStr();
			counter+= numStr.getNum();
			password = buildString;
			
			numStr = SpecialFunction.apply(password);
			buildString = numStr.getStr();
			counter+= numStr.getNum();
			password = buildString;
			
			numStr = NumberFunction.apply(password);
			buildString = numStr.getStr();
			counter+= numStr.getNum();
			password = buildString;
			
			if(len<6){
				int ext = 6-counter-len;
				counter=counter+ext;
			}
			// }
		} else {
			return 4;
		}
		return counter;
	}

	static String buildString(String[] arr) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			builder.append(arr[i]);
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		int minimumNumber = minimumNumber(8, "Welcome2");
		System.out.println(getPasswordType(minimumNumber));
	}
	
	private static String getPasswordType(int minimumNumber) {
		String passType = PasswordType.WEAK.name();
		switch (minimumNumber) {
		case 4:
			passType = PasswordType.WEAK.name();
			break;
		case 3:
			passType = PasswordType.WEAK.name();
			break;
		case 2:
			passType = PasswordType.GOOD.name();
			break;
		case 1:
			passType = PasswordType.BETTER.name();
			break;
		case 0:
			passType = PasswordType.STRONG.name();
			break;

		default:
			break;
		}
		return passType;
	}

}
