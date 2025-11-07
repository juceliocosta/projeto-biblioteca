package repository;

import entity.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroRepository {

    //simulei alguns livros para não ter que ficar inserindo
    private List<Livro> livros = new ArrayList<Livro>(
            List.of(
                    new Livro(1, "Java Efetivo", "Joshua Bloch", 1),
                    new Livro(2, "UML 2 - Uma Abordagem Prática", "Gilleanes T. A. Guedes", 2)
            )
    );


    public void registrarLivro(Livro livro){
        livros.add(livro);
    }
}
