// Source - https://codeforces.com/contest/1982/problem/D
import java.io.*;
import java.util.*;
 
public class BeautyOfTheMountains {
	public static long gcf(long a, long b){
		if(a < b){
			return gcf(b,a);
		}
		else{
			return (a%b == 0) ? b : gcf(a%b,b);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
outer:  while(T-- > 0){
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int K = Integer.parseInt(s[2]);
			int[][] grid = new int[N][M];
			for(int j = 0; j < N; j++){
				s = br.readLine().split(" ");
				for(int k = 0; k < M; k++){
					grid[j][k] = Integer.parseInt(s[k]);
				}
			}
			long snowies = 0;
			long nonsnowies = 0;
			long[][] dp = new long[N][M];
			for(int j = 0; j < N; j++){
				String[] st = br.readLine().split("");
				for(int k = 0; k < M; k++){
					if(st[k].equals("0")){
						snowies += grid[j][k];
					}
					else{
						nonsnowies += grid[j][k];
					}
					if(j == 0 && k == 0) dp[j][k] = (st[k].equals("0") ? 0 : 1);
					else if(j == 0) dp[j][k] = dp[j][k-1] + ((st[k].equals("0")) ? 0 : 1);
					else if(k == 0) dp[j][k] = dp[j-1][k] + ((st[k].equals("0")) ? 0 : 1);
					else dp[j][k] = dp[j-1][k] + dp[j][k-1] - dp[j-1][k-1] + (st[k].equals("0") ? 0 : 1);
				}
			}
			
			if(snowies == nonsnowies){
				System.out.println("YES");
			}
			else{
 
				boolean possible = false;
				List<Long> factors = new ArrayList<Long>();
				for(int j = 0; j <= N - K; j++){
					for(int k = 0; k <= M - K; k++){
						//System.out.println("Checking from bot right " + (j+K-1) + " " + (k + K - 1));
						long val = dp[j+K-1][k+K-1];
						if(k > 0) val -= dp[j+K-1][k-1];
						if(j > 0) val -= dp[j-1][k+K-1];
						if(j > 0 && k > 0) val += dp[j-1][k-1];
						//System.out.println("Number of ones is " + val);
						long numOnes = val;
						long numZeros = (K * K - val);
						//System.out.println((long) Math.abs(numOnes - numZeros) + " is the difference");
						if(numOnes != numZeros) factors.add((long) Math.abs(numOnes - numZeros));
						//set.add(val);
					}
				}
				if(factors.isEmpty()){
					System.out.println("NO");
				}
				else{
					long result = factors.get(0);
 
					for(int j = 0; j < factors.size(); j++){
						//if(factors.get(j) == 0) continue;
						result = gcf(result,factors.get(j));
						
					}
					//System.out.println("overall gcf is " + result);
					long diff = (long) Math.abs(snowies - nonsnowies);
					System.out.println(diff%result == 0 ? "YES" : "NO");
				}
			}
 
		}
	}
}