// Source: https://usaco.guide/general/io
 
import java.io.*;
import java.util.*;
 
public class KillDemodogs {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long MOD = 1000000007;
		while(T-- > 0){
			long N = sc.nextLong();
			long cube = (((1348 * N)%MOD * N)%MOD * N)%MOD;
			long square = ((1011 * N)%MOD * N)%MOD;
			System.out.println(((cube + square - 337 * N)%MOD + MOD)%MOD);
		}
	}
}