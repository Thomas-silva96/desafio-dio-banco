package com.tsdroiddevelop.model;

import java.util.Random;

public class Conta extends InfoBanco {

    private Cliente pessoa;
    private String numero;
    private String dataCriacao;
    private String tipoConta;
    private Double saldo;
    private boolean ativa;
    private Cartao cartaoCredito;
    private boolean possuiCredito;

    public Conta(String conta) {
        Random random = new Random();
        this.tipoConta = conta;
        this.numero = "" + random.nextInt(4) + "-" + random.nextInt(1);
        this.pessoa = new Cliente();
        this.saldo = 0.0;
        this.ativa = Boolean.TRUE;
    }

    public Cliente getPessoa() {
        return pessoa;
    }

    public void setPessoa(Cliente pessoa) {
        this.pessoa = pessoa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String getDataCriacao() {
        return dataCriacao;
    }

    @Override
    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Cartao getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(Cartao cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public boolean isPossuiCredito() {
        return possuiCredito;
    }

    public void setPossuiCredito(boolean possuiCredito) {
        this.possuiCredito = possuiCredito;
    }
}
