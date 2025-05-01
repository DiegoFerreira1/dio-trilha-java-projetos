package contaBanco;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

public class Banco {
    private List<Conta> contas;

    public Banco (){
        contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta){
        contas.add(conta);
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há contas cadastradas.");
            return;
        }
    
        StringBuilder sb = new StringBuilder();
        
        
        for (Conta conta : contas) {
            sb.append("Conta: ").append(conta.getNumero())
              .append("\nTitular: ").append(conta.getClienteNome())
              .append("\nSaldo: R$ ").append(String.format("%.2f", conta.getSaldo()))
              .append("\n\n");  
        }   
        
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public Conta buscarContaPorCpf(String cpf) {
    Optional<Conta> conta = contas.stream()
        .filter(c -> c.getClienteCpf().equals(cpf))
        .findFirst(); 
    
    return conta.orElse(null); 

    }

    public boolean existeCpf(String cpf) {
        return contas.stream()
                     .anyMatch(c -> c.getClienteCpf().equals(cpf)); 
    }
    
    
    
    
}
