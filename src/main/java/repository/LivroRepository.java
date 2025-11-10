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
                    new Livro(1, "Java Efetivo", "Joshua Bloch", 1),
                    new Livro(2, "UML 2 - Uma Abordagem Prática", "Gilleanes T. A. Guedes", 2)
            )
    );


    public void registrarLivro(Livro livro){
        livros.add(livro);
    }

    public String listarLivros() {
        return livros.stream()
                .map(l -> "ID: "+l.getId()+" , Título: "+l.getTitulo())
                .collect(Collectors.joining("\n"));
    }

    public Optional<Livro> encontrarLivro(int ID){
        return livros.stream()
                .filter(l -> l.getId() == ID)
                .findFirst();
    }

    public Optional<String> detalharLivro(int ID){
        return livros.stream()
                .filter(l -> l.getId() == ID)
                .findFirst()
                .map(l->"ID: "+l.getId()+"\nTítulo: "+l.getTitulo()+"\nAutor: "+l.getAutor()+"\nQuantidade: "+l.getQuantidade());
    }
}
