package ComercioVinhos;

import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		while(n != 0) {
			
			int sum = 0;
			int[] aux = new int[n];
			String[] array = sc.nextLine().split(" ");

			for (int i = 0; i < array.length; i++) {
				int elemento = Integer.parseInt(array[i]);
				aux[i] = elemento;
			}
			
			for (int i = 0; i < aux.length-1; i++) {
				if(aux[i] < 0) {
					int mudaSinal = aux[i]*(-1);
					sum += mudaSinal;
				}
				else {
					int sumAnt = sum;
					int sumMed = sumAnt - aux[i];
					sum = sumAnt + sumMed;
				}
			}
			
			System.out.println(sum);
			n = Integer.parseInt(sc.nextLine());
		}
	}

}
