

import java.io.*;
import java.util.*;

public class RobinHoodAndTheMajorOak {
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
			long N = sc.nextLong();
			long K = sc.nextLong();
			long left = Math.max(N - K + 1,1);
			long right = N;
			if(left%2 == 1){
				if((right - left)%4 == 0 || (right - left)%4 == 1){
					System.out.println("NO");
				}
				else{
					System.out.println("YES");
				}
			}
			else{
				if((right - left)%4 == 1 || (right - left)%4 == 2){
				
					System.out.println("NO");
				}
				else{
					System.out.println("YES");
				}
			}
		
			
			

		}
	}
}
