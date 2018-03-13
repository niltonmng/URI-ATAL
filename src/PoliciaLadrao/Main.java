package PoliciaLadrao;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Main m = new Main();
		Scanner sc = new Scanner(System.in);
		
		String n = sc.nextLine();
		int rept = Integer.parseInt(n);
		
		if((rept >= 1) && (rept <= 400)) {
			for (int j = 0; j < rept; j++) {
				String[] entrada = new String[5];
				
				int i = 0;
				while(i < 5) {
					String linha = sc.nextLine();
					entrada[i] = linha;
					i++;
				}
				
				int[][] labirinto = m.transforma(entrada);
				System.out.println(m.cops_robbers(labirinto));
			}			
		}		
	}
	
	public String cops_robbers(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			int get_i = get_index_i(array, 0, i);
			if(get_i == 4) {
				int get_j = get_index_j(array, 4, i) + i;
				if(get_j == 4) {
					return "COPS";
				}
			}
		}
		return "ROBBERS";
	}
	
	public int get_index_i(int[][] array, int i, int j) {
		if(i >= 4) return i;
		if(array[i][j] == 0) {
			i++;
			return get_index_i(array,i,j);
		}
		else return --i;
	}
	
	public int get_index_j(int[][] array, int i, int j) {
		if(i >= 4) return j;
		if(array[i][j] == 0) {
			j++;
			return get_index_j(array,i,j);
		}
		else return --j;
	}

	public int[][] transforma(String[] array) {
		int[][] saida = new int[array.length][array.length];
		for (int i = 0; i < saida.length; i++) {
			String[] linha = array[i].split(" ");
			for (int j = 0; j < linha.length; j++) {
				saida[i][j] = Integer.parseInt(linha[j]);
			}
		}
		return saida;
	}
	
}
