package projetoPooBanco;

class Conta {    
    // TODO: Implemente os atributos privados para garantir que só podem ser acessados dentro da classe:
    private String titular;
    private int numeroConta;
    private double saldoInicial;
    
    public String getTitular(){
      return this.titular;
    }
    public void setTitular(String titular){
      this.titular = titular;
    }
    
    public int getNumeroConta(){
      return this.numeroConta;
    }
    public void setNumeroConta(int numeroConta){
      this.numeroConta = numeroConta;
    }
    
    public double getSaldoInicial(){
      return this.saldoInicial;
    }
    public void setSaldoInicial(double saldoInicial){
      this.saldoInicial = saldoInicial;
    }
    
    // TODO: Crie o construtor para inicializar os atributos da conta:
   public Conta(String titular, int numeroConta, double saldoInicial) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldoInicial = saldoInicial;
    }

    // TODO: Adicione o método público para consultar o saldo:
    public double consultarSaldo() {
        return this.saldoInicial;
    }
    

    // TODO: Adicione o método público para realizar saque:
    public boolean sacar(double valorSaque) {
        if (valorSaque > saldoInicial) {
            return false;
        }
        saldoInicial -= valorSaque;
        return true;
    }
    // TODO: Crie o método público para realizar depósito
    public void depositar(double valorDeposito){
        this.saldoInicial += valorDeposito;
        }
}