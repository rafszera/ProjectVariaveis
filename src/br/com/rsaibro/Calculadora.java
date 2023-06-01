package br.com.rsaibro;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int escolha = 0;
        while (escolha < 1 || escolha > 5) {
            System.out.println("Selecione a operação desejada:");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Porcentagem");

            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                if (escolha < 1 || escolha > 5) {
                    System.out.println("Escolha inválida! Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida! Tente novamente.");
                scanner.next();
            }
        }

        double num1 = 0;
        double num2 = 0;

        boolean numerosValidos = false;
        while (!numerosValidos) {
            System.out.print("Digite o primeiro número: ");
            if (scanner.hasNextDouble()) {
                num1 = scanner.nextDouble();
                numerosValidos = true;
            } else {
                System.out.println("Entrada inválida! Tente novamente.");
                scanner.next();
            }
        }

        if (escolha != 5) {
            numerosValidos = false;
            while (!numerosValidos) {
                System.out.print("Digite o segundo número: ");
                if (scanner.hasNextDouble()) {
                    num2 = scanner.nextDouble();
                    numerosValidos = true;
                } else {
                    System.out.println("Entrada inválida! Tente novamente.");
                    scanner.next();
                }
            }
        }

        double resultado = 0;

        switch (escolha) {
            case 1:
                resultado = num1 + num2;
                break;
            case 2:
                resultado = num1 - num2;
                break;
            case 3:
                resultado = num1 * num2;
                break;
            case 4:
                resultado = num1 / num2;
                break;
            case 5:
                resultado = (num1 * num2) / 100;
                break;
            default:
                System.out.println("Escolha inválida!");
                return;
        }

        System.out.println("O resultado da operação é: " + resultado);
    }
}
