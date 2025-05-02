package projetoPooBanco2;
import java.util.Scanner;

// Classe principal
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tipoConta = scanner.next(); // Corrente ou Poupanca
        scanner.nextLine(); // Ignora o nome (linha extra)
        scanner.nextLine(); // Ignora o número da conta (linha extra)
        scanner.next();     // Ignora de novo o número da conta (linha extra se sobrou)
        double saldoInicial = scanner.nextDouble();

        Conta conta;

        if (tipoConta.equalsIgnoreCase("Corrente")) {
            double limite = scanner.nextDouble();
            conta = new ContaCorrente(saldoInicial, limite);
        } else if (tipoConta.equalsIgnoreCase("Poupanca")) {
            conta = new ContaPoupanca(saldoInicial);
        } else {
            System.out.println("Tipo de conta inválido.");
            scanner.close();
            return;
        }

        while (scanner.hasNextDouble()) {
            double valorSaque = scanner.nextDouble();
            conta.sacar(valorSaque);
        }

        scanner.close();
    }
}

/*
Entrada	Saída
Corrente
Joao
123
100.00
200.00
150.00	
Saque realizado: 150.00
Saldo Atual: -50.00

Corrente
Maria
456
100.00
50.00
200.00	
Saque invalido: Excede limite
Saldo Atual: 100.00

Poupanca
Carlos
789
50.00
60.00	Saque invalido: Saldo insuficiente
Saldo Atual: 50.00 */