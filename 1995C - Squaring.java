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
		//Scanner sc = new Scanner(System.in);
		int T =  Integer.parseInt(br.readLine());
		while(T-- > 0){
			int N = Integer.parseInt(br.readLine());
			int[] a = new int[N];
			long[] squares = new long[N];
			long sum = 0;
			boolean valid = true;
			String[] t = br.readLine().split(" ");
			for(int j = 0; j < N; j++){
				a[j] = Integer.parseInt(t[j]);
				if(!valid){
					continue;
				}
				
				if(j > 0 && a[j] < a[j-1] && a[j] == 1){
					valid = false;
				}
				if(j > 0 && squares[j-1] > Math.log(Math.log(a[j])/(Math.log(a[j-1])))/Math.log(2.0)){
					// a[j]^(2 ^ k) > a[j-1]^(2^squares[j-1])
					//System.out.println(squares[j])
					//System.out.println("Index " + (j - 1) + " and " + j + " need to be considered");
					long sqs = (long) Math.ceil(Math.log(Math.log(a[j-1])/Math.log(a[j]))/Math.log(2.0)) + squares[j-1];
					squares[j] = sqs;
				}
				sum += squares[j];
			}
			if(valid == false){
				System.out.println(-1);
				continue;
			}
			System.out.println(sum);
			
			
 
		}
		
	}
}