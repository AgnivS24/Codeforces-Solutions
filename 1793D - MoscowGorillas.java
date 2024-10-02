// Start of Impl: 6:22 PM

import java.io.*;
import java.util.*;
public class MoscowGorillas {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] p = new int[N];
		int[] q = new int[N];
		Map<Integer,Integer> pInds = new HashMap<Integer,Integer>();
		Map<Integer,Integer> qInds = new HashMap<Integer,Integer>();
		for(int i = 0; i < N; i++){
			p[i] = sc.nextInt();
			pInds.put(p[i],i+1);
		}
		for(int i = 0; i < N; i++){
			q[i] = sc.nextInt();
			qInds.put(q[i],i+1);
		}
		long total = 0;
		TreeSet<Integer> indices = new TreeSet<Integer>();
		Map<Integer,Pair> bounds = new HashMap<Integer,Pair>();
		for(int num = 1; num <= N; num++){
			indices.add(pInds.get(num));
			indices.add(qInds.get(num));
			int min = indices.first();
			int max = indices.last();
			bounds.put(num, new Pair(min,max));
		}
		for(int MEX = 1; MEX <= N + 1; MEX++){
			// Count number of subarrays with each MEX
			if(MEX == 1){
				long num1 = pInds.get(MEX);
				long num2 = qInds.get(MEX);
				if(num1 == num2) total += (num1) * (num1 - 1)/2 + (N - num2 + 1) * (N - num2)/2;
				else{
					long low = Math.min(num1,num2);
					long high = Math.max(num1,num2);
					long n1 = low - 1;
					long n2 = high - low - 1;
					long n3 = N - high;
					total += (n1 + 1) * (n1)/2 + (n2 + 1) * (n2)/2 + (n3 + 1) * (n3)/2;
				}
			}
			else if(MEX == N + 1){
				total++;
			}
			else{
				int left = bounds.get(MEX-1).x;
				int right = bounds.get(MEX-1).y;
				int pMEX = pInds.get(MEX);
				int qMEX = qInds.get(MEX);
				if(left <= pMEX && pMEX <= right || left <= qMEX && qMEX <= right){
					// cant have subarrays with this MEX
					continue;
				}
				else{
					int L = 1;
					if(pMEX < left && qMEX < left){
						L = Math.max(pMEX, qMEX) + 1;
					}
					else if(qMEX < left){
						L = qMEX + 1;
					}
					else if(pMEX < left){
						L = pMEX + 1;
					}
					int R = N;
					if(pMEX > right && qMEX > right){
						R = Math.min(pMEX,qMEX) - 1;
					}
					else if(pMEX > right){
						R = pMEX - 1;
					}
					else if(qMEX > right){
						R = qMEX - 1;

					}
					total += (long) (left - L + 1) * (R - right + 1);
					
				}
			}
		}
		System.out.println(total);
	}
}

class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
