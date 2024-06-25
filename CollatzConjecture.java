// Source: https://usaco.guide/general/io
 
import java.io.*;
import java.util.*;
 
public class CollatzConjecture {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
outer:  while(T-- > 0){
			String[] s = br.readLine().split(" ");
			long X = Long.parseLong(s[0]); // Initial number
			long Y =  Long.parseLong(s[1]); // divide by Y
			long K =  Long.parseLong(s[2]); // K times
			int count = 0;
			while(K > 0){
				long num = -1;
				if(X%Y == 0){
					num = X + Y;
				}
				else{
					num = (long) (Y * Math.ceil((double) X/Y));
				}
				//System.out.println("Target num is " + num);
				if(num - X > K){
					X += K;
					K = 0;
					break;
				}
				//System.out.println("Using " + num + " minus " + X + " operations");
				K -= num - X;
				X = num/Y;
				while(X%Y == 0){
					X /= Y;
				}
				//System.out.println("X is now " + X + " with " + K + " operations left");
				if(X == 1){
					System.out.println((X + K)%(Y - 1) == 0 ? Y - 1 : (X + K)%(Y - 1));
					continue outer;
				}
 
			}
			System.out.println(X);
		}
	}
}