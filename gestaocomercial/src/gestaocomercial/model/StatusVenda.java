package gestaocomercial.model;

/**
 *
 * @author Freitas
 */
public enum StatusVenda {
    PENDENTE ("Pendente"), ANDAMENTO ("Em andamento"), ENTREGUE ("Entregue");
    
    private final String nome_imprimivel;
    
    private StatusVenda(String s){
        this.nome_imprimivel = s;
    }
    
    @Override
    public String toString(){
        return this.nome_imprimivel;
    }
}
