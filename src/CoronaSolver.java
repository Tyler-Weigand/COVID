import java.util.*;

public class CoronaSolver {
	public static void main(String [] args) {
		int days;
		int flight;
		int[] LA;
		int[] NYC;

		int[][] opt = new int[2][days];
		opt[0][0] = LA[0];
		opt[1][0] = NYC[0];
		for (int i = 1; i<days; i++) {
			if ((opt[1][i-1] + NYC[i] + flight) < (opt[0][i-1] + LA[i])) {
				opt[0][i] = opt[1][i-1] + NYC[i] + flight;
			} else {
				opt[0][i] = opt[0][i-1] + LA[i];
			}
			if ((opt[0][i-1] + LA[i] + flight) < (opt[1][i-1] + NYC[i])) {
				opt[1][i] = opt[0][i-1] + LA[i] + flight;
			} else {
				opt[1][i] = opt[1][i-1] + NYC[i];
			}
		}
		if(opt[0][days-1] < opt[1][days-1]) {
			System.out.println(opt[0][days-1]);
			return (opt[0][days-1]);
		} else {
			System.out.println(opt[1][days-1]);
			return (opt[1][days-1]);
		}
	}
}