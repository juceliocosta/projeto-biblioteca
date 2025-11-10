package view;

import java.io.IOException;
import java.util.Scanner;

public class Console {
    /**
     * Faz a limpesa do console no Windows e Unix
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Exibe uma mensagem enfeitada no console
     * @param mensagem uma String
     */
    public static void mensagem(String mensagem){
        String barras = "========================================";
        clearScreen();
        System.out.println(barras+"\n"+"\t"+mensagem+"\n"+barras);
    }

    public static void mensagem(String mensagem, boolean tabulacao){
        String barras = "========================================";
        clearScreen();
        if (tabulacao) System.out.println(barras+"\n"+"\t"+mensagem+"\n"+barras);
        else System.out.println(barras+"\n"+mensagem+"\n"+barras);
    }

    /**
     * Exibe uma mensagem no console pedindo uma entrada
     *
     * @param mensagem uma String
     * @return uma String do valor digitado
     */
    public static String entrada(String mensagem){
        Scanner scan = new Scanner(System.in);
        System.out.print(mensagem);
        return scan.next();
    }
}
