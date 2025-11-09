import entity.Leitor;
import entity.Usuario;
import view.Autenticacao;

import static view.Console.entrada;
import static view.Console.mensagem;

public class StartApp {
    public static void main(String[] args) {
        Autenticacao autenticacao = new Autenticacao();

        while (true){
            Usuario usuario = autenticacao.logar();
            if (usuario.getTipo_usuario().equals("Leitor")){
                mensagem("é um leitor");
            } else if (usuario.getTipo_usuario().equals("Admin")) {
                mensagem("é Administrador");
            }else{
                mensagem("erro");
            }

            String sair = entrada("Deseja sair? (s) Sim (N) Não: ");
            if(sair.equalsIgnoreCase("s")) break;
        }
    }
}
