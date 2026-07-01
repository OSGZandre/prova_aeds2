package com.example.app.arvore;

import java.util.NoSuchElementException;

public class ABB<E extends Comparable<E>> {

	private No<E> raiz;

	public ABB() {
		raiz = null;
	}

	public Boolean vazia() {
		return (this.raiz == null);
	}

	private E pesquisar(No<E> raizArvore, E procurado) {

		int comparacao;

		if (raizArvore == null)
			throw new NoSuchElementException("O item não foi localizado na árvore!");

		comparacao = procurado.compareTo(raizArvore.getItem());

		if (comparacao == 0)
			return raizArvore.getItem();
		else if (comparacao < 0)
			return pesquisar(raizArvore.getEsquerda(), procurado);
		else
			return pesquisar(raizArvore.getDireita(), procurado);
	}

	public E pesquisar(E procurado) {
		return pesquisar(this.raiz, procurado);
	}

	protected No<E> adicionar(No<E> raizArvore, E item) {

		int comparacao;

		if (raizArvore == null)
			raizArvore = new No<>(item);
		else {
			comparacao = item.compareTo(raizArvore.getItem());

			if (comparacao < 0)
				raizArvore.setEsquerda(adicionar(raizArvore.getEsquerda(), item));
			else if (comparacao > 0)
				raizArvore.setDireita(adicionar(raizArvore.getDireita(), item));
			else
				throw new RuntimeException("O item já foi inserido anteriormente na árvore.");
		}

		return raizArvore;
	}

	public void adicionar(E item) {
		this.raiz = adicionar(this.raiz, item);
	}

	public void caminhamentoEmOrdem() {

		if (vazia())
			throw new IllegalStateException("A árvore está vazia!");

		caminhamentoEmOrdem(this.raiz);
	}

	private void caminhamentoEmOrdem(No<E> raizArvore) {
		if (raizArvore != null) {
			caminhamentoEmOrdem(raizArvore.getEsquerda());
			System.out.println(raizArvore.getItem());
			caminhamentoEmOrdem(raizArvore.getDireita());
		}
	}

	public void caminhamentoPreOrdem() {

		if (vazia())
			throw new IllegalStateException("A árvore está vazia!");

		caminhamentoPreOrdem(this.raiz);
	}

	private void caminhamentoPreOrdem(No<E> raizArvore) {
		if (raizArvore != null) {
			System.out.println(raizArvore.getItem());
			caminhamentoPreOrdem(raizArvore.getEsquerda());
			caminhamentoPreOrdem(raizArvore.getDireita());
		}
	}

	public void caminhamentoPosOrdem() {

		if (vazia())
			throw new IllegalStateException("A árvore está vazia!");

		caminhamentoPosOrdem(this.raiz);
	}

	private void caminhamentoPosOrdem(No<E> raizArvore) {
		if (raizArvore != null) {
			caminhamentoPosOrdem(raizArvore.getEsquerda());
			caminhamentoPosOrdem(raizArvore.getDireita());
			System.out.println(raizArvore.getItem());
		}
	}

	protected No<E> removerNoAntecessor(No<E> itemRetirar, No<E> raizArvore) {
		if (raizArvore.getDireita() != null)
			raizArvore.setDireita(removerNoAntecessor(itemRetirar, raizArvore.getDireita()));
		else {
			itemRetirar.setItem(raizArvore.getItem());
			raizArvore = raizArvore.getEsquerda();
		}
		return raizArvore;
	}

	protected No<E> remover(No<E> raizArvore, E itemRemover) {

		int comparacao;

		if (raizArvore == null)
			throw new NoSuchElementException("O item a ser removido não foi localizado na árvore!");

		comparacao = itemRemover.compareTo(raizArvore.getItem());

		if (comparacao == 0) {
			if (raizArvore.getDireita() == null)
				raizArvore = raizArvore.getEsquerda();
			else if (raizArvore.getEsquerda() == null)
				raizArvore = raizArvore.getDireita();
			else
				raizArvore.setEsquerda(removerNoAntecessor(raizArvore, raizArvore.getEsquerda()));
		} else if (comparacao < 0)
			raizArvore.setEsquerda(remover(raizArvore.getEsquerda(), itemRemover));
		else
			raizArvore.setDireita(remover(raizArvore.getDireita(), itemRemover));

		return raizArvore;
	}

	public void remover(E itemRemover) {
		this.raiz = remover(this.raiz, itemRemover);
	}
	
	public boolean ehAVL() {
		return ehAVL(this.raiz);
	}

	private boolean ehAVL(No<E> no) {
		if (no == null) {
			return true;
		}
		int fb = no.getFatorBalanceamento();
		if (fb < -1 || fb > 1) {
			return false;
		}
		return ehAVL(no.getEsquerda()) && ehAVL(no.getDireita());
	}
}
