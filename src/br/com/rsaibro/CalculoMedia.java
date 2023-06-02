package br.com.rsaibro;

public class CalculoMedia {
    public static void main(String[] args) {
        // Definindo um conjunto de números
        int[] numeros = { 5, 10, 15, 20, 25 };

        // Calculando a média
        double media = calcularMedia(numeros);

        // Exibindo o resultado
        System.out.println("A média é: " + media);
    }

    public static double calcularMedia(int[] numeros) {
        int soma = 0;
        int quantidade = numeros.length;

        for (int i = 0; i < quantidade; i++) {
            soma += numeros[i];
        }

        double media = (double) soma / quantidade;
        return media;
    }
}