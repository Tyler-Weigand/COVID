import java.io.*;
import java.util.Scanner;

public class CoronaSolver {
	public String solve(String inputFileName) throws IOException{
		File text = new File(inputFileName);
		Scanner s = new Scanner(text);
		
		int days = s.nextInt();
		int flight = s.nextInt();
		int[] LA = new int[days];
		int[] NYC = new int[days];
		
		for(int i = 0; i < days; i++) {
			LA[i] = s.nextInt();
			NYC[i] = s.nextInt();
		}
		
		return "";
	}
}