package gestaocomercial.model;

import java.util.ArrayList;

/**
 *
 * @author Freitas
 */
public class Cliente {
    private int codigo;
    private String CPF;
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Endereco> enderecos;
    private double saldo;

//    public Cliente(int codigo, String CPF, String email) {
//        this.codigo = codigo;
//        this.CPF = CPF;
//        this.email = email;
//    }
    
    public Cliente(int codigo, String CPF, String nome, String email, String senha, ArrayList<Endereco> enderecos, double saldo) {
        this.codigo = codigo;
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.enderecos = enderecos;
        this.saldo = saldo;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public ArrayList<Endereco> getEnderecos() {
        // retornar cópia dos endereços
        ArrayList<Endereco> copia_enderecos = new ArrayList<>();
        for(Endereco endereco : this.enderecos){
            copia_enderecos.add(endereco);
        }
        return copia_enderecos;
    }

    public double getSaldo() {
        return saldo;
    }
    

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public boolean alterarDados(Cliente cliente_alterado){
        if(cliente_alterado.getCodigo() != getCodigo())
            return false;
        
        setNome(cliente_alterado.getNome());
        setCPF(cliente_alterado.getCPF());
        setEmail(cliente_alterado.getEmail());
        setEnderecos(cliente_alterado.getEnderecos());
        setSaldo(cliente_alterado.getSaldo());
        setSenha(cliente_alterado.getSenha());        
        
        return true;
    }
    
    public Cliente copy(){
        return new Cliente(getCodigo(), getCPF(), 
            getNome(), getEmail(), getSenha(),
            getEnderecos(), getSaldo()
        );
    }
    
    @Override
    public String toString(){
        return "-- Cliente --"
                + "\nCódigo: " + getCodigo()
                + "\nNome: " + getNome()
                + "\nE-mail: " + getEmail()
                + "\nCPF: " + getCPF()
                + "\nSenha: " + getSenha()
                + "\nSaldo: " + getSaldo()
                + "\nEndereços:\n" + getEnderecos()
                + "\n\n";
    }
}
