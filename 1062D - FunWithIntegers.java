// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class FunWithIntegers {
	public static long sum(Set<Integer> nums){
		long total = 0;
		for(Integer num : nums){
			total += num;
		}
		return total;
	}
	public static Set<Integer> factors(int num){
		Set<Integer> facts = new HashSet<Integer>();
		for(int i = 1; i <= Math.sqrt(num); i++){
			if(num%i == 0){
				facts.add(i);
				facts.add(num/i);
			}
		}
		return facts;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[100000];
		dp[0] = 0;

		for(int i = 1; i < 100000; i++){
			dp[i] = dp[i-1] + (sum(factors(i+1)) - (i+1) - 1);
		}
		int N = Integer.parseInt(br.readLine());
		System.out.println(4 * dp[N-1]);
	}
}
