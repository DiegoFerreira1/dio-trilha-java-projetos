package contador;
import java.util.Scanner;
import exception.ParametrosInvalidosException;

public class Contador {
	public static void main(String[] args) {
        
		Scanner scan = new Scanner(System.in);

        System.out.println("Por favor, digite o primeiro número: ");
        int primeiroNumero = scan.nextInt();

        System.out.println("Por favor, agora digite o segundo número: ");
        int segundoNumero = scan.nextInt();
	
		try {
			//chamando o método contendo a lógica de contagem
			contar(primeiroNumero, segundoNumero);
		
		}catch (ParametrosInvalidosException exception) {			
            System.out.println("Erro: " + exception.getMessage());
		}

        scan.close();
		
	} // main
    
	static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
		if (parametroUm > parametroDois){
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }		
		int contagem = parametroDois - parametroUm;	        	
        for (int i = 1; i <= contagem; i++){
            System.out.println("Imprimindo o número " + i);
        }
	}
} //class