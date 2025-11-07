package repository;

import entity.Administrador;
import entity.Leitor;
import entity.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository {
    private List<Usuario> usuarios = new ArrayList<>(
            List.of(
                    new Administrador(1, "Admin"),
                    new Leitor(2, "jucelio")
            )
    );

    public void cadastrar(Usuario usuario){
        usuarios.add(usuario);
    }

    public void remover(Usuario usuario){
        usuarios.remove(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean eCadastrado(String nome, int id){
        return usuarios.stream()
                .anyMatch(u -> u.getNome().equals(nome) && u.getId() == id);
    }

    /*
    public Optional<Usuario> estaCadastrado(String nome, int id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getNome().equalsIgnoreCase(nome))
                .filter(usuario -> usuario.getId() == id)
                .findFirst();
    }*/
}
