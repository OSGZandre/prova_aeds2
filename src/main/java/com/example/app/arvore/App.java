package com.example.app.arvore;

public class App {
	public static void main(String[] args) {
		System.out.println("=== ABB comum ===");
		ABB<Integer> abb = new ABB<>();
		abb.adicionar(10);
		abb.adicionar(8);
		abb.adicionar(5);
		System.out.println("ehAVL? " + abb.ehAVL());
		abb.caminhamentoPreOrdem();

		System.out.println("\n=== AVL: rotacao simples (40, 20, 10) ===");
		AVL<Integer> avl1 = new AVL<>();
		avl1.adicionar(40);
		avl1.adicionar(20);
		avl1.adicionar(10);
		System.out.println("ehAVL? " + avl1.ehAVL());
		System.out.println("Pre-ordem (esperado: 20 10 40):");
		avl1.caminhamentoPreOrdem();

		System.out.println("\n=== AVL: rotacao dupla (50, 20, 35) ===");
		AVL<Integer> avl2 = new AVL<>();
		avl2.adicionar(50);
		avl2.adicionar(20);
		avl2.adicionar(35);
		System.out.println("ehAVL? " + avl2.ehAVL());
		System.out.println("Pre-ordem (esperado: 35 20 50):");
		avl2.caminhamentoPreOrdem();
	}
}
