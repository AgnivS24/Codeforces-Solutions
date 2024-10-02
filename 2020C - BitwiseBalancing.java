

import java.io.*;
import java.util.*;

public class BitwiseBalancing {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			long B = sc.nextLong();
			long C = sc.nextLong();
			long D = sc.nextLong();
			String bStr = Long.toBinaryString(B);
			String cStr = Long.toBinaryString(C);
			String dStr = Long.toBinaryString(D);
			int maxLength = Math.max(dStr.length(),Math.max(bStr.length(), cStr.length()));
			bStr = String.format("%" + maxLength + "s",bStr).replace(" ","0");
			cStr = String.format("%" + maxLength + "s",cStr).replace(" ","0");
			dStr = String.format("%" + maxLength + "s",dStr).replace(" ","0");
			int[] a = new int[maxLength];
			boolean valid = true;
			//System.out.println(bStr + " " + cStr + " " + dStr);
			for(int i = 0; i < maxLength; i++){
				// casework on bstr and cstr
				int bdigit = Integer.parseInt(bStr.substring(i,i+1));
				int cdigit = Integer.parseInt(cStr.substring(i,i+1));
				int ddigit = Integer.parseInt(dStr.substring(i,i+1));
				if(bdigit == 1 && cdigit == 0){
					if(ddigit == bdigit - cdigit){
						a[i] = 0;
					}
					else{
						valid = false;
						break;
					}
				}
				else if(bdigit == 1){
					a[i] = bdigit - ddigit;
				}
				else if(cdigit == 0){
					a[i] = ddigit + cdigit;
				}
				else{
					if(ddigit == 0){
						a[i] = 1;
					}
					else{
						valid = false;
						break;
					}
				}
			}
			if(!valid){
				System.out.println(-1);
				continue;
			}
			String res = "";
			for(int i = 0; i < maxLength; i++){
				res += a[i];
			}
			//System.out.println((4 | 10) - (4 & 2));
			System.out.println(Long.parseLong(res,2));


		}
	}
}
