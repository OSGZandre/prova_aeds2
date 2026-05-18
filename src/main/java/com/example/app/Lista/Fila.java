package com.example.app.Lista;

public class Fila<E>{
	private ListaEncadeada<E> lista;

	public void enfileirar(E novo){
		this.lista.adicionar(novo);
	}

	public void remover(){
		this.lista.remover(this.get());
	}

	public E get(){
		return this.lista.getPrimeiro().getValor();
	}

	public void concatenar(Fila<E> fila){
		Elemento<E> atual = fila.lista.getPrimeiro();

		for(int i = 0; i < fila.lista.getTamanho(); i++){
				this.enfileirar(atual.getValor());
				atual  = atual.getProximo();
		}
	}

	public int tamanho(){
		return this.lista.getTamanho();
	}

	public boolean verificarExistencia(E valorProcurado){
		Elemento<E> atual = this.lista.getPrimeiro();
		for(int i = 0; i < this.lista.getTamanho(); i++){
			if(atual.getValor().equals(valorProcurado)){
				return true;
			}
		}
		return false;
	}

	public int obterNumItensAFrente(E item)throws Exception{
		Elemento<E> atual = this.lista.getPrimeiro();
		int contador = 0;
		for(int i = 0; i < this.lista.getTamanho(); i++){
			if(atual.getValor().equals(item)){
				return contador;
			} else {
			contador++;
			atual = atual.getProximo();
			} 
		}
	throw new Exception("Item não encontrado na fila");
	}

	public Fila<E> copiar(){
		Fila<E> novaFila = new Fila<>();
		Elemento<E> atual = this.lista.getPrimeiro();
		for(int i = 0; i < this.lista.getTamanho(); i++){
			novaFila.enfileirar(atual.getValor());
			atual = atual.getProximo();
		}
		return novaFila;
	}

	public Fila<E> dividir(){
		Fila<E> novaFila = new Fila<>();
		Elemento<E> atual = this.lista.getPrimeiro();
		int meio = this.lista.getTamanho() / 2;
		for(int i = 0; i < meio; i++){
			novaFila.enfileirar(atual.getValor());
			atual = atual.getProximo();
		}
		return novaFila;
	}
}