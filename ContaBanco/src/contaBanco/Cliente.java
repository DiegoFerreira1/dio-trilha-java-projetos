package contaBanco;

public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf ){
        this.nome = nome;       
        this.cpf = cpf;
    }

    public String getNome(){return nome;}    
    public void setNome(String newNome){this.nome = newNome;}

    public String getCpf(){return cpf;}
    public void setCpf(String cpf){this.cpf = cpf;
    }

    
}
