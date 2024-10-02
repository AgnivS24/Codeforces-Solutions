

import java.io.*;
import java.util.*;

public class RobinHoodInTown {
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
	public static long gcd(long a, long b){
		return (a < b) ? gcd(b,a) : (a%b == 0 ? b : gcd(b,a%b));
	}
	public static long lcm(long a, long b){
		return a/gcd(a,b) * b;
	}
	public static long modinv(long a, long MOD){
		return binexp(a,MOD - 2, MOD);
	}
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			int N = sc.nextInt();
			long[] a = new long[N];
			
			long total = 0;
			for(int i = 0; i < N; i++){
				a[i] = sc.nextLong();
				total += a[i];
			}
			Arrays.sort(a);
			if(N/2 == N - 1){
				System.out.println(-1);
				continue;
			}
			long val = a[N/2];
			// val < 1/(2 * N) * (sum of values + x)
			// val * 2 * N < sum of values + x
			long min = val * 2 * N - total + 1;
			System.out.println((min < 0) ? 0 : min);
		
			
			

		}
	}
}
