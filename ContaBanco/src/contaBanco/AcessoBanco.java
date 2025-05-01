package contaBanco;

import javax.swing.JOptionPane;

public class AcessoBanco {
    
    public static void main(String[] args) {
        String opcao;
        String nome;
        String cpf;
     
        Banco banco = new Banco();

        while (true) {
            opcao = JOptionPane.showInputDialog("Escolha uma opção:\n" +
                "1. Abrir conta corrente\n" +
                "2. Abrir conta poupança\n" +
                "3. Listar contas\n" +
                "4. Depositar dinheiro\n" +
                "5. Transferir dinheiro\n" +
                "6. Sair do sistema");

            switch (opcao) {
                case "1":
                    nome = JOptionPane.showInputDialog("Informe o nome do cliente:");
                    cpf = JOptionPane.showInputDialog("Informe o CPF do cliente:");
                
                    
                    if (banco.existeCpf(cpf)) {
                        JOptionPane.showMessageDialog(null, "Já existe uma conta cadastrada com esse CPF!");
                    } else {
                        Cliente novoCliente = new Cliente(nome, cpf);
                        Conta novaConta = new ContaCorrente(novoCliente);
                        banco.adicionarConta(novaConta);
                        JOptionPane.showMessageDialog(null, "Conta corrente criada com sucesso!");
                    }
                    break;

                case "2":
                    nome = JOptionPane.showInputDialog("Informe o nome do cliente:");
                    cpf = JOptionPane.showInputDialog("Informe o CPF do cliente:");
                
                    
                    
                    if (banco.existeCpf(cpf)) {
                        JOptionPane.showMessageDialog(null, "Já existe uma conta cadastrada com esse CPF!");
                    } else {
                        Cliente novoCliente = new Cliente(nome, cpf);
                        Conta novaConta = new ContaPoupanca(novoCliente);
                        banco.adicionarConta(novaConta);
                        JOptionPane.showMessageDialog(null, "Conta poupança criada com sucesso!");
                    }
                    break;

                case "3":
                    banco.listarContas();
                    break;

                case "4":
                    String cpfdepositador = JOptionPane.showInputDialog("Informe o CPF do cliente:");
                    Conta contaDeposito = banco.buscarContaPorCpf(cpfdepositador);
                    double valorDeposito = 0.0;
                    if (contaDeposito != null){
                        valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser depositado:"));
                        contaDeposito.depositar(valorDeposito);
                        JOptionPane.showMessageDialog(null, "Depósito de R$ " + valorDeposito + " realizado com sucesso!");                         
                                             
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Conta nao encontrada nesse cpf!");
                    }                   
                    
                    break;

                case "5":
                    
                    String cpfTransferidor = JOptionPane.showInputDialog("Informe o CPF do transferidor:");
                    String cpfDestinatario = JOptionPane.showInputDialog("Informe o CPF do destinatário:");
                    double valorTransferencia = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser transferido:"));
                
                    
                    Conta contaTransferidor = banco.buscarContaPorCpf(cpfTransferidor);
                    Conta contaDestinatario = banco.buscarContaPorCpf(cpfDestinatario);
                
                    if (contaTransferidor != null && contaDestinatario != null) {
                        if (contaTransferidor.transferir(contaDestinatario, valorTransferencia)) {
                            JOptionPane.showMessageDialog(null, "Transferência de R$ " + valorTransferencia + " realizada com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente na conta do transferidor!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Uma das contas não foi encontrada!");
                    }
                    break; 

                case "6":
                    int resposta = JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente sair do sistema?", 
                        "Confirmar saída", 
                        JOptionPane.YES_NO_OPTION
                    );
                
                    if (resposta == JOptionPane.YES_OPTION) {                        
                        System.exit(0); 
                    } 
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        }
    }
}
