package repository;

import entity.Emprestimo;
import entity.Livro;
import entity.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmprestimoRepository {
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public boolean registrarEmprestimo(Emprestimo emprestimo){
        return emprestimos.add(emprestimo);
    }

    public void devolverEmprestimo(Livro livro, Usuario usuario) {
        Optional<Emprestimo> emprestimo = encontrarEmprestimo(livro, usuario);

        emprestimo.ifPresent(emprestimos::remove);
    }

    public Optional<Emprestimo> encontrarEmprestimo(Livro livro, Usuario usuario){
        return emprestimos.stream()
                .filter(e -> e.getLivro().equals(livro) && Objects.equals(e.getUsuario(), usuario))
                .findFirst();
    }

    public String listarEmprestimos(Usuario usuario){
        if (emprestimos.isEmpty()) return "Lista Vazia";
        else return emprestimos.stream()
                .filter(e -> e.getUsuario().getId().equals(usuario.getId()))
                .map(e -> "Livro: "+ e.getLivro().getTitulo()+
                        "\nData de Empréstimo: "+ e.getDataEmprestimo()+
                        "\nData de Devolução: "+ Objects.toString(e.getDataDevolucao(), "Sem Data")+
                        "\n----------------------------------------"
                )
                .collect(Collectors.joining("\n"));
    }

    public String listarEmprestimos(){
        if (emprestimos.isEmpty()) return "Lista Vazia";
        else return emprestimos.stream()
                .map(e -> "Livro: "+ e.getLivro().getTitulo()+
                        "\nData de Empréstimo: "+ e.getDataEmprestimo()+
                        "\n----------------------------------------"
                )
                .collect(Collectors.joining("\n"));
    }
}
