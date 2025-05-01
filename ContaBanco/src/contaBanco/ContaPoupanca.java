package contaBanco;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() { 
        tipoConta = "EXTRADO CONTA POUPANÇA";     
        imprimirItensComuns();
    }

}
