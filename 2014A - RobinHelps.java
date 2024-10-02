

import java.io.*;
import java.util.*;

public class RobinHelps {
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
			int K = sc.nextInt();
			int[] a = new int[N];
			long robin = 0;
			int count = 0;
			for(int i = 0; i < N; i++){
				a[i] = sc.nextInt();
				if(a[i] >= K){
					robin += a[i];
				}
				else if(a[i] == 0){
					if(robin >= 1){
						robin--;
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}
