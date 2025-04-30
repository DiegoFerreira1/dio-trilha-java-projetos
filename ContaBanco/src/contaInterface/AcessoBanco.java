package contaInterface;
public class AcessoBanco {

    public static void main(String[] args) {
        
        Cliente diego = new Cliente();
        diego.setNome("Diego Ferreira");

        Conta cc = new ContaCorrente(diego);
        Conta poupanca = new ContaPoupanca(diego);

        cc.depositar(150);
        cc.transferir(100, poupanca);

        cc.imprimirExtrado();
        poupanca.imprimirExtrado();




    }
    
}
