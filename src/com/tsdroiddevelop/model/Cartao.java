package com.tsdroiddevelop.model;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/*
 * Classe Cartao responsavel pela geração do cartoes de credito quando o cliente tiver um credito aprovado */

public class Cartao {

    private final String numeroCartao;
    private String validade;
    private final Integer codigoSeguranca;

    public Cartao() {
        String data = LocalDateTime.now().plusYears(5).format(DateTimeFormatter.ofPattern("MM/yyyy"));
        Random random = new Random();

        this.numeroCartao = geraCartao();
        this.codigoSeguranca = (random.nextInt(998) + 1);
        this.validade = data;
    }

    private static String geraCartao() {

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
        int n11 = r.nextInt(10);
        int n12 = r.nextInt(10);
        int n13 = r.nextInt(10);
        int n14 = r.nextInt(10);
        int n15 = r.nextInt(10);
        int n16 = r.nextInt(10);

        numeroGerado = "" + n1 + n2 + n3 + n4 + " " + n5 + n6 + n7 + n8 + " " + n9 + n10 + n11 + n12 + " " + n13 + n14 + n15 + n16;

        return numeroGerado;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public Integer getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

}