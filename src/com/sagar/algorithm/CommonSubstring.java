package com.sagar.algorithm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommonSubstring {

	// Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
		String[] splitS1 = s1.split("");
		Map<String, Integer> map = new HashMap<>();
		for (String sp1 : splitS1) {
			if(!map.containsKey(sp1)){
				map.put(sp1, 1);
			}
		}
		String[] splitS2 = s2.split("");
		for (String sp2 : splitS2) {
			if(map.containsKey(sp2)){
				return "YES";
			}
		}
    	return "NO";


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    //    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);
            System.out.println(result);
/*
            bufferedWriter.write(result);
            bufferedWriter.newLine();*/
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
