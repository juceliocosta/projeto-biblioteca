package entity;

import repository.LivroRepository;

import java.util.Optional;

public class Leitor extends Usuario {
        public Leitor(String id, String nome, String senha) {
        super(id, nome, senha, "Leitor");
    }

    public String listarlivros(LivroRepository lr){
        return lr.listarLivros();
    }
    public Optional<String> detalharLivro(LivroRepository lr, int ID){
            return lr.detalharLivro(ID);
    }
}