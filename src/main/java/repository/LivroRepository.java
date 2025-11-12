package repository;
import entity.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LivroRepository {

    //simulei alguns livros para não ter que ficar inserindo
    private final List<Livro> livros = new ArrayList<>(
            List.of(
                    new Livro("Java Efetivo", "Joshua Bloch", 1),
                    new Livro("UML 2 - Uma Abordagem Prática", "Gilleanes T. A. Guedes", 2)
            )
    );


    public boolean registrarLivro(Livro livro){
        return livros.add(livro);
    }

    public boolean removerLivro(Livro livro){
        return livros.remove(livro);
    }

    public String listarLivros() {
        return livros.stream()
                .map(l -> "ID: "+l.getId()+
                        " Qnt: "+l.getQuantidade()+
                        " , Título: "+l.getTitulo())
                .collect(Collectors.joining("\n"));
    }

    public Optional<Livro> encontrarLivro(int ID){
        return livros.stream()
                .filter(l -> l.getId() == ID)
                .findFirst();
    }
}
