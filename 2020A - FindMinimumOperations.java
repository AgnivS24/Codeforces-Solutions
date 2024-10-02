 
import java.io.*;
import java.util.*;
 
public class FindMinimumOperations {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int ii = 1; ii <= T; ii++){
			long N = sc.nextLong();
			long K = sc.nextLong();
			long operations = 0;
			while(N > 0){
				long num = (long) (Math.log(N)/Math.log(K));
				long number = (long) Math.pow(K,num);
				operations += N/number;
				N -= (N/number) * number;
			}
			System.out.println(operations);
		}
	}
}