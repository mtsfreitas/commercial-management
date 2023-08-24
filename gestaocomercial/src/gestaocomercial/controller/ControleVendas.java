package gestaocomercial.controller;

import gestaocomercial.model.Par;
import gestaocomercial.model.Produto;
import gestaocomercial.model.StatusVenda;
import gestaocomercial.model.Venda;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Freitas
 */
public class ControleVendas {

    private ArrayList<Venda> vendas;
    
    public ControleVendas(){
        vendas = new ArrayList<>();
    }
    
    public Venda getVenda(int codigo){
        for(Venda venda : vendas){
            if(venda.getCodigo() == codigo){
                return venda;
            }
        }
        
        return null;
    }
    
    public Par<Boolean, String> efetuarVenda(Venda venda_criada, ControleProdutos controleProdutos){
        if(venda_criada == null)
            return new Par<>(false, "Venda nula/inválida!");
        
        for(Venda venda : vendas){
            if(venda.getCodigo() == venda_criada.getCodigo()){
                return new Par<>(false, "Erro: Já existe uma venda cadastrada com este mesmo código.");
            }
        }
        
        ArrayList<Par<Produto, Integer>> produtos_vendidos = venda_criada.getProdutosVendidos();
        for(Par<Produto, Integer> produto_vendido : produtos_vendidos){
            if(verificarEstoque(produto_vendido.first, produto_vendido.second) == false){
                return new Par(false, "Erro: O produto " + produto_vendido.first.getDescricao() + " (" + produto_vendido.first.getCodigo() + 
                        ") possui apenas " + produto_vendido.first.getQtdEstoque() + " unidades em estoque.");
            }
        }
        for(Par<Produto, Integer> produto_vendido : produtos_vendidos){
            atualizarEstoque(produto_vendido.first, produto_vendido.second, controleProdutos);
        }
        venda_criada.setProdutosVendidos(produtos_vendidos);
        vendas.add(venda_criada);
        return new Par<>(true, "Venda efetuada com sucesso!");
    }
    
    private boolean verificarEstoque(Produto produto, int qtd_vendido){
        int qtd_estoque_produto = produto.getQtdEstoque();
        
        if(qtd_estoque_produto >= qtd_vendido){
            return true;
        }
        return false;
    }
    
    private boolean atualizarEstoque(Produto produto, int qtd_vendido, ControleProdutos controleProdutos){
        int qtd_estoque_produto = produto.getQtdEstoque();
        
        if(qtd_estoque_produto >= qtd_vendido){
//            produto.setQtdEstoque(qtd_estoque_produto - qtd_vendido);
            return controleProdutos.atualizarEstoque(produto.getCodigo(), qtd_estoque_produto - qtd_vendido);
        }
        return false;
    }
    
    public boolean alterarStatusVenda(int codigo, StatusVenda novo_statusVenda){
        for(Venda venda : vendas){
            if(venda.getCodigo() == codigo){
                venda.setStatus(novo_statusVenda);
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Venda> getVendas(Date filtro_data_inicio, Date filtro_data_termino){
        ArrayList<Venda> copia_vendas = new ArrayList<>();
        
        if(filtro_data_termino == null)
            filtro_data_termino = new Date();
        
        for(Venda venda : vendas){
            if(venda.getDataVenda().compareTo(filtro_data_termino) <= 0){
                if(filtro_data_inicio == null){
                    copia_vendas.add(venda);
                } else{
                    if(venda.getDataVenda().compareTo(filtro_data_inicio) >= 0){
                        copia_vendas.add(venda);
                    }
                }
            }
        }
        
        return copia_vendas;
    }
    
}
