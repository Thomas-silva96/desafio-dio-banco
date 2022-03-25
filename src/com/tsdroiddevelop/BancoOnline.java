package com.tsdroiddevelop;

import com.tsdroiddevelop.model.Conta;
import com.tsdroiddevelop.operacoes.Transacoes;
import com.tsdroiddevelop.operacoes.Validacoes;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoOnline {

    public static void main(String[] args) {

        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        Scanner sc = new Scanner(System.in);

        Transacoes transacao = new Transacoes();
        List<Conta> contas = new ArrayList<Conta>();

        String opcao = "";
        boolean sair = false;

        System.out.println("||================================================================||");
        System.out.println("||======================== BancoTS! ==============================||");
        System.out.println("||================================================================||");
        System.out.println("||Bem vindo ao BancoTS!                                           ||");
        System.out.println("||Aqui é possível: Criar sua conta, depositar, sacar e transferir.||");
        System.out.println("||================================================================||");

        try {
            do {
                System.out.println("||===========================================================||");
                System.out.println("|| 1 - Criar Conta                                            ||");
                System.out.println("|| 2 - Listar Todas as Contas                                 ||");
                System.out.println("|| 3 - Exibir Dados Bancários pelo CPF                        ||");
                System.out.println("|| 4 - Visualizar Saldo Pelo CPF                              ||");
                System.out.println("|| 5 - Solicitar Cartão de Crédito                            ||");
                System.out.println("|| 6 - Sacar                                                  ||");
                System.out.println("|| 7 - Depositar                                              ||");
                System.out.println("|| 8 - Transferir                                             ||");
                System.out.println("|| 9 - Extrato                                                ||");
                System.out.println("|| 0 - Sair                                                   ||");
                System.out.println("||============================================================||");

                System.out.print("Informe a opção: ");
                opcao = sc.nextLine();

                switch (opcao) {
                    case "0" -> {
                        System.out.println("||============================================================||");
                        System.out.println("||ENCERRADANDO APLICAÇÃO...                                   ||");
                        System.out.println("||OBRIGADO!                                                   ||");
                        System.out.println("||============================================================||");
                        sair = true;
                    }
                    case "1" -> {
                        System.out.println("-> CRIAR CONTA");
                        System.out.println("Qual o tipo de conta que deseja:");
                        System.out.println("1 - Conta Corrente | 2 - Conta Poupanca");
                        String tipoConta;

                        if (sc.nextInt() == 1)
                            tipoConta = "Conta Corrente";
                        else
                            tipoConta = "Conta Poupanca";

                        Conta c1 = new Conta(tipoConta);

                        System.out.print("Informe o nome da pessoa: ");
                        c1.getPessoa().setNome(sc.nextLine());

                        System.out.print("Informe o CPF da pessoa: ");
                        c1.getPessoa().setCpf(sc.nextLine());

                        System.out.print("Informe o genêro da pessoa (Masculino ou Feminino): ");
                        c1.getPessoa().setGenero(sc.nextLine());

                        System.out.print("Informe a data de nascimento da pessoa: ");
                        String dataNascimento = sc.nextLine();
                        if (!dataNascimento.isEmpty()) {
                            c1.getPessoa().setDataNascimento(dataNascimento);
                        }

                        if (Validacoes.verificaCadastrarConta(c1)) {
                            contas.add(c1);
                            System.out.println("Conta criada com sucesso!");
                        }
                    }
                    case "2" -> {
                        System.out.println("-> LISTAR CONTAS");
                        if (!contas.isEmpty()) {
                            for (Conta conta : contas) {
                                System.out.println("Nome: " +conta.getNome() + "Agência: " + conta.getCodigo() + "Número:" + conta.getNumero());
                            }
                        }
                    }
                    case "3" -> {
                        System.out.println("-> DADOS BANCÁRIOS");
                        System.out.print("Informe o CPF da pessoa: ");
                        String cpf = sc.nextLine();

                        if (Validacoes.verificaContaExistente(contas, cpf)) {
                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpf)) {
                                    transacao.exibirDadosBancarios(conta);
                                }
                            }
                        }
                    }
                    case "4" -> {
                        System.out.println("-> SALDO");
                        System.out.print("Informe o CPF: ");
                        String cpf = sc.nextLine();

                        if (Validacoes.verificaContaExistente(contas, cpf)) {
                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpf)) {
                                    System.out.println("O saldo é de: R$ %.2f%n" + conta.getSaldo());
                                }
                            }
                        }
                    }
                    case "5" -> {
                        System.out.println("-> SOLICITAR CARTÃO");
                        System.out.print("Informe o CPF da pessoa: ");
                        String cpf = sc.nextLine();

                        if (Validacoes.verificaContaExistente(contas, cpf)) {
                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpf)) {
                                    transacao.solicitarCartao(conta);
                                }
                            }
                        }
                    }
                    case "6" -> {
                        System.out.println("-> SAQUE");
                        System.out.print("Informe o CPF: ");
                        String cpf = sc.nextLine();

                        if (Validacoes.verificaContaExistente(contas, cpf)) {
                            String valor;

                            System.out.print("Informe o valor do saque: ");
                            valor = sc.nextLine();

                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpf)) {
                                    transacao.sacar(conta, Double.parseDouble(valor));
                                }
                            }
                        }
                    }
                    case "7" -> {
                        System.out.println("-> DEPÓSITO");
                        System.out.print("Informe o CPF da pessoa: ");
                        String cpf = sc.nextLine();

                        if (Validacoes.verificaContaExistente(contas, cpf)) {
                            String valor;

                            System.out.print("Informe o valor do depósito: ");
                            valor = sc.nextLine();

                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpf)) {
                                    transacao.depositar(conta, Double.parseDouble(valor));
                                }
                            }
                        }
                    }
                    case "8" -> {
                        System.out.println("-> TRANSFERÊNCIA");
                        System.out.print("Informe o CPF do depositante: ");
                        String cpfDep = sc.nextLine();

                        System.out.print("Informe o CPF do recebedor: ");
                        String cpfRec = sc.nextLine();

                        if (Validacoes.verificaContaExistente(contas, cpfDep)
                                && Validacoes.verificaContaExistente(contas, cpfRec)) {
                            Conta contaDep = null, contaRec = null;
                            String valor;

                            System.out.print("Informe o valor do depósito: ");
                            valor = sc.nextLine();

                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpfDep)) {
                                    contaDep = conta;
                                } else if (conta.getPessoa().getCpf().equals(cpfRec)) {
                                    contaRec = conta;
                                }
                            }

                            transacao.transferir(contaDep, contaRec, Double.parseDouble(valor));
                        }
                    }
                    default -> {
                    }
                }
            } while (!sair);

        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
