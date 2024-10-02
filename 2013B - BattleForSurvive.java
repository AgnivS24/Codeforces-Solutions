// Source: https://usaco.guide/general/io
 
import java.io.*;
import java.util.*;
 
public class BattleForSurvive {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			int N = sc.nextInt();
			long[] a = new long[N];
			for(int i = 0; i < N; i++){
				a[i] = sc.nextInt();
			}
			long total = 0;
			for(int i = N-1; i >= 0; i--){
				if(i == N - 2) total -= a[i];
				else total += a[i];
			}
			System.out.println(total);
		}
	}
}