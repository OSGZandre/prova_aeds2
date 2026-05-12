package com.example.app;

public class Elemento {
    private int valor;
    private Elemento proximo;
    public Elemento(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
    public int getValor() {
        return valor;
    }
    public Elemento getProximo() {
        return proximo;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }
    
}
