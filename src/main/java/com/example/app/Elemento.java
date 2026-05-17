package com.example.app;

public class Elemento<E> {
    private E valor;
    private Elemento<E> proximo;
    public Elemento(E valor) {
        this.valor = valor;
        this.proximo = null;
    }
    public E getValor() {
        return valor;
    }
    public Elemento<E> getProximo() {
        return proximo;
    }
    public void setValor(E valor) {
        this.valor = valor;
    }
    public void setProximo(Elemento<E> proximo) {
        this.proximo = proximo;
    }
    
}
