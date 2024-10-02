// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class SquareOrNot {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			int N = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			int L = str.length();
			if(Math.floor(Math.sqrt(L)) != Math.sqrt(L)){
				System.out.println("NO");
			}
			else{
				boolean valid = true;
				int R = (int) Math.sqrt(L);
				int[][] grid = new int[R][R];
				int r = 0;
				int c = 0;
				
				for(int i = 0; i < str.length(); i++){
					
					grid[r][c] = Integer.parseInt(str.substring(i,i+1));
					if(c < R - 1) c++;
					else{
						r++;
						c = 0;
					}
				}
				
				for(int i = 0; i < grid.length; i++){
					for(int j = 0; j < grid.length; j++){
						if((i == 0 || j == 0 || i == grid.length - 1 || j == grid.length - 1) && grid[i][j] != 1){
							valid = false;
						}
						if((i != 0 && j != 0 && i != grid.length - 1 && j != grid.length - 1) && grid[i][j] != 0){
							valid = false;
						}
					}
				}
				System.out.println(valid ? "YES" : "NO");
			}
		

		}
	}
}
