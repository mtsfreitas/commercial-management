package gestaocomercial.model;

/**
 *
 * @author Freitas
 */
public class Produto {
    private int codigo;
    private String descricao;
    private int qtd_estoque;
    private String categoria;
    private TipoProduto tipo_produto;
    private String particularidade;
    private double preco;

//    public Produto(int codigo) {
//        this.codigo = codigo;
//    }
    
    public Produto(int codigo, String descricao, int qtd_estoque, 
            String categoria, TipoProduto tipo_produto, String particularidade,
            double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.qtd_estoque = qtd_estoque;
        this.categoria = categoria;
        this.tipo_produto = tipo_produto;
        this.particularidade = particularidade;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQtdEstoque() {
        return qtd_estoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public TipoProduto getTipoProduto() {
        return tipo_produto;
    }

    public String getParticularidade() {
        return particularidade;
    }
    
    public double getPreco(){
        return preco;
    }
    
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQtdEstoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTipoProduto(TipoProduto tipo_produto) {
        this.tipo_produto = tipo_produto;
    }

    public void setParticularidade(String particularidade) {
        this.particularidade = particularidade;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    
    public boolean alterarDados(Produto produto_alterado){
        if(produto_alterado.getCodigo() != getCodigo())
            return false;
        
        setCategoria(produto_alterado.getCategoria());
        setDescricao(produto_alterado.getDescricao());
        setParticularidade(produto_alterado.getParticularidade());
        setPreco(produto_alterado.getPreco());
        setQtdEstoque(produto_alterado.getQtdEstoque());
        setTipoProduto(produto_alterado.getTipoProduto());
        
        return true;
    }
    
    public Produto copy(){
        return new Produto(getCodigo(), getDescricao(), getQtdEstoque(), getCategoria(),
            getTipoProduto(), getParticularidade(), getPreco());
    }
    
    @Override
    public String toString(){
        return "-- Produto --"
                + "\nCódigo: " + getCodigo()
                + "\nCategoria: " + getCategoria()
                + "\nTipo: " + getTipoProduto()
                + "\nDescrição: " + getDescricao()
                + "\nParticularidade: " + getParticularidade()
                + "\nPreço unitário: " + getPreco()
                + "\nQuantidade em estoque: " + getQtdEstoque()
                + "\n\n";
    }
}
