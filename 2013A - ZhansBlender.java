// Source: https://usaco.guide/general/io
 
import java.io.*;
import java.util.*;
 
public class ZhansBlender {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			long N = sc.nextLong();
			long X = sc.nextLong();
			long Y = sc.nextLong();
			System.out.println(Math.max((N + X - 1)/X,(N + Y - 1)/Y));
		}
	}
}