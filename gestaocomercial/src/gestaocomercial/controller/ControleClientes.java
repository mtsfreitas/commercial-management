package gestaocomercial.controller;

import gestaocomercial.model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Freitas
 */
public class ControleClientes {
    
    private final ArrayList<Cliente> clientes;
    
    public ControleClientes() { 
        clientes = new ArrayList<>(); 
    }
    
    public Cliente getCliente(int codigo){
        for(Cliente cliente : clientes){
            if(cliente.getCodigo() == codigo){
                return cliente;
            }
        }
        return null;
    }
    
    public String cadastrarCliente(Cliente novo_cliente){
        for(Cliente cliente : clientes){
            if(cliente.getCPF().equals(novo_cliente.getCPF())){
                return "Erro: Já existe um cliente cadastrado com este mesmo CPF.";
            } 
            if(cliente.getEmail().equals(novo_cliente.getEmail())){
                return "Erro: Já existe um cliente cadastrado com este mesmo e-mail.";
            } 
            if(cliente.getCodigo() == novo_cliente.getCodigo()){
                return "Erro: Já existe um cliente cadastrado com este mesmo código.";
            }
        }
        
        clientes.add(novo_cliente);
        
        return "Cliente cadastrado com sucesso!";
    }
    
    public String alterarDadosCliente(Cliente cliente_alterado){
        // verificando se existe o código do cliente
        Cliente cliente_encontrado = null;
        for(Cliente cliente : clientes){
            if(cliente.getCodigo() == cliente_alterado.getCodigo()){
                cliente_encontrado = cliente;
            } else{
                if(cliente.getCPF().equals(cliente_alterado.getCPF())){
                    return "Erro: Existe um outro cliente (código diferente) com este mesmo CPF: " + cliente_alterado.getCPF();
                } 
                if(cliente.getEmail().equals(cliente_alterado.getEmail())){
                    return "Erro: Existe um outro cliente (código diferente) com este mesmo e-mail: " + cliente_alterado.getEmail();
                }
            }
        }
        
        if(cliente_encontrado == null)
            return "Erro: Cliente não encontrado.";
        
        cliente_encontrado.alterarDados(cliente_alterado);
        
        return "Os dados do cliente de código " + cliente_encontrado.getCodigo()+ " foram alterados com sucesso!";
    }
    
    public ArrayList<Cliente> getClientes(String filtro_nome){
        ArrayList<Cliente> clientes_filtrados = new ArrayList<>();
        
        if(filtro_nome == null || filtro_nome.isEmpty()){
            for(Cliente cliente : clientes){
                clientes_filtrados.add(cliente);
            }
        } else{
            // aplicando filtro de nome
            for(Cliente cliente : clientes){
                if(cliente.getNome().contains(filtro_nome))
                    clientes_filtrados.add(cliente);
            }
        }
        
        return clientes_filtrados;        
    }
    
    public boolean atualizarSaldo(int cod_cliente, double novo_saldo){
        if(novo_saldo < 0)
            return false;
        for(Cliente cliente : clientes){
            if(cliente.getCodigo() == cod_cliente){
                cliente.setSaldo(novo_saldo);
                return true;
            }
        }
        return false;
    }
    
}
