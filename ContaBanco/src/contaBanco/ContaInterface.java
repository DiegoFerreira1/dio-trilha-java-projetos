package contaBanco;

public interface ContaInterface {
    public void depositar(double valor);
    public void sacar(double valor);
    public boolean transferir(Conta contaDestino, double valor);
    public void imprimirExtrato();
    
}