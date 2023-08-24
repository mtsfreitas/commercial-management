package gestaocomercial;

import gestaocomercial.controller.ControleClientes;
import gestaocomercial.controller.ControleProdutos;
import gestaocomercial.controller.ControleVendas;
import gestaocomercial.model.Cliente;
import gestaocomercial.model.Endereco;
import gestaocomercial.model.Par;
import gestaocomercial.model.Produto;
import gestaocomercial.model.StatusVenda;
import gestaocomercial.model.TipoProduto;
import gestaocomercial.model.Venda;
import gestaocomercial.view.MenuPrincipal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Freitas
 */
public class GestaoComercial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        teste1();
        new MenuPrincipal().setVisible(true);
    }
    
    public static void insercaoTeste1(ControleClientes controleClientes, ControleProdutos controleProdutos,
            ControleVendas controleVendas){
        ArrayList<Endereco> enderecos = new ArrayList<>();
        Endereco endereco = new Endereco("MG", "Florestal", "alguma rua", 123, "Casa");
        enderecos.add(endereco);
        endereco = new Endereco("MG", "Belo Horizonte", "alguma outra rua", 321, "Apartamento");
        enderecos.add(endereco);
        Cliente novo_cliente = new Cliente(1, "123.456.789-01", "Fulano", "fulano@teste.com", "123", enderecos, 57.00);
        System.out.println(controleClientes.cadastrarCliente(novo_cliente));
        
        enderecos = new ArrayList<>();
        endereco = new Endereco("SP", "São Paulo", "A Rua", 881, "Apartamento");
        enderecos.add(endereco);
        endereco = new Endereco("RJ", "Barra da Tijuca", "Rua Afonso", 21, "Casa");
        enderecos.add(endereco);
        novo_cliente = new Cliente(2, "163.431.461-88", "Ciclano", "ciclano@teste2.com", "345", enderecos, 25.00);
        System.out.println(controleClientes.cadastrarCliente(novo_cliente));
        
        // prod
        Produto novo_produto = new Produto(1, "Scooby Doo", 50, "Alguma categoria", TipoProduto.LIVRO, "Edição única", 12.50);
        System.out.println(controleProdutos.cadastrarProduto(novo_produto));
        novo_produto = new Produto(2, "Homem Aranha 2", 2, "Alguma categoria 2", TipoProduto.JOGO, "Playstation 2", 5.00);
        System.out.println(controleProdutos.cadastrarProduto(novo_produto));
        
        
        // venda
        ArrayList<Par<Produto, Integer>> produtos_vendidos = new ArrayList<>();
        Par<Produto, Integer> produto_vendido = new Par(controleProdutos.getProduto(2), 1);
        produtos_vendidos.add(produto_vendido);
        produto_vendido = new Par(controleProdutos.getProduto(1), 3);
        produtos_vendidos.add(produto_vendido);
        Venda venda_criada = new Venda(1, controleClientes.getCliente(1), controleClientes.getCliente(1).getEnderecos().get(0), new Date(), StatusVenda.ENTREGUE, 
            produtos_vendidos);
        System.out.println(controleVendas.efetuarVenda(venda_criada, controleProdutos).toString());
        
        produtos_vendidos = new ArrayList<>();
        produto_vendido = new Par(controleProdutos.getProduto(2), 3);
        produtos_vendidos.add(produto_vendido);
        produto_vendido = new Par(controleProdutos.getProduto(1), 1);
        produtos_vendidos.add(produto_vendido);
        venda_criada = new Venda(2, controleClientes.getCliente(2), controleClientes.getCliente(2).getEnderecos().get(0), new Date(), StatusVenda.PENDENTE, 
            produtos_vendidos);
        System.out.println(controleVendas.efetuarVenda(venda_criada, controleProdutos).toString());
        
        System.out.println("-- CLIENTES --");
        for(Cliente cliente : controleClientes.getClientes(null)){
            System.out.println(cliente.toString());
        }
        
        System.out.println("-- PRODUTOS --");
        for(Produto produto : controleProdutos.getProdutos(null)){
            System.out.println(produto.toString());
        }
        
        System.out.println("-- VENDAS --");
        for(Venda venda : controleVendas.getVendas(null, null)){
            System.out.println(venda.toString());
        }
        
        System.out.println("-- PRODUTOS APÓS AS VENDAS --");
        for(Produto produto : controleProdutos.getProdutos(null)){
            System.out.println(produto.toString());
        }
    }
    
    public static void teste1(){
        ControleClientes controleClientes = new ControleClientes();
        ControleProdutos controleProdutos = new ControleProdutos();
        ControleVendas controleVendas = new ControleVendas();
        
        insercaoTeste1(controleClientes, controleProdutos, controleVendas);
    }
    
}
