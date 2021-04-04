package model;

public class ClienteModel {
    
    private int idCliente;
    private String nome;
    private String cpf;
    private String email;
    
    public ClienteModel (int idCliente, String nome, String cpf, String email){
        
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        
    }
    
    public ClienteModel (String nome, String cpf, String email){
        
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setIdCliente(int id){
       this.idCliente = id;
    }
    
    public void setNome(String n){
        this.nome = n;
    }
    
    public void setCpf(String c){
        this.cpf = c;
    }
    
    public void setEmail(String e){
        this.email = e;
    }
    
    
}
