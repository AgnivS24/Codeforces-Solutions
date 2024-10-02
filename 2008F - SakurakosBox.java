// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class SakurakosBox {
	public static long binexp(long a, long b, long MOD){
		long mult = 1;
		while(b >= 1){
			if(b%2 == 1){
				mult = (mult * a)%MOD;
			}
			b /= 2;
			a = (a * a)%MOD;
			
		}
		return mult;
	}
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long MOD = 1000000007;
		while(T-- > 0){
			int N = sc.nextInt();
			long[] a = new long[N];
			long sum = 0;
			long sumSquared = 0;

			for(int i = 0; i < N; i++){
				a[i] = sc.nextLong();
				sum += a[i];
				sumSquared = (sumSquared + (a[i] * a[i])%MOD)%MOD;
			}
			//long su = 1000000000000L;
			//System.out.println(su%MOD * su%MOD);
			//System.out.println((su%MOD * su)%MOD);
			//System.out.println((su%MOD) * (su%MOD)%MOD);
			sum %= MOD;
			long P = ((sum * sum)%MOD - sumSquared%MOD + MOD)%MOD;
			long Q = ((long) N * (N - 1))%MOD;
			// Find modular inverse of Q (mod 10^9 + 7)
			// This will be Q^(10^9 + 5) 
			//System.out.println(P + " and " + Q);
			long modinv = binexp(Q,MOD - 2,MOD);
			//System.out.println(modinv + " is modinv");
			System.out.println((P * modinv)%MOD);
			
			
			
		

		}
	}
}
