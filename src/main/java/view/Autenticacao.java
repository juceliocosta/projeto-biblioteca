package view;

import entity.Leitor;
import entity.Usuario;
import repository.UsuarioRepository;
import java.util.Optional;

import static view.Utilitarios.*;

public class Autenticacao {
    public Usuario logar(UsuarioRepository usuarios){
        Usuario usuario;
        while (true){
            String opcao = entrada("(1) Fazer login\n(2) Cadastrar-se\nOpção: ");

            if (opcao.equals("1")) {
                String nome = entrada("Nome do Usuario: ");
                String senha = entrada("Senha: ");
                Optional<Usuario> user = usuarios.buscarPorLogin(nome, senha);
                if (user.isPresent()) {
                    mensagem(user.get().getTipo_usuario()+" "+user.get().getNome()+" Logado");
                    return user.get();
                }
                mensagem("Usuário não Cadastrado");
            }
            else if (opcao.equals("2")) {
                String nome = entrada("Nome do Usuário: ");
                String senha = entrada("Senha do Usuário: ");
                Optional<Usuario> user = usuarios.buscarPorLogin(nome, senha);
                if (user.isPresent()) {
                    mensagem("Usuário Já cadastrado");
                    return user.get();
                } else {
                    usuario = new Leitor(nome, senha);
                    if(usuarios.registrar(usuario)) {
                        mensagem("Usuário Leitor Cadastrado");
                        return usuario;
                    }
                    mensagem("Erro ao Cadastradar");
                }
            }
            else mensagem("Valor Inválido");
        }
    }
}
