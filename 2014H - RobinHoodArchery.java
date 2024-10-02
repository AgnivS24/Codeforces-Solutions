// Source: https://usaco.guide/general/io
 
import java.io.*;
import java.util.*;
 
public class RobinHoodArchery {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			int N = sc.nextInt();
			int Q = sc.nextInt();
			long[] a = new long[N];
			Map<Long,Long> hash = new HashMap<Long,Long>();
			for(int i = 0; i < N; i++){
				a[i] = sc.nextLong();
				// Assign 64-bit random number to a[i]
				if(!hash.containsKey(a[i])) hash.put(a[i], (long) Math.floor(Math.random() * Long.MAX_VALUE));
			}
			long[] xor = new long[N];
			for(int i = 0; i < N; i++){
				a[i] = hash.get(a[i]);
				xor[i] = (i == 0) ? a[0] : (a[i] ^ xor[i-1]);
			}
			for(int i = 1; i <= Q; i++){
				int L = sc.nextInt() - 1;
				int R = sc.nextInt() - 1;
				// Same xor from 0 ... R as from 0 ... L - 1
				if(xor[R] != ((L == 0) ? 0 : xor[L-1])){
					System.out.println("NO");
				}
				else{
					System.out.println("YES");
				}
			}
			
 
		}
	}
}