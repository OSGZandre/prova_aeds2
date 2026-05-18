package com.example.app.Lista;

import java.util.Scanner;

public class Polindromo {
	public static void main(String[] args) { 
        
	Scanner sc = new Scanner(System.in);

	    System.out.print("Digite uma palavra ou frase: ");
        String texto = sc.nextLine();

        // Remove espaços, acentos e deixa tudo minúsculo
        texto = texto
                .toLowerCase()
                .replace(" ", "");

        Pilha<Character> pilha = new Pilha<>();
        // Adiciona cada caractere do texto na pilha
        for(int i = 0; i < texto.length(); i++){
        	pilha.adicionar(texto.charAt(i));
        }

        boolean palindromo = true;
        // Verifica se a palavra ou frase é um palíndromo comparando os caracteres da pilha com os caracteres do texto
        for(int i = 0; i < texto.length(); i++){
        	if(texto.charAt(i) != pilha.remover()){
        		palindromo = false;
        		break;
        	}
        }

        System.out.println("É um palíndromo: " + palindromo);
        } 
}       