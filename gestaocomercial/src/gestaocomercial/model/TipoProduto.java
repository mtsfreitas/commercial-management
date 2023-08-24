package gestaocomercial.model;

/**
 *
 * @author Freitas
 */
public enum TipoProduto {
    CD ("CD"), DVD ("DVD"), LIVRO ("Livro"), JOGO ("Jogo");
    
    private final String nome_imprimivel;
    
    private TipoProduto(String s){
        this.nome_imprimivel = s;
    }
    
    @Override
    public String toString(){
        return this.nome_imprimivel;
    }
}
