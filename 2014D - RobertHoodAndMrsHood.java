import java.io.*;
import java.util.*;
 
public class RobertHoodAndMrsHood {
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
			int D = sc.nextInt();
			int K = sc.nextInt();
			Map<Integer,Integer> lefts = new HashMap<Integer,Integer>();
			Map<Integer,Integer> rights = new HashMap<Integer,Integer>();
			for(int i = 1; i <= K; i++){
				int L = sc.nextInt();
				int R = sc.nextInt();
				lefts.put(L, lefts.getOrDefault(L, 0) + 1);
				rights.put(R, rights.getOrDefault(R,0) + 1);
			}
			int count = 0;
			for(int d = 1; d <= D; d++){
				count += lefts.getOrDefault(d,0);
			}
			int min = count;
			int max = count;
			int bestDayM = 1;
			int bestDayB = 1;
			for(int L = 2; L <= N - D + 1; L++){
				count += lefts.getOrDefault(L + D - 1,0);
				count -= rights.getOrDefault(L - 1,0);
				if(count < min){
					bestDayM = L;
					min = count;
				}
				if(count > max){
					bestDayB = L;
					max = count;
				}
			}
			System.out.println(bestDayB + " " + bestDayM);
		
			
			
 
		}
	}
}