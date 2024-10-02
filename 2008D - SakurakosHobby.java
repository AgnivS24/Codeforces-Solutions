// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class SakurakosHobby {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			int N = sc.nextInt();
			int[] p = new int[N];
			Map<Integer,List<Integer>> graph = new HashMap<Integer,List<Integer>>();
			for(int i = 0; i < N; i++){
				p[i] = sc.nextInt();
				if(!graph.containsKey(i+1)) graph.put(i+1, new ArrayList<Integer>());
				if(!graph.containsKey(p[i])) graph.put(p[i], new ArrayList<Integer>());
				graph.get(i+1).add(p[i]);
				graph.get(p[i]).add(i+1);
			}
			sc.nextLine();
			String str = sc.nextLine();
			boolean[] black = new boolean[N];
			for(int k = 0; k < str.length(); k++){
				black[k] = (str.substring(k,k+1).equals("0")) ? true : false;
			}
			int[] count = new int[N];
			boolean[] visited = new boolean[N];
			for(int j = 1; j <= N; j++){
				if(visited[j-1]) continue;
				Stack<Integer> stack = new Stack<Integer>();
				visited[j-1] = true;
				stack.push(j);
				int curr = j;
				List<Integer> comp = new ArrayList<Integer>();
				comp.add(j);
				while(!stack.isEmpty()){
					int node = stack.pop();
					for(Integer neighbor : graph.get(node)){
						if(visited[neighbor-1]) continue;
						visited[neighbor-1] = true;
						stack.push(neighbor);
						comp.add(neighbor);
					}
				}
				//System.out.println(comp);
				int ct = 0;
				for(Integer node : comp){
					if(black[node-1]) ct++;
				}
				for(Integer node : comp){
					count[node - 1] = ct;
				}
			}
			//System.out.println("done");
			for(int i = 0; i < N; i++){
				System.out.print(count[i] + " ");
			}
			System.out.println();

			
			
		

		}
	}
}
