package Fibonacci_PD;

import java.util.Scanner;

public class Main {
	
	int chamadasBase = 0;
	int chamadasRecursivas = 0;
	
	int fib(int valor){
		if(valor == 0){
			chamadasRecursivas++;
			return 0;			
		}
		if(valor == 1){
			chamadasBase++;
			chamadasRecursivas++;
			return 1;
		}
		else {
			chamadasRecursivas++;
			return fib(valor - 1) + fib(valor - 2);
		}
		
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		int n = sc.nextInt();
		while (i < n){
			m.chamadasBase = 0;
			m.chamadasRecursivas = 0;
			int entrada = sc.nextInt();
			m.fib(entrada);
			System.out.println("fib(" + entrada + ") = " + (m.chamadasRecursivas - 1) + " calls = " + m.chamadasBase);
			i++;
		}
		
	}
}
