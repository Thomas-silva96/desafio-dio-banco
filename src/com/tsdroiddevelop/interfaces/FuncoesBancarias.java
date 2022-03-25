package com.tsdroiddevelop.interfaces;

import com.tsdroiddevelop.model.Conta;

import java.text.ParseException;

public interface FuncoesBancarias {

    void sacar(Conta conta, double valor);

    void depositar(Conta conta, double valor);

    void transferir(Conta suaConta, Conta contaDestino, double valor);

    void imprimirExtrato(Conta conta);

    void solicitarCartao(Conta conta) throws ParseException;

    void exibirDadosBancarios(Conta conta);

}
