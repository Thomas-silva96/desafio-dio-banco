package com.tsdroiddevelop.operacoes;

import com.tsdroiddevelop.model.Conta;

import java.util.List;

/*
 * Classe responsavel pela Validação das contas para realização das operações Bancarias */

public class Validacoes {

    public static boolean verificaCadastrarConta(Conta conta) {
        if (!verificaDadosPessoa(conta)) {
            System.out.println("\nNão foi possível cadastrar a conta!");
            return false;
        }
        return true;
    }

    public static boolean verificaDadosPessoa(Conta conta) {
        if (conta == null) {
            System.out.println("\nConta não foi preenchida.");
            return false;
        }

        if (conta.getPessoa().getNome().isEmpty()) {
            System.out.println("\nNome não foi preenchido.");
            return false;
        }

        if (conta.getPessoa().getCpf().isEmpty()) {
            System.out.println("\nCPF não foi preenchido.");
            return false;
        }

        if (conta.getPessoa().getGenero().isEmpty()) {
            System.out.println("\nGênero não foi preenchido.");
            return false;
        }

        if (conta.getPessoa().getDataNascimento().isEmpty()) {
            System.out.println("\nData de Nascimento não foi preenchido.");
            return false;
        }

        if (conta.getNumero().isEmpty()) {
            System.out.println("\nNº da Conta não foi preenchido.");
            return false;
        }

        return true;
    }

    public static boolean verificaRealizarOperacao(Conta conta, double valor) {
        if (valor <= conta.getSaldo()) {
            return true;
        } else {
            System.out.println("\nNão foi possível realizar a operação, verifique o valor informado!");
            return false;
        }
    }

    public static boolean verificaRealizarDeposito(double valor) {
        if (valor > 0) {
            return true;
        } else {
            System.out.println("\nNão foi possível realizar o depósito, verifique o valor informado!");
            return false;
        }
    }

    public static boolean verificaSolicitarCartao(Conta conta) {
        if (conta.getSaldo() > 50) {
            return true;
        } else {
            System.out.println("\nNo momento não temos Credito aprovado para voce.");
            return false;
        }
    }

    public static boolean verificaContaExistente(List<Conta> contas, String cpf) {
        if (!contas.isEmpty()) {
            for (Conta conta : contas) {
                if (conta.getPessoa().getCpf().equals(cpf)) {
                    return true;
                }
            }
        }

        System.out.println("\nO CPF informado não pertence a nenhuma conta!");
        return false;
    }

    public static boolean verificaCartaoExistente(Conta conta) {

        if (conta.isPossuiCredito())
            return true;

        else {
            System.out.println("\nO CPF informado não tem cartoes gerados!");
            return false;
        }
    }
}
