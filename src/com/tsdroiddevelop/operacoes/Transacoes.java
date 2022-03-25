package com.tsdroiddevelop.operacoes;

import com.tsdroiddevelop.interfaces.FuncoesBancarias;
import com.tsdroiddevelop.model.Cartao;
import com.tsdroiddevelop.model.Conta;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacoes implements FuncoesBancarias {

    @Override
    public void sacar(Conta conta, double valor) {

        if (Validacoes.verificaRealizarOperacao(conta, valor)) {
            double novoSaldo = conta.getSaldo() - valor;
            conta.setSaldo(novoSaldo);

            System.out.println("Você sacou: R$ " + valor);
        }
    }

    @Override
    public void depositar(Conta conta, double valor) {
        if (Validacoes.verificaRealizarDeposito(valor)) {
            double novoSaldo = conta.getSaldo() + valor;
            conta.setSaldo(novoSaldo);

            System.out.println("Você depositou: R$ " + valor);
        }
    }

    @Override
    public void transferir(Conta suaConta, Conta contaDestino, double valor) {
        if (Validacoes.verificaRealizarOperacao(suaConta, valor)) {
            sacar(suaConta, valor);
            depositar(contaDestino, valor);

            System.out.println("Você transferiu para " + contaDestino.getPessoa().getNome() + " o total de: R$ " + suaConta.getSaldo());
            System.out.println("Seu saldo atual da sua conta é: R$ " + suaConta.getSaldo());
        }
    }

    @Override
    public void imprimirExtrato(Conta conta) {
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String hora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        System.out.println("Banco: " + conta.getNome());
        System.out.println("Nome: " + conta.getPessoa().getNome());
        System.out.println("CPF: " + conta.getPessoa().getCpf() + " Agência: " + conta.getCodigo());
        System.out.println("Conta: " + conta.getTipoConta() + " Nº da Conta: " + conta.getNumero());
        System.out.println("Saldo: R$ %.2f%n" + conta.getSaldo());
        System.out.println("Data da Emissao: " + data);
        System.out.println("Hora da Emissao: " + hora);

    }

    @Override
    public void solicitarCartao(Conta conta) throws ParseException {
        if (Validacoes.verificaSolicitarCartao(conta)) {
            Cartao cartaoCredito = new Cartao();
            conta.setCartaoCredito(cartaoCredito);

            System.out.println("Cartão de Crédito solicitado com sucesso!");
        }
    }

    @Override
    public void exibirDadosBancarios(Conta conta) {

        System.out.println("Nome: " + conta.getPessoa().getNome());
        System.out.println("CPF: " + conta.getPessoa().getCpf());
        System.out.println("Gênero: " + conta.getPessoa().getGenero());
        System.out.println("Data de Nascimento: " + LocalDate.parse(conta.getPessoa().getDataNascimento()));
        System.out.println("Banco: " + conta.getNome());
        System.out.println("Agência: " + conta.getCodigo());
        System.out.println("Conta: " + conta.getTipoConta());
        System.out.println("Nº da Conta: " + conta.getNumero());
    }
}

