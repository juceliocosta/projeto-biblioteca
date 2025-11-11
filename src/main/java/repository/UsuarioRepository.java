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
                    new Administrador("admin", "admin"),
                    new Leitor( "jucelio", "123")
            )
    );


    public boolean registrar(Usuario usuario){
        Optional<Usuario> user = buscarPorLogin(usuario.getNome(), usuario.getSenha());
        if (user.isEmpty()) return usuarios.add(usuario);
        return false;
    }
    public Optional<Usuario> buscar(String ID){
        return usuarios.stream()
                .filter(u->u.getId().equals(ID))
                .findFirst();
    }
    public void remover(Usuario usuario){
        usuarios.remove(usuario);
    }


    public Optional<Usuario> buscarPorLogin(String nome, String senha){
        return usuarios.stream()
                .filter(u -> u.getNome().equals(nome) && Objects.equals(u.getSenha(), senha))
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
