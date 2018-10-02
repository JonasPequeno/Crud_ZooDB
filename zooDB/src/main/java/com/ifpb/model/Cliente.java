package com.ifpb.model;

import org.zoodb.api.impl.ZooPC;

/**
 *
 * @author jonas
 */
public abstract class Cliente extends ZooPC{
 
    private int codigo;
    private String nome;  
    
    @SuppressWarnings("unused")
    public Cliente() {

    }

    public Cliente(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    

    public int getCodigo() {
        zooActivateRead();
        return codigo;
    }

    public void setCodigo(int codigo) {
        zooActivateWrite();
        this.codigo = codigo;
    }

    public String getNome() {
        zooActivateRead();
        return nome;
    }

    public void setNome(String nome) {
        zooActivateWrite();
        this.nome = nome;
    }

    @Override
    public String toString() {
        zooActivateRead();
        return "Cliente{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }
    
    

}