package com.example.app.Lista;
public class Pilha<E> {
	private ListaEncadeada<E> lista;

	public Pilha(){
		this.lista = new ListaEncadeada();
	}

	public void adicionar(E novo){
		this.lista.adicionarComeco(novo);
	}

	public E remover(){
		return this.lista.removerInicio();
	}

	public boolean vazia(){
    	return this.lista.getTamanho() == 0;
	}

	public E get(){
		return this.lista.getPrimeiro().getValor();
	}

	public void concatenar(Pilha<E> pilha){
		Pilha<E> tmp = new Pilha<>();
		//desempilha os elementos da pilha original para a pilha temporária, invertendo a ordem dos elementos
		while(!pilha.vazia()){
			tmp.adicionar(pilha.remover());
		}
		//desempilha os elementos da pilha temporária para a pilha original, restaurando a ordem original dos elementos
		while(!tmp.vazia()){
			E valor = tmp.remover();
			pilha.adicionar(valor);

			this.adicionar(valor);
		}
	}

	public int obterNumItens(){
		Elemento atual = this.lista.getPrimeiro();
		int contador = 0;
		while(!this.vazia()){
			contador++;
			atual = atual.getProximo();
		}
		return contador;
	}


	public void inverter(){
		Pilha<E> tmp = new Pilha<>();
		//desempilha os elementos da pilha original para a pilha temporária, invertendo a ordem dos elementos
		while(!this.vazia()){
			tmp.adicionar(this.remover());
		}
		this.lista = tmp.lista;
	}

	public Pilha<E> copiar(){
		Pilha<E> tmp = new Pilha<>();
		Pilha<E> copia = new Pilha<>();

		while(!vazia()){
			//remove o item da pilha original
			E item = remover();
			//adiciona o item na pilha temporária
			tmp.adicionar(item);
		}
		while(!tmp.vazia()){
			//remove o item da pilha temporária
			E item = tmp.remover();
			//adiciona o item na pilha de cópia
			copia.adicionar(item);
			//restaura a pilha original
			adicionar(item); 
		}
		return copia;
	}
}