// Source: https://usaco.guide/general/io
 
import java.io.*;
import java.util.*;
 
public class RangeSqrtSum {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			int N = sc.nextInt();
			// do range = 2 * N
			// then do average = 4 * N
			// lets take N = 6, range = 12, avg = 24, 18 x2 23 25 x5 30
			// lets take N = 7, range = 14, avg = 28, 21 x2 x3 28 x5 x6 35
			int[] a = new int[N];
			if(N == 2){
				System.out.println("1 3");
			}
			else{
				for(int i = 0; i < N; i++){
					if(N%2 == 1){
						if(i == N/2){
							a[i] = 4 * N;
						}
						else if(i == 0){
							a[i] = 3 * N;
						}
						else if(i == N - 1){
							a[i] = 5 * N;
						}
						else{
							a[i] = 4 * N - (N/2 - i);
						}
					}
					else{
						if(i == N/2 - 1){
							a[i] = 4 * N - 1;
						}
						else if(i == N/2){
							a[i] = 4 * N + 1;
						}
						else if(i == 0){
							a[i] = 3 * N;
						}
						else if(i == N - 1){
							a[i] = 5 * N;
						}
						else{
							if(i < N/2) a[i] = 4 * N - (N/2 - i);
							else a[i] = 4 * N - (N/2 - 1 - i);
						}
					}
					System.out.print(a[i] + " ");
				}
				System.out.println();
			}
			
			
		}
	}
}