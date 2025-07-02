package service;

import model.Conversoes;

public class Cambio {

    public double converter(double valor, Conversoes conversao, String moedaDestino) {
        return valor * conversao.getCotacao(moedaDestino);
    }
}

