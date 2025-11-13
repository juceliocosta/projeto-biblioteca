package view;

import java.util.Scanner;

public class Utilitarios {
    /**
     * Faz a limpesa do console no Windows e Unix
     */
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");//limpa se suporta ANSI
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("\n");
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

    /**
     * Exibe uma mensagem enfeitada no console
     * @param mensagem uma String
     * @param tabulacao false para remove-la
     */
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
