package repository;

import entity.Administrador;
import entity.Leitor;
import entity.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UsuarioRepository {
    private final List<Usuario> usuarios = new ArrayList<>(
            List.of(
                    new Administrador("1", "Admin", "admin"),
                    new Leitor("2", "jucelio", "123")
            )
    );

    public void cadastrar(Usuario usuario){
        usuarios.add(usuario);
    }

    public void remover(Usuario usuario){
        usuarios.remove(usuario);
    }

    public Optional<Usuario> selecionaPorLogin(String login, String senha){
        return usuarios.stream()
                .filter(u -> u.getNome().equals(login) && Objects.equals(u.getSenha(), senha))
                .findFirst();
    }

    public boolean eCadastrado(String nome, String senha){
        return usuarios.stream()
                .anyMatch(u ->
                        u.getNome().equals(nome) && Objects.equals(u.getSenha(), senha));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
