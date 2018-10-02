
package com.ifpb.model;

import java.util.HashSet;
import java.util.Set;
import org.zoodb.api.impl.ZooPC;

/**
 *
 * @author jonas
 */
public class Pedido extends ZooPC {
    
    private int codigo;
    private Cliente cliente;
    private Set<ItemPedido> itens = new HashSet<ItemPedido>();

    @SuppressWarnings("unused")
    private Pedido() {

    }   

    public Pedido(int codigo, Cliente cliente) {
        this.codigo = codigo;
        this.cliente = cliente;
    }
    
    public int getCodigo() {
        zooActivateRead();
        return codigo;
    }

    public void setCodigo(int codigo) {
        zooActivateWrite();
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        zooActivateRead();
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        zooActivateWrite();
        this.cliente = cliente;
    }

    public Set<ItemPedido> getItens() {
        zooActivateRead();
        return itens;
    }

    public void addItens(ItemPedido item) {
        zooActivateWrite();
        itens.add(item);
    }

    @Override
    public String toString() {
        zooActivateRead();
        return "Pedido{" + "codigo=" + codigo + ", cliente=" + cliente + ", itens=" + itens + '}';
    }
        
    public float calcTotal () {
        zooActivateRead();
        float total = 0;
        for(ItemPedido item : itens) {
            total += item.calcSubTotal();
        }
        return total;
    }
    
    
}
