package app;

import model.Conversoes;
import service.BuscadorMoeda;
import service.Cambio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BuscadorMoeda buscador = new BuscadorMoeda();
        Cambio cambio = new Cambio();

        double resultado;
        int sair = 0;

        System.out.println("Seja bem vindo(a) ao conversor de moedas!");

        while (sair != 1) {
            System.out.println("*****************************************************");
            System.out.println("""
                    1 - Dólar >>> Real              7 - Euro >>> Real
                    2 - Real >>> Dólar              8 - Real >>> Euro
                    3 - Iene >>> Real               9 - Dólar Canadense >>> Real
                    4 - Real >>> Iene              10 - Real >>> Dólar Canadense
                    5 - Peso Argentino >>> Real    11 - Euro >>> Dólar
                    6 - Real >>> Peso Argentino    12 - Dólar >>> Euro
                    
                    13 - Sair
                    """);
            System.out.println("Escolha uma operação válida");
            int operacao = scanner.nextInt();
            System.out.println("*****************************************************");

            if (operacao == 13) {
                break;
            }

            System.out.println("Informe o valor que deseja converter: ");
            double valor = scanner.nextDouble();

            String moedaOrigem = "", moedaDestino= "";

            switch (operacao) {
                case 1: moedaOrigem = "USD"; moedaDestino = "BRL"; break;
                case 2: moedaOrigem = "BRL"; moedaDestino = "USD"; break;
                case 3: moedaOrigem = "JPY"; moedaDestino = "BRL"; break;
                case 4: moedaOrigem = "BRL"; moedaDestino = "JPY"; break;
                case 5: moedaOrigem = "ARS"; moedaDestino = "BRL"; break;
                case 6: moedaOrigem = "BRL"; moedaDestino = "ARS"; break;
                case 7: moedaOrigem = "EUR"; moedaDestino = "BRL"; break;
                case 8: moedaOrigem = "BRL"; moedaDestino = "EUR"; break;
                case 9: moedaOrigem = "CAD"; moedaDestino = "BRL"; break;
                case 10: moedaOrigem = "BRL"; moedaDestino = "CAD"; break;
                case 11: moedaOrigem = "EUR"; moedaDestino = "USD"; break;
                case 12: moedaOrigem = "USD"; moedaDestino = "EUR"; break;
                default:
                    System.out.println("Operação inválida.");
                    sair = 1;
            }

            Conversoes conversao = buscador.converte(moedaOrigem);
            resultado = cambio.converter(valor, conversao, moedaDestino);

            System.out.println("O valor de " + valor + " [" + moedaOrigem + "] corresponde ao valor de " + resultado + " [" + moedaDestino + "]");
        }
        System.out.println("Finalizado com sucesso");

    }
}


