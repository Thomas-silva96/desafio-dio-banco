package com.tsdroiddevelop;

import com.tsdroiddevelop.operacoes.MenuBanco;
import com.tsdroiddevelop.operacoes.Operacoes;

/*
 * Classe principal
 * Inicializa o Banco * */


public class BancoOnline {

    public static void main(String[] args) throws InterruptedException {

        MenuBanco mb = new MenuBanco();
        Operacoes op = mb.bancoInicializar();
        mb.MenuPrincipal(op);
    }

}
