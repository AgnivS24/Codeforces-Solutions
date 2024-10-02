// Source: https://usaco.guide/general/io
 
import java.io.*;
import java.util.*;
 
public class BitGuessingGame {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		//System.out.println(Integer.toBinaryString(1000000000));
outer:  while(T-- > 0){
			String s = "";
			int setBits = sc.nextInt();
			int prev = setBits;
			int orig = setBits;
			if(true){
				int ones = 0;
				int ops = 1;
				s = "1";
				String ans = "";
				int setBitsONE = setBits;
				int answer = -1;
				//System.out.println("Now setBits is " + setBits);
				while(setBits > 0){
					if(ones == setBitsONE){
						answer = (Integer.parseInt(ans,2));
						break;
					}
					System.out.println("- " + Integer.parseInt(s,2));
					System.out.flush();
					setBits = sc.nextInt();
					//System.out.println("got " + setBits + " where previous is " + prev);
					//System.out.println("Now setBits is " + setBits);
					if(setBits == prev - 1){
						// This bit must be a 1
						ans = "1" + ans;
						ones++;
						s = "1" + "0".repeat(ans.length());
					}
					else{
						// Some number of bits must be zeroes
						// If last k bits are zeroes then setBits - prev is k - 1
						int k = setBits - prev + 1;
						ans = "1" + "0".repeat(k) + ans;
						ones++;
						/*
						if(prev == 1){
							ans = "1" + "0".repeat(k);
							break;
						} */
						s = "1" + "0".repeat(ans.length());
					}
					prev = setBits;
					//System.out.println("Now ans is " + ans);
				}
				System.out.println("! " + (Integer.parseInt(ans,2)));
				System.out.flush();
			}
		}
	}
}