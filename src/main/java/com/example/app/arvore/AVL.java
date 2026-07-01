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

	private No<E> rotacionarDireita(No<E> p) {

		No<E> u;
		No<E> filhoEsquerdaDireita;

		u = p.getEsquerda();
		filhoEsquerdaDireita = u.getDireita();

		p.setEsquerda(filhoEsquerdaDireita);
		u.setDireita(p);

		p.setAltura();
		u.setAltura();

		return u;
	}

	private No<E> rotacionarEsquerda(No<E> p) {

		No<E> z;
		No<E> filhoDireitaEsquerda;

		z = p.getDireita();
		filhoDireitaEsquerda = z.getEsquerda();

		p.setDireita(filhoDireitaEsquerda);
		z.setEsquerda(p);

		p.setAltura();
		z.setAltura();

		return z;
	}
}
