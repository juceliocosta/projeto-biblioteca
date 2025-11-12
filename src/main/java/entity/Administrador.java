package entity;

import repository.EmprestimoRepository;
import repository.LivroRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Administrador extends Usuario {

    public Administrador(String nome, String senha) {
        super(nome, senha, "Administrador");
    }

    public boolean registrarLivro(LivroRepository livros, Livro livro){
        return livros.registrarLivro(livro);
    }

    public boolean removerLivro(LivroRepository livros, Livro livro){
        return livros.removerLivro(livro);
    }

    public boolean atualizarLivro(LivroRepository livros,int ID, String titulo, String autor, int quantidade){
        Optional<Livro> livro = livros.encontrarLivro(ID);
        if (livro.isPresent()){
            if (!titulo.equals("0")) livro.get().setTitulo(titulo);
            if (!autor.equals("0")) livro.get().setAutor(autor);
            if (quantidade != 0) livro.get().setQuantidade(quantidade);
            return true;
        }
        return false;
    }

    public String historicoUsuarios(EmprestimoRepository emprestimos){
        List<Emprestimo> lista = emprestimos.listarEmprestimos();
        if (lista.isEmpty()) return "\tLista Vazia";
        else return lista.stream()
                .map(e ->"ID: "+e.getUsuario().getId()+" | Usuário: "+e.getUsuario().getNome()+
                        "\nID: "+e.getLivro().getId()+" | Livro: "+ e.getLivro().getTitulo()+
                        "\nData de Empréstimo: "+ e.getDataEmprestimo()+
                        "\nData de Devolução: "+ Objects.toString(e.getDataDevolucao(), "Não Devolvido")+
                        "\nMulta por Atraso: "+e.calcularMulta()+
                        "\n----------------------------------------"
                )
                .collect(Collectors.joining("\n"));
    }
}