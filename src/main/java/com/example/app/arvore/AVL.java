package com.example.app.arvore;

public class AVL<E extends Comparable<E>> extends ABB<E> {

	public AVL() {
		super();
	}

	@Override
	protected No<E> adicionar(No<E> raizArvore, E item) {
		return balancear(super.adicionar(raizArvore, item));
	}

	@Override
	protected No<E> removerNoAntecessor(No<E> itemRetirar, No<E> raizArvore) {
		return balancear(super.removerNoAntecessor(itemRetirar, raizArvore));
	}

	@Override
	protected No<E> remover(No<E> raizArvore, E itemRemover) {
		return balancear(super.remover(raizArvore, itemRemover));
	}

	private No<E> balancear(No<E> raizArvore) {

		int fatorBalanceamento;
		int fatorBalanceamentoFilho;

		if (raizArvore != null) {

			fatorBalanceamento = raizArvore.getFatorBalanceamento();

			if (fatorBalanceamento == 2) {
				fatorBalanceamentoFilho = raizArvore.getEsquerda().getFatorBalanceamento();
				if (fatorBalanceamentoFilho == -1)
					raizArvore.setEsquerda(rotacionarEsquerda(raizArvore.getEsquerda()));
				raizArvore = rotacionarDireita(raizArvore);
			} else if (fatorBalanceamento == -2) {
				fatorBalanceamentoFilho = raizArvore.getDireita().getFatorBalanceamento();
				if (fatorBalanceamentoFilho == 1)
					raizArvore.setDireita(rotacionarDireita(raizArvore.getDireita()));
				raizArvore = rotacionarEsquerda(raizArvore);
			} else
				raizArvore.setAltura();
		}
		return raizArvore;
	}

	private No<E> rotacionarDireita(No<E> noDesbalanceado) {

		No<E> novoNoRaiz;
		No<E> subArvoreDoMeio;

		novoNoRaiz = noDesbalanceado.getEsquerda();
		subArvoreDoMeio = novoNoRaiz.getDireita();

		noDesbalanceado.setEsquerda(subArvoreDoMeio);
		novoNoRaiz.setDireita(noDesbalanceado);

		noDesbalanceado.setAltura();
		novoNoRaiz.setAltura();

		return novoNoRaiz;
	}

	private No<E> rotacionarEsquerda(No<E> noDesbalanceado) {

		No<E> novoNoRaiz;
		No<E> subArvoreDoMeio;

		novoNoRaiz = noDesbalanceado.getDireita();
		subArvoreDoMeio = novoNoRaiz.getEsquerda();

		noDesbalanceado.setDireita(subArvoreDoMeio);
		novoNoRaiz.setEsquerda(noDesbalanceado);

		noDesbalanceado.setAltura();
		novoNoRaiz.setAltura();

		return novoNoRaiz;
	}
}
