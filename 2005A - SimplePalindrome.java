import java.io.*;
import java.util.*;
 
public class SimplePalindrome {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		// String[] s = br.readLine().split(" ");
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			int N = Integer.parseInt(br.readLine());
			String str = "aeiou";
			
			
			int x = N/5;
			int freqLarger = 5 - (5 * x + 5 - N);
			//System.out.println("freqLarger is " + freqLarger);
			if(N <= 5){
				System.out.println(str.substring(0,N));
			}
			else{
				for(int i = 1; i <= freqLarger; i++){
					String letter = str.substring(i-1,i);
					System.out.print(letter.repeat(x+1));
				}
				for(int i = freqLarger + 1; i <= 5; i++){
					String letter = str.substring(i-1,i);
					System.out.print(letter.repeat(x));
				}
				System.out.println();
			}
			
		}
	}
}
