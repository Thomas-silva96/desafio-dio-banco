package com.tsdroiddevelop.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/*
 * Classe responsavel pela geração dos dados do banco
 * Nome
 * CNPJ
 * Data de criação do banco
 * e controle de contas abertas */

public class InfoBanco {

    protected static int CONTA_CORRENTE = 0, CONTA_POUPANCA = 0;

    private final String nome;
    private final String cnpj;
    private final String dataCriacaoBanco;
    private final String codigo;

    public InfoBanco() {
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.nome = "BancoTS";
        this.cnpj = geraCnpj();
        this.dataCriacaoBanco = data;
        this.codigo = "0001";
    }

    private static String geraCnpj() {

        String numeroGerado;
        Random r = new Random();

        //numeros gerados
        int n1 = r.nextInt(10);
        int n2 = r.nextInt(10);
        int n3 = r.nextInt(10);
        int n4 = r.nextInt(10);
        int n5 = r.nextInt(10);
        int n6 = r.nextInt(10);
        int n7 = r.nextInt(10);
        int n8 = r.nextInt(10);
        int n9 = r.nextInt(10);
        int n10 = r.nextInt(10);

        numeroGerado = "" + n1 + n2 + "." + n3 + n4 + n5 + "." + n6 + n7 + n8 + "/0001-" + n9 + n10;

        return numeroGerado;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDataCriacaoBanco() {
        return dataCriacaoBanco;
    }

    public String getContaCorrente() {
        return String.valueOf(CONTA_CORRENTE);
    }

    public String getContaPoupanca() {
        return String.valueOf(CONTA_POUPANCA);
    }
}
