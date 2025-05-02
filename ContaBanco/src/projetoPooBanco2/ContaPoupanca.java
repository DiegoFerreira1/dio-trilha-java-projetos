package projetoPooBanco2;

// Conta Poupança não permite saldo negativo
class ContaPoupanca extends Conta {

    public ContaPoupanca(double saldo) {
        super(saldo);
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.printf("Saque realizado: %.2f%n", valor);
        } else {
            System.out.println("Saque invalido: Saldo insuficiente");
        }
        exibirSaldo(); // Exibe o saldo atualizado
    }
}