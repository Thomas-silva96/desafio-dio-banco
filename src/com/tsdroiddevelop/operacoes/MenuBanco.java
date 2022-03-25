package com.tsdroiddevelop.operacoes;

import com.tsdroiddevelop.model.Conta;
import com.tsdroiddevelop.model.InfoBanco;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Classe responsavel pela inicialização e interface do banco com o usuario */

public class MenuBanco {

    public Operacoes bancoInicializar() throws InterruptedException {

        System.out.println("||=================================================================||");
        System.out.println("||======================== BancoTS! ===============================||");
        System.out.println("||=================================================================||");

        Thread.sleep(3000);
        clearConsole();
        System.out.println("||=================================================================||");
        System.out.println("|| Bem vindo ao BancoTS!                                           ||");
        System.out.println("|| Aqui é possível: Criar sua conta, depositar, sacar e transferir.||");
        System.out.println("||=================================================================||");
        Thread.sleep(3000);
        clearConsole();

        return new Operacoes();
    }

    public void MenuPrincipal(Operacoes op) {

        try (Scanner sc = new Scanner(System.in)) {
            List<Conta> contas = new ArrayList<>();
            int opcao;
            boolean sair = false;
            do {
                System.out.println("||=================================================================||");
                System.out.println("||  Menu de Opcoes:                                                ||");
                System.out.println("||                                                                 ||");
                System.out.println("||  1 - Listar Todas as Contas                                     ||");
                System.out.println("||  2 - Criar Conta                                                ||");
                System.out.println("||  3 - Exibir Dados Bancários pelo CPF                            ||");
                System.out.println("||  4 - Extrato Bancario                                           ||");
                System.out.println("||  5 - Sacar                                                      ||");
                System.out.println("||  6 - Depositar                                                  ||");
                System.out.println("||  7 - Transferir                                                 ||");
                System.out.println("||  8 - Solicitar Cartão de Crédito                                ||");
                System.out.println("||  9 - Verificar Cartão de Crédito                                ||");
                System.out.println("||  0 - Sair                                                       ||");
                System.out.println("||=================================================================||\n");

                System.out.print("Informe a opção: ");
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 0 -> {
                        clearConsole();
                        System.out.println("||============================================================||");
                        System.out.println("||ENCERRADANDO APLICAÇÃO...                                   ||");
                        System.out.println("||OBRIGADO!                                                   ||");
                        System.out.println("||============================================================||");
                        Thread.sleep(3000);
                        clearConsole();
                        sair = true;
                    }
                    case 1 -> {
                        clearConsole();
                        System.out.println("-> LISTAR CONTAS");
                        InfoBanco ib = new InfoBanco();
                        if (!contas.isEmpty()) {
                            String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                            System.out.println("\nBancoTS -> " + "CNPJ:" + ib.getCnpj() + "  Contas Abertas:" + contas.size()
                                    + " ->  Conta Corrente:" + ib.getContaCorrente() + "  Conta Poupanca:" + ib.getContaPoupanca() + "   " + data + "\n");

                            for (Conta conta : contas) {
                                System.out.println("Nome:" + conta.getPessoa().getNome() + "  Data da Abertura da Conta:" + conta.getDataCriacaoConta()
                                        + "  Tipo de Conta:" + conta.getTipoConta() + "  Agência:" + conta.getCodigo() + "  Conta:" + conta.getNumero());
                            }
                            System.out.println("\nVoltar ao menu, aperte qualquer tecla!");
                            sc.nextLine();
                        } else {
                            clearConsole();
                            System.out.println("Nenhuma conta aberta!!");
                        }
                        Thread.sleep(2000);
                        clearConsole();
                    }
                    case 2 -> {
                        clearConsole();
                        System.out.println("-> CRIAR CONTA");
                        System.out.println("\nQual o tipo de conta que deseja:");
                        System.out.print("1 - Conta Corrente | 2 - Conta Poupanca  -> ");
                        String tipoConta;

                        if (sc.nextInt() == 1)
                            tipoConta = "Conta Corrente";
                        else
                            tipoConta = "Conta Poupanca";

                        Conta c1 = new Conta(tipoConta);
                        sc.nextLine();

                        System.out.print("\nInforme o nome da pessoa: ");
                        c1.getPessoa().setNome(sc.nextLine());

                        System.out.print("\nInforme o CPF da pessoa: ");
                        c1.getPessoa().setCpf(sc.nextLine());

                        System.out.print("\nInforme o genêro da pessoa (Masculino ou Feminino): ");
                        c1.getPessoa().setGenero(sc.nextLine());

                        System.out.print("\nInforme a data de nascimento da pessoa: ");
                        String dataNascimento = sc.nextLine();
                        if (!dataNascimento.isEmpty()) {
                            c1.getPessoa().setDataNascimento(dataNascimento);
                        }

                        if (Validacoes.verificaCadastrarConta(c1)) {
                            contas.add(c1);
                            System.out.println("Conta criada com sucesso!");
                        }
                        Thread.sleep(2000);
                        clearConsole();
                    }
                    case 3 -> {
                        clearConsole();
                        System.out.println("-> DADOS BANCÁRIOS");
                        System.out.print("\nInforme o CPF da pessoa: ");
                        String cpf = sc.nextLine();

                        if (Validacoes.verificaContaExistente(contas, cpf)) {
                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpf)) {
                                    op.exibirDadosBancarios(conta);
                                }
                            }
                            System.out.println("\nVoltar ao menu, aperte qualquer tecla!");
                            sc.nextLine();
                        }
                        Thread.sleep(2000);
                        clearConsole();
                    }
                    case 4 -> {
                        clearConsole();
                        System.out.println("-> EXTRATO");
                        System.out.print("\nInforme o CPF do Titular: ");
                        String cpf = sc.nextLine();

                        if (Validacoes.verificaContaExistente(contas, cpf)) {
                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpf)) {
                                    op.imprimirExtrato(conta);
                                }
                            }
                            System.out.println("\nVoltar ao menu, aperte qualquer tecla!");
                            sc.nextLine();
                        }
                        Thread.sleep(2000);
                        clearConsole();
                    }
                    case 5 -> {
                        clearConsole();
                        System.out.println("-> SAQUE");
                        System.out.print("\nInforme o CPF do Titular: ");
                        String cpf = sc.nextLine();

                        if (Validacoes.verificaContaExistente(contas, cpf)) {
                            String valor;

                            System.out.print("\nInforme o valor do saque: ");
                            valor = sc.nextLine();

                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpf)) {
                                    op.sacar(conta, Double.parseDouble(valor));
                                }
                            }
                            System.out.println("\nVoltar ao menu, aperte qualquer tecla!");
                            sc.nextLine();
                        }
                        Thread.sleep(2000);
                        clearConsole();
                    }
                    case 6 -> {
                        clearConsole();
                        System.out.println("-> DEPÓSITO");
                        System.out.print("\nInforme o CPF do Titular: ");
                        String cpf = sc.nextLine();

                        if (Validacoes.verificaContaExistente(contas, cpf)) {
                            String valor;

                            System.out.print("\nInforme o valor do depósito: ");
                            valor = sc.nextLine();

                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpf)) {
                                    op.depositar(conta, Double.parseDouble(valor));
                                }
                            }
                            System.out.println("\nVoltar ao menu, aperte qualquer tecla!");
                            sc.nextLine();
                        }
                        Thread.sleep(2000);
                        clearConsole();
                    }
                    case 7 -> {
                        clearConsole();
                        System.out.println("-> TRANSFERÊNCIA");
                        System.out.print("\nInforme o CPF do depositante: ");
                        String cpfDep = sc.nextLine();

                        System.out.print("\nInforme o CPF do recebedor: ");
                        String cpfRec = sc.nextLine();

                        if (Validacoes.verificaContaExistente(contas, cpfDep)
                                && Validacoes.verificaContaExistente(contas, cpfRec)) {
                            Conta contaDep = null, contaRec = null;
                            String valor;

                            System.out.print("\nInforme o valor do depósito: ");
                            valor = sc.nextLine();

                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpfDep)) {
                                    contaDep = conta;
                                } else if (conta.getPessoa().getCpf().equals(cpfRec)) {
                                    contaRec = conta;
                                }
                            }
                            op.transferir(contaDep, contaRec, Double.parseDouble(valor));

                            System.out.println("\nVoltar ao menu, aperte qualquer tecla!");
                            sc.nextLine();
                        }
                        Thread.sleep(2000);
                        clearConsole();
                    }
                    case 8 -> {
                        clearConsole();
                        System.out.println("-> SOLICITAR CARTÃO");
                        System.out.print("\nInforme o CPF do Titular da conta: ");
                        String cpf = sc.nextLine();

                        if (Validacoes.verificaContaExistente(contas, cpf)) {
                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpf)) {
                                    op.solicitarCartao(conta);
                                }
                            }
                            System.out.println("\nVoltar ao menu, aperte qualquer tecla!");
                            sc.nextLine();
                        }
                        Thread.sleep(2000);
                        clearConsole();
                    }
                    case 9 -> {
                        clearConsole();
                        System.out.println("-> VERIFICAR CARTAO DE CREDITO");
                        System.out.print("\nInforme o CPF da pessoa: ");
                        String cpf = sc.nextLine();

                        if (Validacoes.verificaContaExistente(contas, cpf)) {
                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpf)) {
                                    if (Validacoes.verificaCartaoExistente(conta)) {
                                        op.exibirDadosCartao(conta);
                                    }
                                }
                            }
                            System.out.println("\nVoltar ao menu, aperte qualquer tecla!");
                            sc.nextLine();
                        }
                        Thread.sleep(2000);
                        clearConsole();
                    }
                    default -> {
                        clearConsole();
                        System.out.println("OPCAO INVALIDA!!");
                        Thread.sleep(2000);
                        clearConsole();
                    }
                }
            } while (!sair);

        } catch (
                ParseException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

}
