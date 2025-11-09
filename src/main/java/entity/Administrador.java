package entity;

public class Administrador extends Usuario {

    public Administrador(String id, String nome, String senha) {
        super(id, nome, senha, "Admin");
    }
}