// Source: https://usaco.guide/general/io
 
import java.io.*;
import java.util.*;
 
public class Main {
	public static long gcd(long a, long b){
		if(a < b){
			return gcd(b,a);
		}
		else{
			return (a%b == 0) ? b : gcd(b,a%b);
		}
	}
	public static long lcm(long a, long b){
		return a/gcd(a,b) * b;
	}
	public static int count(long[] arr, long elem){
		int ct = 0;
		for(long t : arr){
			if(t == elem){
				ct++;
			}
		}
		return ct;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			int N = sc.nextInt();
			long M = sc.nextLong();
			long[] a = new long[N];
			long[] c = new long[N];
			Map<Long,Long> freqs = new HashMap<Long,Long>();
			for(int j = 0; j < N; j++){
				a[j] = sc.nextLong();
			}
			for(int j = 0; j < N; j++){
				c[j] = sc.nextLong();
				freqs.put(a[j],c[j]);
			}
			long max = 0;
			for(Long elem : freqs.keySet()){
				// Each petal of elem costs elem
				if(!freqs.containsKey(elem + 1)){
					long num = Math.min(freqs.get(elem),M/elem);
					//System.out.println("Value for " + elem + " is " + num);
					max = Math.max(max, num * elem);
				}
				else{
					long numLowUsed = Math.min(freqs.get(elem), M/elem);
					long total = numLowUsed * elem;
					long numUppUsed = Math.min(freqs.get(elem + 1), (M - total)/(elem + 1));
					total += numUppUsed * (elem + 1);
					///System.out.println("Number of " + elem + " used is " + numLowUsed + " with a total of " + total);
					//System.out.println("Number of " + (elem + 1) + " used is " + numUppUsed + " with a total of " + total);
					// Ideally add M - total upper ones
					long upperUsed = Math.min(numLowUsed,Math.min(M - total, freqs.get(elem + 1) - numUppUsed));
					//System.out.println("Value for " + elem + " is " + (total + upperUsed));
					max = Math.max(max,total + upperUsed);
 
				}
			}
			System.out.println(max);
			
			
 
		}
		
	}
}