package projetoPooBanco2;

// Conta Corrente permite cheque especial
class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(double saldo, double limite) {
        super(saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        if (saldo - valor >= -limite) {
            saldo -= valor;
            System.out.printf("Saque realizado: %.2f%n", valor);
        } else {
            System.out.println("Saque invalido: Excede limite");
        }
        exibirSaldo(); // Exibe o saldo atualizado
    }
}