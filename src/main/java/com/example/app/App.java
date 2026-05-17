package com.example.app;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        IteratorListaLigada<Integer> iterador = lista.iterator();
        while(iterador.temProximo()){
            iterador.getProximo(); 
        }
        
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Digite o valor a ser adicionado: ");
                int valor = scanner.nextInt();
                lista.adicionar(valor);
                scanner.nextLine();

                System.out.println("Valor adicionado com sucesso! Tamanho: " + lista.getTamanho());
                System.out.print("Deseja adicionar mais um valor? (s/n): ");
                String resposta = scanner.nextLine().trim();
                if (!resposta.equalsIgnoreCase("s")) {
                    break;
                }
            }
        }
        System.out.println("Iterando sobre a lista:");
        if (lista.getTamanho() == 0) {
            System.out.println("Lista vazia.");
            return;
        }
        lista.remover(20);
        lista.remover(80);
        System.out.println("tamanho: " + lista.getTamanho());
        System.out.println("Primeiro: " + lista.getPrimeiro().getValor() + " | tamanho: " + lista.getTamanho());
        System.out.println("Último: " + lista.getUltimo().getValor() + " | tamanho: " + lista.getTamanho());
        for (int i = 0; i < lista.getTamanho(); i++) {
            System.out.println(i + " " +lista.get(i).getValor());
        }


    }
}
