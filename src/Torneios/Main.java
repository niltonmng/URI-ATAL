package Torneios;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	private static String check(int n, int m, int[] c) {
        Set<Integer> set = new HashSet<>();

        if (n == 2) {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= m; j++) {
                    int score = c[0] * i + c[1] * j;

                    if (set.contains(score)) {
                        return "Try again later, Denis...";
                    } else {
                        set.add(score);
                    }
                }
            }
        } 
        
        else if (n == 3) {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= m; j++) {
                    for (int k = 1; k <= m; k++) {
                        int score = c[0] * i + c[1] * j + c[2] * k;

                        if (set.contains(score)) {
                            return "Try again later, Denis...";
                        } else {
                            set.add(score);
                        }
                    }
                }
            }
        }

        return "Lucky Denis!";
    }
	
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n;
        int m;
        int[] c;

        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();

            c = new int[n];

            for (int i = 0; i < n; i++) {
                c[i] = scanner.nextInt();
            }

            System.out.println(check(n, m, c));
        }
    }
}