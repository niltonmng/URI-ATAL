import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Main m = new Main();
		Scanner sc = new Scanner(System.in);
	
		String s = sc.next();
		char[] chars = s.toCharArray();
		
		//m.quickSort(chars, 0, chars.length);
		
		
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(chars[i]+""+chars[j]);
			}
			System.out.println();
		}
				
	}
	
	public void quickSort(char[] vetor, int ini, int fim) {
		if(ini < fim) {
			int pos_pivot = particiona(vetor,ini,fim);
			quickSort(vetor, ini, pos_pivot - 1);
			quickSort(vetor, pos_pivot + 1, fim);
		}
	}

	private int particiona(char[] vetor, int ini, int fim) {
		// TODO Auto-generated method stub
		char pivot = vetor[ini];
		int i = ini;
		for (int j = ini + 1; j < vetor.length; j++) {
			if(vetor[j] < pivot) {
				i++;
				swap(vetor, i, j);
			}
		}
		swap(vetor, ini, i);
		return i;
	}

	private void swap(char[] entrada, int i, int j) {
		// TODO Auto-generated method stub
		char aux = entrada[i];
		entrada[i] = entrada[j];
		entrada[j] = aux;
	}
}
