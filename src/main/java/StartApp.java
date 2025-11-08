import view.Autenticacao;

import static view.Console.entrada;

public class StartApp {
    public static void main(String[] args) {
        Autenticacao autenticacao = new Autenticacao();

        while (true){
            boolean autenticado = false;
            while (!autenticado) autenticado = autenticacao.autenticar();


            String sair = entrada("Deseja sair? (s) Sim (N) Não: ");
            if(sair.equalsIgnoreCase("s")) break;
        }
    }
}
