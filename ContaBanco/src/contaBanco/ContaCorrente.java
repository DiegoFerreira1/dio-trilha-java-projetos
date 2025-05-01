package contaBanco;

import javax.swing.JOptionPane;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() { 
        tipoConta = "EXTRADO CONTA CORRENTE";     
        imprimirItensComuns();
    }
}
