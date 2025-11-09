package repository;

import entity.Livro;

import java.util.ArrayList;
import java.util.List;

import static view.Console.clearScreen;
import static view.Console.mensagem;

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

    public void listarLivros(){
        clearScreen();
        livros.forEach(l ->{
            System.out.println("Titulo: "+l.getTitulo()+"\n");
        });
    }
    public void listarDetalhesLivros(){
        //String info = String.format("O item %s custa R$ %.2f.", item, preco);
        livros.forEach(l -> {
            String info = String.format("{ID: %d, Título: %s, Autor: %s, Quantidade: %d}",
                    l.getId(), l.getTitulo(), l.getAutor(), l.getQuantidade());
            System.out.println(info);
        });
    }
}
