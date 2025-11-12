import entity.Administrador;
import entity.Leitor;
import entity.Usuario;
import repository.EmprestimoRepository;
import repository.LivroRepository;
import repository.UsuarioRepository;
import view.Autenticacao;
import view.Catalogo;
import view.Gerenciador;

import static view.Utilitarios.*;

public class StartApp {
    public static void main(String[] args) {
        UsuarioRepository usuarios = new UsuarioRepository();
        EmprestimoRepository emprestimos = new EmprestimoRepository();
        LivroRepository livros = new LivroRepository();

        Autenticacao autenticacao = new Autenticacao();

        while (true){
            clearScreen();
            Usuario usuario = autenticacao.logar(usuarios);

            if (usuario.getTipo_usuario().equals("Leitor")) {
                Catalogo catalogo = new Catalogo();
                catalogo.exibirCatalogo(emprestimos, livros, (Leitor) usuario);
            }
            else if (usuario.getTipo_usuario().equals("Administrador")) {
                Gerenciador gerenciador = new Gerenciador();
                gerenciador.exibirGerenciador(emprestimos, livros, (Administrador) usuario);
                System.out.println("Gerenciador em manutenção");
            }
            else mensagem("erro");



            String sair = entrada("Deseja sair? (s) Sim (N) Não: ");
            if(sair.equalsIgnoreCase("s")) break;
        }
    }
}
