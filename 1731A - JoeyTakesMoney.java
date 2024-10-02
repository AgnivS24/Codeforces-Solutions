// Source: https://usaco.guide/general/io
 
import java.io.*;
import java.util.*;
 
public class JoeyTakesMoney {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			int N = sc.nextInt();
			long[] a = new long[N];
			long prod = 1;
			for(int i = 0; i < N; i++){
				a[i] = sc.nextLong();
				prod *= a[i];
			}
			System.out.println(2022 * (prod + N - 1));
		}
	}
}
