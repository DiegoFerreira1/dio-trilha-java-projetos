package contaBanco;

import javax.swing.JOptionPane;

public abstract class Conta implements ContaInterface {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected String tipoConta;
    protected Cliente cliente;

    //Construtor padrao
    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.saldo = 0.0;
        this.cliente = cliente;
    }

    //metodos get 
    public int getAgencia(){return agencia;}
    public int getNumero(){return numero;}
    public double getSaldo(){return saldo;}
    public String getClienteNome(){return cliente.getNome();}
    public String getClienteCpf(){return cliente.getCpf();}
    

    //Metodos da interface
    @Override
    public void depositar(double valor) {
        if (valor > 0){
            saldo += valor;            
        }
        else{
            JOptionPane.showMessageDialog(null, "Valor inválido para depósito.");
        }
    }
    @Override
    public void sacar(double valor) {
        if (valor <= saldo && valor > 0){
            saldo -= valor;            
        }
        else{
            JOptionPane.showMessageDialog(null, "Saldo insuficiente ou valor inválido para saque.");
        }
        
    }
    @Override
    public boolean transferir(Conta contaDestino, double valor) {
        if (this.saldo >= valor && valor > 0) {
            this.saldo -= valor; // Subtrai o valor da conta de origem
            contaDestino.depositar(valor); // Adiciona o valor à conta de destino
            return true;
        } else {
            return false;
        }
    }
    

    protected void imprimirItensComuns() {
        JOptionPane.showMessageDialog(null, this.tipoConta + 
        String.format("Titular: ", this.cliente.getNome()) +
        String.format("\nAgência: %d ",this.agencia) +
        String.format("\nNúmero %d ",this.numero) +
        String.format("\nSaldo %.2f" , this.saldo)

        );
    }   
   
}

