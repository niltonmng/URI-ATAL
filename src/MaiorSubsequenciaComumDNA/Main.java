package MaiorSubsequenciaComumDNA;

import java.util.Scanner;

public class Main {
	
	
	public int max(int x, int y) {
		if(x > y) return x;
		else return y;
	}
	
	public int largestCommonSubsequence(String x, String y) {
		int m = x.length();
		int n = y.length();
		int[][] matriz = new int[m+1][n+1];
		
		for (int i = 0; i <= m; i++) {
			matriz[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			matriz[0][i] = 0;
		}
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(x.charAt(i) == y.charAt(j))
					matriz[i][j] = matriz[i-1][j-1] + 1;
				else
					matriz[i][j] = max(matriz[i-1][j], matriz[i][j-1]);
			}
		}
		return matriz[m][n];
	}

	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		
		String x = sc.nextLine();
		String y = sc.nextLine();
		
		System.out.println(m.largestCommonSubsequence(x, y));
		
		
	}
}
