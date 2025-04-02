/*
1. informa o saldo inicial
2. informa um deposito
3. informa um saque
4. informa um saque
*/

import java.util.Scanner;

public class DesafioUm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada do saldo inicial
        double saldoInicial = scanner.nextDouble();

        // Entrada das três transações
        double transacao1 = scanner.nextDouble();
        double transacao2 = scanner.nextDouble();
        double transacao3 = scanner.nextDouble();

        // Cálculo do saldo final
        double saldoFinal = saldoInicial + transacao1 + transacao2 + transacao3;

        // Saldo final
        System.out.printf("%.2f\n", saldoFinal);

        scanner.close();
    }
}
