// Source: https://usaco.guide/general/io
 
import java.io.*;
import java.util.*;
 
public class SakurakosExam {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			String[] t = br.readLine().split(" ");
			int a = Integer.parseInt(t[0]);
			int b = Integer.parseInt(t[1]);
			if(a%2 == 0 && b%2 == 0){
				System.out.println("YES");
			}
			else if(a%2 == 0 && b%2 == 1 && a != 0){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
 
		
 
		}
	}
}