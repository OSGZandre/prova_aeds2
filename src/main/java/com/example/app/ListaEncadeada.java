package com.example.app;
public class ListaEncadeada {
    private Elemento primeiro;
    private Elemento ultimo;
    private int tamanho;
    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public Elemento getPrimeiro() {
        return primeiro;
    }
    public Elemento getUltimo() {
        return ultimo;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setPrimeiro(Elemento primeiro) {
        this.primeiro = primeiro;
    }
    public void setUltimo(Elemento ultimo) {
        this.ultimo = ultimo;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void adicionar(int valor) {
        Elemento novo = new Elemento(valor);
        if(primeiro == null && ultimo == null){
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            this.ultimo.setProximo(novo);
            this.ultimo = novo;
        }
        this.tamanho++;
    }

    public Elemento get(int posicao){
        Elemento atual = this.primeiro;
        for(int i = 0; i < posicao; i++){
            if(atual.getProximo() != null){
                atual = atual.getProximo();
            }
        }
        return atual;
    }
}