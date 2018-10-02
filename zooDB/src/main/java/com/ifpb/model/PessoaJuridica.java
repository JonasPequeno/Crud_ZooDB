/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.model;

/**
 *
 * @author jonas
 */
public class PessoaJuridica extends Cliente{
    
    private String cnpj;
    private float limiteCredido;

    @SuppressWarnings("unused")
    public PessoaJuridica() {
        
    }

    public PessoaJuridica(String cnpj, float limiteCredido, int codigo, String nome) {
        super(codigo, nome);
        this.cnpj = cnpj;
        this.limiteCredido = limiteCredido;
    }
    

    public String getCnpj() {
        zooActivateRead();
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        zooActivateWrite();
        this.cnpj = cnpj;
    }

    public float getLimiteCredido() {
        zooActivateRead();
        return limiteCredido;
    }

    public void setLimiteCredido(float limiteCredido) {
        zooActivateWrite();
        this.limiteCredido = limiteCredido;
    }

    @Override
    public String toString() {
        zooActivateRead();
        return "PessoaJuridica{" + "cnpj=" + cnpj + ", limiteCredido=" + limiteCredido + '}';
    }
    
    
    
}
