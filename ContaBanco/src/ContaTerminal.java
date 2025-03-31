import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
 

        System.out.println("----------Bem Vindo ao Banco DIO-----------");
        System.out.println("-------------------------------------------");

        System.out.println("\nPor favor, digite o número da Conta: ");
        int numeroConta = scanner.nextInt();
        
        System.out.println("\nAgora preciso que informe Agência: ");
        String agenciaConta = scanner.next();

        scanner.nextLine(); 
        System.out.println("\nPor favor, informe seu nome: ");
        String nomeCliente = scanner.nextLine();

        System.out.println("\nPor fim, digite o valor do saldo de depósito: ");
        double saldoConta = scanner.nextDouble();
       
        System.out.println("\nOlá " + nomeCliente + ", obrigado por criar uma conta em nosso banco." + 
        "\nAgência: " + agenciaConta + 
        "\nConta: " + numeroConta + 
        "\nSaldo: R$ " + saldoConta);      
        
        scanner.close();
    }
}

