import java.io.*;
import java.util.Scanner;

public class CoronaSolver {
	public static void main (String [] args) throws IOException{
		System.out.println(solve("bigtest.txt"));
	}
	public static String solve(String inputFileName) throws IOException{
		File text = new File(inputFileName);
		Scanner s = new Scanner(text);
		
		int days = s.nextInt();
		int flight = s.nextInt();
		int[] LA = new int[days];
		int[] NYC = new int[days];
		String laPath = "L";
		String nyPath = "N";
		
		for(int i = 0; i < days; i++) {
			LA[i] = s.nextInt();
			NYC[i] = s.nextInt();
		}

		int[][] opt = new int[2][days];
		opt[0][0] = LA[0];
		opt[1][0] = NYC[0];
		for (int i = 1; i<days; i++) {
			String temp = laPath;
			if ((opt[1][i-1] + flight) < (opt[0][i-1])) {
				opt[0][i] = opt[1][i-1] + LA[i] + flight;
				laPath = nyPath + "L";
			} else {
				opt[0][i] = opt[0][i-1] + LA[i];
				laPath += "L";
			}
			if ((opt[0][i-1] + flight) < (opt[1][i-1])) {
				opt[1][i] = opt[0][i-1] + NYC[i] + flight;
				nyPath = temp + "N";
			} else {
				opt[1][i] = opt[1][i-1] + NYC[i];
				nyPath += "N";
			}
		}
		
		
		if(opt[0][days-1] < opt[1][days-1]) {
			return Integer.toString((opt[0][days-1])) + "\n" + laPath;
		} else {
			return Integer.toString((opt[1][days-1])) + "\n" + nyPath;
		}
		
	}
}