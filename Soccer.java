// Source: https://codeforces.com/contest/1982/problem/A
 
import java.io.*;
import java.util.*;
 
public class Soccer {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			long x1 = sc.nextLong();
			long y1 = sc.nextLong();
			long x2 = sc.nextLong();
			long y2 = sc.nextLong();
			if(x1 >= y1 && x2 <= y2 || y1 >= x1 && y2 <= x2){
				System.out.println("NO");
			}
			else{
				System.out.println("YES");
			}
		}
	}
}
