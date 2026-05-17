package com.example.app;

public class IteratorListaLigada<E> {
    private Elemento<E> elemento;


    public IteratorListaLigada(Elemento<E> elemento) {
        this.elemento = elemento;
    }
    
    public Boolean temProximo(){
        if(elemento.getProximo() == null){
            return false;
        } else {
            return true;
        }
    }

    public Elemento<E> getProximo(){
        return elemento.getProximo();
    }
}
