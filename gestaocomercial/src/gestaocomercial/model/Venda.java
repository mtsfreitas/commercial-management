package gestaocomercial.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Freitas
 */
public class Venda {
    private int codigo;
    private Cliente cliente;
    private Endereco endereco_entrega;
    private Date data_venda;
    private StatusVenda status;
    private ArrayList<Par<Produto, Integer>> produtos_vendidos; // Produto e quantidade de cada um

//    public Venda(int codigo, Cliente cliente, Date data_venda) {
//        this.codigo = codigo;
//        this.cliente = cliente;
//        this.data_venda = data_venda;
//    }

    public Venda(int codigo, Cliente cliente, Endereco endereco_entrega, 
            Date data_venda, StatusVenda status, ArrayList<Par<Produto, Integer>> produtos_vendidos) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.endereco_entrega = endereco_entrega;
        this.data_venda = data_venda;
        this.status = status;
        this.produtos_vendidos = produtos_vendidos;
    }

    
    
    public int getCodigo() {
        return codigo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public Endereco getEnderecoEntrega() {
        return endereco_entrega;
    }    

    public Date getDataVenda() {
        return data_venda;
    }

    public StatusVenda getStatus() {
        return status;
    }

    public ArrayList<Par<Produto, Integer>> getProdutosVendidos() {
        // criando copia
        ArrayList<Par<Produto, Integer>> copia_produtos_vendidos = new ArrayList<>();
        for(Par<Produto, Integer> par : this.produtos_vendidos){
            copia_produtos_vendidos.add(new Par<>(par.first, par.second));            
        }
        
        return copia_produtos_vendidos;
    }    


    public void setEnderecoEntrega(Endereco endereco_entrega) {
        this.endereco_entrega = endereco_entrega;
    }    

    public void setStatus(StatusVenda status) {
        this.status = status;
    }

    public void setProdutosVendidos(ArrayList<Par<Produto, Integer>> produtos_vendidos) {
        this.produtos_vendidos = produtos_vendidos;
    }
    
    
    public boolean alterarVenda(Venda venda_alterada){
        if(venda_alterada.getCodigo() != getCodigo())
            return false;
        
//        setCodEnderecoEntrega(venda_alterada.getCodEnderecoEntrega());
        setEnderecoEntrega(endereco_entrega);
        setProdutosVendidos(venda_alterada.getProdutosVendidos());
        setStatus(venda_alterada.getStatus());
        
        return true;
    }
    
    public Venda copy(){
        return new Venda(getCodigo(), getCliente(), getEnderecoEntrega(), 
                getDataVenda(), getStatus(), getProdutosVendidos());
    }
    
    @Override
    public String toString(){
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/YYYY SS:MM:HH");
        StringBuilder sb = new StringBuilder();
        for(Par<Produto, Integer> produto_vendido : produtos_vendidos){
            sb.append("\n- Produto: ").append(produto_vendido.first.getDescricao())
                    .append(" (").append(produto_vendido.first.getCodigo())
                    .append(") - ").append("Quantidade vendida: ").append(produto_vendido.second);
        }
        return "-- Venda --"
                + "\nCódigo: " + getCodigo()
                + "\nCliente:\n"
                + "  Código: " + getCliente().getCodigo()
                + "\n  Nome: " + getCliente().getNome()
                + "\nData da venda: " + dateFormat.format(getDataVenda())
                + "\nEndereço da entrega:\n" + getEnderecoEntrega().toString()
                + "\nStatus: " + getStatus()
                + "\nProdutos vendidos:\n" + sb.toString()
                + "\n\n";
    }
}
