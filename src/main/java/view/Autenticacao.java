package view;

import entity.Leitor;
import entity.Usuario;
import repository.UsuarioRepository;
import java.util.Objects;
import java.util.Optional;

import static view.Console.*;

public class Autenticacao {
    UsuarioRepository usuarios = new UsuarioRepository();

    public Usuario logar(){
        Usuario usuario;
        while (true){
            String opcao = entrada("(1) Fazer login\n(2) Cadastrar-se\nOpção: ");

            if (Objects.equals(opcao, "1")) {
                String nome = entrada("Nome do Usuario: ");
                String senha = entrada("Senha: ");
                Optional<Usuario> user = usuarios.selecionaPorLogin(nome, senha);
                if (user.isPresent()) {
                    mensagem("Usuário Logado");
                    return user.get();
                } else {
                    mensagem("Usuário não Cadastrado");
                }
            }
            else if (Objects.equals(opcao, "2")) {
                String nome = entrada("Nome do Usuário: ");
                String senha = entrada("Senha do Usuário: ");
                Optional<Usuario> user = usuarios.selecionaPorLogin(nome, senha);
                if (user.isPresent()) {
                    mensagem("Usuário Já cadastrado");
                    return user.get();
                } else {
                    mensagem("Cadastro de Usuário Leitor");
                    String idUser = entrada("Id do Usuário: ");
                    String nomeUser = entrada("Nome do Usuário: ");
                    String senhaUser = entrada("Senha do Usuário: ");

                    usuario = new Leitor(idUser, nomeUser, senhaUser);
                    usuarios.cadastrar(usuario);
                    return usuario;
                }
            }
            else mensagem("Valor Inválido");
        }
    }
}
