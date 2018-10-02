/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.model;

import org.zoodb.api.impl.ZooPC;

/**
 *
 * @author jonas
 */
public class ItemPedido extends ZooPC{
    
    private int codigo;
    private int quantidade;
    private Produto produto;

    @SuppressWarnings("unused")
    public ItemPedido() {

    }

    public ItemPedido(int codigo, int quantidade, Produto produto) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.produto = produto;
    }
    
    

    public int getCodigo() {
        zooActivateRead();
        return codigo;
    }

    public void setCodigo(int codigo) {
        zooActivateWrite();
        this.codigo = codigo;
    }

    public int getQuantidade() {
        zooActivateRead();
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        zooActivateWrite();
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        zooActivateRead();
        return "ItemPedido{" + "codigo=" + codigo + ", quantidade=" + quantidade + ", produto=" + produto + '}';
    }
    
    
    
    public float calcSubTotal () {
        zooActivateRead();
        return produto.getPreco() * quantidade;
    }
}
