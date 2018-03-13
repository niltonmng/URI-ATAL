package SacoPapaiNoel_PD;

import java.util.Scanner;

public class Main {
	
	public int max(int x, int y){
		if(x > y) return x;
		else return y;
	}	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		int pesoMax = 50;// peso maximo restrito pela questao da mochila binaria
		
		int viagens = Integer.parseInt(sc.nextLine());
		int cont = 0;
		while(true) {
			if(cont == viagens) break;
			
			String qtdPacotes = sc.nextLine(); // objetos da mochila binaria

			// armazena os pacotes por viagem
			String[] pacotes = new String[Integer.parseInt(qtdPacotes)];
			for (int i = 0; i < Integer.parseInt(qtdPacotes); i++) {
				String entrada = sc.nextLine();
				pacotes[i] = entrada;
			}
			
			// separa os pesos e os valores
			int[] brinquedos = new int[Integer.parseInt(qtdPacotes)+1]; // foi necessario criar um elemento inicial(zero) para que o primeiro elemento tenha zero brinquedos
			brinquedos[0] = 0;
			int[] pesos = new int[Integer.parseInt(qtdPacotes)+1]; // foi necessario criar um elemento inicial(zero) para que o primeiro elemento tenha zero peso
			pesos[0] = 0;
			for (int i = 1; i <= Integer.parseInt(qtdPacotes); i++) {
				String[] quebra = pacotes[i-1].split(" ");
				brinquedos[i] = Integer.parseInt(quebra[0]);
				pesos[i] = Integer.parseInt(quebra[1]);
			}
						
			// KNAPSACK BINARIA --------------------------------------------------------------------------------
			
			int[][] tabela = new int[Integer.parseInt(qtdPacotes)+1][pesoMax+1];
			// zerando primeira linha
			for (int i = 0; i < pesoMax+1; i++) {
				tabela[0][i] = 0;
			}
			// zerando primeira coluna
			for (int i = 0; i < Integer.parseInt(qtdPacotes)+1; i++) {
				tabela[i][0] = 0;
			}
			
			for (int i = 1; i <= Integer.parseInt(qtdPacotes); i++) {
				for (int j = 1; j <= pesoMax; j++) {
					if(pesos[i] > j)
						tabela[i][j] = tabela[i-1][j];
					else{
						tabela[i][j] = m.max(tabela[i-1][j-pesos[i]] + brinquedos[i], tabela[i-1][j]);					
					}
						
				}
			}
			
			// fim da knapsack binaria --------------------------------------------------------------------------
			
			int pesoFinal = 0;
			for (int j = 1; j <= pesoMax; j++) {
				if(tabela[Integer.parseInt(qtdPacotes)][j] == tabela[Integer.parseInt(qtdPacotes)][pesoMax]){
					pesoFinal = j;
					break;
				}
			}
			
			// FALTA ENCONTRAR A QUANTIDADE DE PACOTES QUE SOBRAM.
			int pacotesSobram = 0;
			
			System.out.println(tabela[Integer.parseInt(qtdPacotes)][pesoMax] + " brinquedos");
			System.out.println("Peso: " + pesoFinal + " kg");
			System.out.println("sobra(m) " + pacotesSobram  + " pacote(s)");
			
			cont++;
		}
		
		
		
	}

}