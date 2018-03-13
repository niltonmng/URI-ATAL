package LCS_Wesley;

import java.util.Scanner;

public class Main {
	public static int lcs(String x, String y, int k) {
        int[][] tabela = new int[x.length() + 1][y.length() + 1];

        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                int n = 0;
                tabela[i][j] = Math.max(tabela[i - 1][j], tabela[i][j - 1]);

                while (i - 1 - n >= 0 && j - 1 - n >= 0 && x.charAt(i - 1 - n) == y.charAt(j - 1 - n)) {
                    n++;
                }

                if (n >= k) {
                    for (int p = k; p <= n; p++) {
                        tabela[i][j] = Math.max(tabela[i][j], tabela[i - p][j - p] + p);
                    }
                }
            }
        }

        return tabela[x.length()][y.length()];
    }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int k = 1;
    while (k != 0){
		k = in.nextInt();
		if(k == 0) break;
		in.nextLine();
		String x = in.nextLine();
		String y = in.nextLine();
		System.out.println(lcs(x, y, k));
	} 
  }
}
