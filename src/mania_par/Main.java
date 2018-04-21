package mania_par;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public int extractMin(LinkedList<Integer> q){
		int min = 0;
		for (int i = 1; i < q.size(); i++) {
			if(q.get(i) < q.get(min)){
				min = i;

			}
		}
		return q.remove(min);
	}
	
	public No busca(String nome, HashSet<No> set){
		for (No no : set) {
			if(no.nome.equals(nome)) return no;
		}
		throw new RuntimeException("Não Encontrado!");
	}

	public static void main(String[] args) {

		HashSet<No> nos = new HashSet<No>();
		
		Main m = new Main();
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		Integer[] cidades_estradas = {Integer.parseInt(entrada[0]), Integer.parseInt(entrada[1])};

		Integer c = cidades_estradas[1];
		Integer[][] nos_arestas = new Integer[c][3];   // matriz com os nós e os valores de suas arestas
		for (int i = 0; i < c; i++) {
			String[] nova = sc.nextLine().split(" ");
			nos_arestas[i][0] = Integer.parseInt(nova[0]);
			nos_arestas[i][1] = Integer.parseInt(nova[1]);
			nos_arestas[i][2] = Integer.parseInt(nova[2]);
			
			No n = new No();
			n.nome = nova[0];
			n.valor = 100;
			nos.add(n);
			
			
			No l = new No();
			l.nome = nova[1];
			l.valor = 1000;
			nos.add(l);
		}
		m.busca("1", nos).valor = 0;
		
		
		for (int i = 0; i < nos_arestas.length; i++) {
			No n = m.busca(nos_arestas[i][0].toString(), nos);
			No adj = m.busca(nos_arestas[i][1].toString(), nos);
			
			n.addAdj(adj);
		}
		
		for (No n : nos) {
			System.out.print(n.nome + "-> ");
			for (No adj : n.adjacentes) {
				System.out.print(adj.nome + " ");
			}
			System.out.println();
		}




	}
}

class No {
	
	String nome;
	Integer valor;
	HashSet<No> adjacentes = new HashSet<No>();
	
	public void addAdj(No novoNo){
		adjacentes.add(novoNo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		No other = (No) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}	
}


//Integer[][] matriz = new Integer[c][c];
//matriz[0][0] = 0;
//for (int i = 1; i < c; i++) {
//	matriz[i][i] = 100;
//}
//LinkedList<Integer> q = new LinkedList<Integer>();
//for (int i = 0; i < c; i++) {
//	q.add(matriz[i][i]); // adicionei os nós na lista.
//}