// Source: https://codeforces.com/contest/1986/problem/C
 
import java.io.*;
import java.util.*;
 
public class UpdateQueries {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			int[] ind = new int[M];
			for(int j = 0; j < M; j++){
				ind[j] = sc.nextInt();
			}
			sc.nextLine();
			String c = sc.nextLine();
			// Sort c by the smallest min(c.length(), N) letters in it
			List<String> items = new ArrayList<String>();
			for(int j = 0; j < M; j++){
				items.add(c.substring(j,j+1));
			}
			Arrays.sort(ind);
			items.sort(Comparator.naturalOrder());
			String[] ans = new String[N];
			int count = 0;
			for(int k = 0; k < M; k++){
				if(k == 0) ans[ind[k]-1] = items.get(count);
				else{
					if(ind[k] == ind[k-1]) continue;
					ans[ind[k]-1] = items.get(count);
				}
				count++;
			}
			for(int l = 0; l < ans.length; l++){
				System.out.print(ans[l] == null ? str.substring(l,l+1) : ans[l]);
			}
			System.out.println();
		}
			
	}
}