import java.util.Scanner;

public class Mainn {
	
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        char[] array = {'N','O','N','P','N','O','P','N','P','O','N','O','P'};
        
        
        while(true) {
        	int n = sc.nextInt();
        	
        	if(n == 0) {
        		System.out.println();
        		break;
        	}
        	
            char[] novo = new char[n];
        	
        	for (int i = 0; i < novo.length; i++) {
    			novo[i] = array[i % array.length];
    		}
        	
        	for (int i = 0; i < novo.length; i++) {
    			System.out.print(novo[i]);
    		}
        }
	}
}