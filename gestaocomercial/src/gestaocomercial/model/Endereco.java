package gestaocomercial.model;

/**
 *
 * @author Freitas
 */
public class Endereco {
    private String estado;
    private String cidade;
    private String rua;
    private int numero;
    private String complemento;
    
    public Endereco(String estado, String cidade, String rua, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }
    
    
    
    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }
    
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
    public boolean alterarDados(Endereco endereco_alterado){
        setCidade(endereco_alterado.getCidade());
        setComplemento(endereco_alterado.getComplemento());
        setEstado(endereco_alterado.getEstado());
        setNumero(endereco_alterado.getNumero());
        setRua(endereco_alterado.getRua());
        
        return true;
    }
        
    public Endereco copy(){
        return new Endereco(getEstado(),
                getCidade(), getRua(),
                getNumero(), getComplemento());
    }
    
    @Override
    public String toString(){
        return "-- Endereço --"
                + "\nEstado: " + getEstado()
                + "\nCidade: " + getCidade()
                + "\nRua: " + getRua()
                + "\nNumero: " + getNumero()
                + "\nComplemento: " + getComplemento()
                + "\n";
    }
}
