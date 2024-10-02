// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class LongestIncreasingArray {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] t = new long[100000];
		for(int i = 0; i < t.length; i++){
			t[i] = (long) i * (i + 1)/2;
		}
		while(T-- > 0){
			long L = sc.nextLong();
			long R = sc.nextLong();
			
			long diff = R - L;
			int index = Arrays.binarySearch(t,diff);
			if(index >= 0) System.out.println(index + 1);
			else System.out.println(-index - 1);
			
		

		}
	}
}
