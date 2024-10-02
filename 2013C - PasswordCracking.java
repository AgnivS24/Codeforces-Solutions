// Source: https://usaco.guide/general/io
 
import java.io.*;
import java.util.*;
 
public class PasswordCracking {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			int N = sc.nextInt();
			String q = "";
			// Length of the binary string
			boolean right = true;
			for(int bit = 0; bit < N; bit++){
				String qZero = right ? q + "0" : "0" + q;
				String qOne = right ? q + "1" : "1" + q;
				System.out.println("? " + (qZero));
				System.out.flush();
				int res1 = sc.nextInt();
				if(res1 == 1){
					q = (right) ? q + "0" : "0" + q;
					continue;
				}
				System.out.println("? " + (qOne));
				System.out.flush();
				int res2 = sc.nextInt();
				if(res1 == 0 && res2 == 0){
					right = false;
					System.out.println("? " + ("0" + q));
					System.out.flush();
					int aux1 = sc.nextInt();
					if(aux1 == 1){
						q = "0" + q;
					}
					else{
						q = "1" + q;
					}
				}
				else{
					q = (right) ? q + "1" : "1" + q;
				}
 
			}
			System.out.println("! " + q);
		}
	}
}