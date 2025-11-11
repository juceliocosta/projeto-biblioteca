import entity.Usuario;
import repository.EmprestimoRepository;
import repository.LivroRepository;
import repository.UsuarioRepository;
import view.Autenticacao;
import view.Catalogo;

import static view.Utilitarios.entrada;
import static view.Utilitarios.mensagem;

public class StartApp {
    public static void main(String[] args) {
        UsuarioRepository usuarios = new UsuarioRepository();
        EmprestimoRepository emprestimos = new EmprestimoRepository();
        LivroRepository livros = new LivroRepository();

        Autenticacao autenticacao = new Autenticacao();

        while (true){
            Usuario usuario = autenticacao.logar(usuarios);

            if (usuario.getTipo_usuario().equals("Leitor")) {
                Catalogo catalogo = new Catalogo();
                catalogo.exibirCatalogo(emprestimos, livros, usuario);
            }
            else if (usuario.getTipo_usuario().equals("Admin")) {
                System.out.println("Gerenciador em manutenção");
            }
            else mensagem("erro");



            String sair = entrada("Deseja sair? (s) Sim (N) Não: ");
            if(sair.equalsIgnoreCase("s")) break;
        }
    }
}
