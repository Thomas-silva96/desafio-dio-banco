package com.tsdroiddevelop.operacoes;

import com.tsdroiddevelop.model.Conta;

import java.util.List;

public class Validacoes {

    public static boolean verificaCadastrarConta(Conta conta) {
        if(!verificaDadosPessoa(conta)) {
            System.out.println("Não foi possível cadastrar a conta!");
            return false;
        }
        return true;
    }

    public static boolean verificaDadosPessoa(Conta conta) {
        if(conta == null) {
            System.out.println("Conta não foi preenchida.");
            return false;
        }

        if(conta.getPessoa().getNome().isEmpty()) {
            System.out.println("Nome não foi preenchido.");
            return false;
        }

        if(conta.getPessoa().getCpf().isEmpty()) {
            System.out.println("CPF não foi preenchido.");
            return false;
        }

        if(conta.getPessoa().getGenero().isEmpty()) {
            System.out.println("Gênero não foi preenchido.");
            return false;
        }

        if(conta.getPessoa().getDataNascimento().isEmpty()) {
            System.out.println("Data de Nascimento não foi preenchido.");
            return false;
        }

        if(conta.getNumero().isEmpty()) {
            System.out.println("Nº da Conta não foi preenchido.");
            return false;
        }

        return true;
    }

    public static boolean verificaRealizarOperacao(Conta conta, double valor) {
        if(valor <= conta.getSaldo()) {
            return true;
        }else{
            System.out.println("Não foi possível realizar a operação, verifique o valor informado!");
            return false;
        }
    }

    public static boolean verificaRealizarDeposito(double valor) {
        if(valor > 0) {
            return true;
        } else {
            System.out.println("Não foi possível realizar o depósito, verifique o valor informado!");
            return false;
        }
    }

    public static boolean verificaSolicitarCartao(Conta conta) {
        if(conta.getSaldo() > 50) {
            return true;
        }else {
            System.out.println("Não é possível solicitar um cartão! Verifique o seu tempo de conta.");
            return false;
        }
    }

    public static boolean verificaContaExistente(List<Conta> contas, String cpf) {
        if(!contas.isEmpty()) {
            for (Conta conta : contas) {
                if(conta.getPessoa().getCpf().equals(cpf)) {
                    return true;
                }
            }
        }

        System.out.println("O CPF informado não pertence a nenhuma conta!");
        return false;
    }
}
