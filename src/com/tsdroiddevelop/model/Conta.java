package com.tsdroiddevelop.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;

/*
 * Classe conta responsavel pelo gerenciamento dos clientes, gerenciamento dos cartoes de credito e informações
 * das contas - Saldo, tipo de conta ...*/

public class Conta extends InfoBanco {

    private Cliente pessoa;
    private final String numero;
    private final String dataCriacaoConta;
    private final String tipoConta;
    private Double saldo;
    private boolean possuiCredito;
    private Cartao cartaoCredito;

    public Conta(String conta) {
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Random random = new Random();

        if (Objects.equals(conta, "Conta Corrente")) {
            CONTA_CORRENTE++;
            this.numero = "" + CONTA_CORRENTE + " 99" + "-" + random.nextInt(10);
        } else {
            CONTA_POUPANCA++;
            this.numero = "" + CONTA_POUPANCA + " 90" + "-" + random.nextInt(10);
        }

        this.tipoConta = conta;
        this.dataCriacaoConta = data;
        this.pessoa = new Cliente();
        this.saldo = 0.0;
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

    public String getTipoConta() {
        return tipoConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setCartaoCredito(Cartao cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public Cartao getCartaoCredito() {
        return cartaoCredito;
    }

    public String getDataCriacaoConta() {
        return dataCriacaoConta;
    }

    public boolean isPossuiCredito() {
        return possuiCredito;
    }

    public void setPossuiCredito(boolean possuiCredito) {
        this.possuiCredito = possuiCredito;
    }
}
