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
public class PessoaFisica extends Cliente{
            
    private String cpf;

    @SuppressWarnings("unused")
    public PessoaFisica() {
        
    }

    public PessoaFisica(String cpf, int codigo, String nome) {
        super(codigo, nome);
        this.cpf = cpf;
    }
    
    public String getCpf() {
        zooActivateRead();
        return cpf;
    }

    public void setCpf(String cpf) {
        zooActivateWrite();
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        zooActivateRead();
        return "PessoaFisica{" + "cpf=" + cpf + '}';
    }
    
    
}
