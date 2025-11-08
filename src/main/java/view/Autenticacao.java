package view;

import repository.UsuarioRepository;
import java.util.Objects;
import static view.Console.*;

public class Autenticacao {
    UsuarioRepository usuarios = new UsuarioRepository();

    public boolean autenticar(){
        boolean autenticado = false;
        String opcao = entrada("(1) Fazer login\n(2) Cadastrar-se\nOpção: ");

        if (Objects.equals(opcao, "1")) autenticado = logar();
        else if (Objects.equals(opcao, "2")) return cadastrar();
        else mensagem("Valor Inválido");
        return autenticado;
    }

    private boolean logar(){
        boolean logado;
        String nome = entrada("Nome do Usuario: ");
        String senha = entrada("Senha: ");

        logado = usuarios.eCadastrado(nome, senha);

        if(logado) {
            mensagem("Usuário Logado");
            return true;
        }
        else mensagem("Usuário não Cadastrado");
        return logado;
    }

    private boolean cadastrar(){
        boolean cadastrado;
        String nome = entrada("Nome do Usuário: ");
        String senha = entrada("Senha do Usuário: ");

        cadastrado = usuarios.eCadastrado(nome, senha);

        if (cadastrado) mensagem("Usuário Já está Cadastrado!");
        else mensagem("Usuário Cadastrado");
        return cadastrado;
    }
}
