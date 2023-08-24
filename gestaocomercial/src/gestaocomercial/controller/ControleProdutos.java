package gestaocomercial.controller;

import gestaocomercial.model.Produto;
import java.util.ArrayList;

/**
 *
 * @author Freitas
 */
public class ControleProdutos {

    private ArrayList<Produto> produtos;
    
    public ControleProdutos(){
        produtos = new ArrayList<>();
    }
    
    public Produto getProduto(int codigo){
        for(Produto produto : produtos){
            if(produto.getCodigo() == codigo){
                return produto;
            }
        }
        
        return null;
    }
    
    public String cadastrarProduto(Produto novo_produto){
        for(Produto produto : produtos){
            if(produto.getCodigo() == novo_produto.getCodigo()){
                return "Erro: Já existe um produto cadastrado com este mesmo código.";
            }
        }
        
        produtos.add(novo_produto);
        
        return "Produto cadastrado com sucesso!";
    }
    
    public String alterarDadosProduto(Produto produto_alterado){
        Produto produto_encontrado = null;
        for(Produto produto : produtos){
            if(produto.getCodigo() == produto_alterado.getCodigo()){
                produto_encontrado = produto;
                break;
            }
        }
        
        if(produto_encontrado == null)
            return "Erro: Produto não encontrado.";
        
        produto_encontrado.alterarDados(produto_alterado);
        
        return "Os dados do produto de código " + produto_alterado.getCodigo() + " foram alterados com sucesso!";
    }
    
    public ArrayList<Produto> getProdutos(String filtro_nome){
        ArrayList<Produto> copia_produtos = new ArrayList<>();
        
        if(filtro_nome == null || filtro_nome.isEmpty()){
            for(Produto produto : produtos){
                copia_produtos.add(produto);
            }
        } else{
            for(Produto produto : produtos){
                if(produto.getDescricao().contains(filtro_nome))
                    copia_produtos.add(produto);
            }
        }
        
        return copia_produtos;
    }
    
    public boolean atualizarEstoque(int cod_produto, int nova_quantidade){
        if(nova_quantidade < 0)
            return false;
        for(Produto produto : produtos){
            if(produto.getCodigo() == cod_produto){
                produto.setQtdEstoque(nova_quantidade);
                return true;
            }
        }
        return false;
    }
    
}
