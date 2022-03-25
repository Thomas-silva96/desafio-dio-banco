package com.tsdroiddevelop.operacoes;

import com.tsdroiddevelop.interfaces.FuncoesBancarias;
import com.tsdroiddevelop.model.Cartao;
import com.tsdroiddevelop.model.Conta;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Classe responsavel pela implementação da interface FuncoesBancarias
 * Gerenciamento das funcoes do Banco */

public class Operacoes implements FuncoesBancarias {

    @Override
    public void sacar(Conta conta, double valor) {

        if (Validacoes.verificaRealizarOperacao(conta, valor)) {
            double novoSaldo = conta.getSaldo() - valor;
            conta.setSaldo(novoSaldo);

            System.out.printf("Você sacou: R$%.2f%n\n", valor);
        }
    }

    @Override
    public void depositar(Conta conta, double valor) {
        if (Validacoes.verificaRealizarDeposito(valor)) {
            double novoSaldo = conta.getSaldo() + valor;
            conta.setSaldo(novoSaldo);

            System.out.printf("Você depositou: R$%.2f%n\n", valor);
        }
    }

    @Override
    public void transferir(Conta suaConta, Conta contaDestino, double valor) {
        if (Validacoes.verificaRealizarOperacao(suaConta, valor)) {
            sacar(suaConta, valor);
            depositar(contaDestino, valor);

            System.out.printf("\nDeposito feito para %s no total de: R$%.2f%n\n", contaDestino.getPessoa().getNome(), contaDestino.getSaldo());
            System.out.printf("\nSaldo atual da sua conta é: R$%.2f%n\n", suaConta.getSaldo());
        }
    }

    @Override
    public void imprimirExtrato(Conta conta) {
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String hora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        System.out.println("\nBanco:" + conta.getNome());
        System.out.println("Nome:" + conta.getPessoa().getNome());
        System.out.println("CPF:" + conta.getPessoa().getCpf() + "  Agência:" + conta.getCodigo());
        System.out.println("Conta:" + conta.getTipoConta() + "  Nº da Conta:" + conta.getNumero());
        System.out.printf("Saldo: R$%.2f%n", conta.getSaldo());
        System.out.println("Data da Emissao:" + data);
        System.out.println("Hora da Emissao:" + hora);

    }

    @Override
    public Cartao solicitarCartao(Conta conta) throws ParseException {
        if (Validacoes.verificaSolicitarCartao(conta)) {
            Cartao cartaoCredito = new Cartao();
            conta.setCartaoCredito(cartaoCredito);
            conta.setPossuiCredito(true);
            System.out.println("\nCartão de Crédito solicitado com sucesso!");
        }
        return conta.getCartaoCredito();
    }

    @Override
    public void exibirDadosBancarios(Conta conta) {

        System.out.println("\nNome: " + conta.getPessoa().getNome());
        System.out.println("CPF: " + conta.getPessoa().getCpf());
        System.out.println("Gênero: " + conta.getPessoa().getGenero());
        System.out.println("Data de Nascimento: " + conta.getPessoa().getDataNascimento());
        System.out.println("Banco: " + conta.getNome());
        System.out.println("Agência: " + conta.getCodigo());
        System.out.println("Tipo de Conta: " + conta.getTipoConta());
        System.out.println("Nº da Conta: " + conta.getNumero());
    }

    @Override
    public void exibirDadosCartao(Conta conta) {

        System.out.println("\nNome: " + conta.getPessoa().getNome());
        System.out.println("CPF: " + conta.getPessoa().getCpf());
        System.out.println("Agência: " + conta.getCodigo());
        System.out.println("Tipo de Conta: " + conta.getTipoConta());
        System.out.println("Nº da Conta: " + conta.getNumero());
        System.out.println("\nNumero do cartao: " + conta.getCartaoCredito().getNumeroCartao());
        System.out.println("Data de Validade: " + conta.getCartaoCredito().getValidade());
        System.out.println("CVC: " + conta.getCartaoCredito().getCodigoSeguranca());

    }
}

