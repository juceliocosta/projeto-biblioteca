package entity;

public class Administrador extends Usuario {

    public Administrador(int id, String nome, String senha) {
        super(id, nome, senha, "Admin");
    }
}