package ParafusosEPorcas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		
		
		int n = Integer.parseInt(sc.nextLine());
		String[] array = new String[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextLine();
		}
		int buscado = Integer.parseInt(sc.nextLine());
		
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			String[] aux = array[i].split(" ");
			for (int j = Integer.parseInt(aux[0]); j <= Integer.parseInt(aux[aux.length-1]); j++) {
				a.add(j);
			}
		}
		m.bubbleSort(a);
		
		int inicio = -1;
		int fim = -1;
		for (int i = 0; i < a.size(); i++) {
			if(buscado == a.get(i)) {
				inicio = i;
				break;
			}
				
		}
		for (int i = 0; i < a.size(); i++) {
			if(buscado == a.get(i)) 
				fim = i;
		}
		
		if((inicio > -1) && (fim > -1)) 
			System.out.println(buscado + " found from " + inicio + " to " + fim);
		else 
			System.out.println(buscado + " not found");
		
	}
	
	public void bubbleSort(ArrayList<Integer> array) {
		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array.size(); j++) {
				if(array.get(i) < array.get(j)) {
					swap(array, i, j);
				}
			}
		}
	}
	
	public void swap(ArrayList<Integer> array, int i, int j) {
		int aux = array.get(i);
		array.set(i, array.get(j));
		array.set(j, aux);
	}

}