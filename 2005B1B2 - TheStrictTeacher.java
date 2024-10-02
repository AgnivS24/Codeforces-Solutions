
import java.io.*;
import java.util.*;
 
public class TheStrictTeacher {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		// String[] s = br.readLine().split(" ");
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			String[] t = br.readLine().split(" ");
			int N = Integer.parseInt(t[0]);
			int M = Integer.parseInt(t[1]);
			int Q = Integer.parseInt(t[2]);
			int[] b = new int[M];
			t = br.readLine().split(" ");
			for(int i = 0; i < M; i++){
				b[i] = Integer.parseInt(t[i]);
			}
			Arrays.sort(b);
			int min = b[0];
			int max = b[M-1];
			t = br.readLine().split(" ");
			for(int i = 0; i < Q; i++){
				int cell = Integer.parseInt(t[i]);
				if(cell < min) System.out.println(min - 1);
				else if(cell > max) System.out.println(N - max);
				else{
					//System.out.println(Arrays.toString(b));
					int ind = Arrays.binarySearch(b,cell);
					int highIndex = -ind - 1;
					int lowIndex = -ind - 2;
					int high = b[highIndex];
					int low = b[lowIndex];
					System.out.println((high - low)/2);
				}
			}
			
		}
	}
}