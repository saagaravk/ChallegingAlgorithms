package com.sagar.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class WeightedUniformStrings2<E> {

	
	
	public static void mains(String[] args) {
	/*	Map<String, Integer> map = new HashMap<>();*/
		String a="aaabbbbcccddd";
		int[] queries = {9,7,8,12,5};
		for(String s:weightedUniformStrings(a,queries)){
			System.out.println(s);
		}
	}
	
	static String[] weightedUniformStrings(String s, int[] queries) {
		System.out.println(new Date());
		Map<String, Integer> map = new HashMap<>();
		String a=s.toLowerCase();
		Instant start = Instant.now();
		for (int i = 0; i < a.length(); i++) {
			String aSub = a.substring(0,i+1);
			if(isAlternate.test(aSub)){
				map.put(aSub, getWeight.apply(aSub));
			}else{
				a=a.substring(i,a.length());
				i=-1;
			}
		}
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println("Time Elapsed in Looping n setting value  :"+timeElapsed);
		Instant start2 = Instant.now();
		Collection<Integer> values = map.values();
		Map<Integer, Object> intMap = new HashMap<>(values.size());
		values.stream().forEach(k->intMap.put(k, k));
		List<String> list = new ArrayList<>();
		for (int i = 0; i < queries.length; i++) {
			if(intMap.get(queries[i]) != null){
				list.add("Yes");
			}else{
				list.add("No");
			}
		}
		Instant finish2 = Instant.now();
		timeElapsed = Duration.between(start2, finish2).toMillis();
		System.out.println("Time Elapsed in contains :"+timeElapsed);
		return getStringArray.apply(list);
    }
	
	static Function<String, Integer> getWeight = k->{
		int val = k.chars().findAny().getAsInt()-96;
		return val!=0?k.length()*val:0;
	};
	
	static Function<List<String>,String[]> getStringArray = k->{
		Instant start = Instant.now();
		String[] sArr = null;
		if(null!=k && !k.isEmpty()){
			sArr = new String[k.size()];
			for (int i=0;i<sArr.length;i++) {
				sArr[i]=k.get(i);
			}
		}
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println("Time Elapsed in getString value  :"+timeElapsed);
		return sArr;
	};
	
	static Predicate<String> isAlternate = s->{
		int length = s.length();
		for (int i = 1; i < length; i++) {
			if(s.charAt(0)!=s.charAt(i)){
				return false;
			}
		}
		return true;
	};
	
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("result.txt")));
        FileInputStream fis = new FileInputStream("D:\\_Data\\Personal\\workspace\\ChallegingAlgorithms\\input2.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        
        String s = reader.readLine();

        int queriesCount = Integer.parseInt(reader.readLine());

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = Integer.parseInt(reader.readLine());
            queries[i] = queriesItem;
        }
        reader.close();
        fis.close();
        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
    
}
