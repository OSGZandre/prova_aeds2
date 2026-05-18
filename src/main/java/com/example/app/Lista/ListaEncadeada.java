package com.example.app.Lista;
public class ListaEncadeada<E> {
    private Elemento<E> primeiro;
    private Elemento<E> ultimo;
    private int tamanho;
    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }   

    public Elemento<E> getPrimeiro() {
        return primeiro;
    }
    public Elemento<E> getUltimo() {
        return ultimo;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setPrimeiro(Elemento<E> primeiro) {
        this.primeiro = primeiro;
    }
    public void setUltimo(Elemento<E> ultimo) {
        this.ultimo = ultimo;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void adicionar(E valor) {
        Elemento<E> novo = new Elemento<>(valor);
        //verifica se a lista está vazia, se estiver, o novo elemento é o primeiro e o último
        if(primeiro == null && ultimo == null){
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            this.ultimo.setProximo(novo);
            this.ultimo = novo;
        }
        this.tamanho++;
    }

    public void adicionarComeco(E valor){
         Elemento<E> novo = new Elemento<>(valor);
        //verifica se a lista está vazia, se estiver, o novo elemento é o primeiro e o último
        if(primeiro == null && ultimo == null){
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            novo.setProximo(this.primeiro);
            this.primeiro = novo;
        }
        this.tamanho++;
    }

    public Elemento<E> get(int posicao){
        Elemento<E> atual = this.primeiro;
        //percorre a lista até chegar na posição desejada, ou no final da lista
        for(int i = 0; i < posicao; i++){
            if(atual.getProximo() != null){
                atual = atual.getProximo();
            }
        }
        return atual;
    }

    public void remover(E valorProcurado){
        Elemento<E> anterior = null;
        Elemento<E> atual = this.primeiro;
        //for pra percorrer a lista
        for(int i = 0; i < this.getTamanho(); i++){
            if(atual.getValor().equals(valorProcurado)){
                // if pra verificar se é o único elemento da lista
                if(this.tamanho == 1){
                    this.primeiro = null;
                    this.ultimo = null;
                }
                // if pra verificar se é o primeiro elemento da lista
                if(atual == primeiro){
                    this.primeiro = atual.getProximo();
                    atual.setProximo(null);
                // if pra verificar se é o último elemento da lista
                } else if (atual == ultimo){
                    this.ultimo = anterior;
                    anterior.setProximo(null);
                // se for um elemento do meio da lista
                } else {
                    anterior.setProximo(atual.getProximo());
                    atual = null;
                }
                this.tamanho--;
                break;
            }
            anterior = atual;
            atual = atual.getProximo(); 
        }
    }

    public E removerInicio(){
        if(this.tamanho == 0){
            System.out.println("A lista está vazia");
            return null;
        }
        E removido = this.primeiro.getValor();

        this.primeiro = this.primeiro.getProximo();
        //verifica se a lista ficou vazia após a remoção, se sim, o último também deve ser null
        if(this.primeiro == null){
            this.ultimo = null;
        }
        
        this.tamanho--;
        return removido;
    }

    public IteratorListaLigada<E> iterator(){
        return new IteratorListaLigada<>(this.primeiro);
    }

    public void limpar(){
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void inserirFinal(E valor){
        Elemento<E> novo = new Elemento<>(valor);
        if(primeiro == null && ultimo == null){
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            this.ultimo.setProximo(novo);
            this.ultimo = novo;
        }
        this.tamanho++;
    }

    public void trocar(E itemX, E itemY){
        if(this.getTamanho() <= 1) {
            throw new IllegalStateException("A lista está vazia ou contém apenas 1 número.");
        }
        Elemento<E> atual = this.primeiro;
        Elemento<E> celulaX = null;
        Elemento<E> celulaY = null;
        for(int i = 0; i < this.tamanho; i++){
            if (atual.getValor().equals(itemX)) {
                celulaX = atual;
            }

            if(atual.getValor().equals(itemY)){
                celulaY = atual;
            }
            atual = atual.getProximo();
        }
        if (celulaX == null || celulaY == null) {
            throw new IllegalArgumentException("Um ou ambos os itens não foram encontrados.");
        }

        E temp = celulaX.getValor();
        celulaX.setValor(celulaY.getValor());
        celulaY.setValor(temp);
    }
}