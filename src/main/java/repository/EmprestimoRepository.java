package repository;

import entity.*;

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
        if (emprestimo.isEmpty()) return;
        emprestimo.get().setDataDevolucao();
    }

    public boolean removerEmprestimo(Emprestimo emprestimo){
        if (emprestimos.contains(emprestimo)) return emprestimos.remove(emprestimo);
        return false;
    }

    public Optional<Emprestimo> encontrarEmprestimo(Livro livro, Usuario usuario){
        return emprestimos.stream()
                .filter(e -> e.getLivro().equals(livro) && Objects.equals(e.getUsuario(), usuario))
                .findFirst();
    }

    public boolean temEmprestimo(){
        return emprestimos.isEmpty();
    }

    public List<Emprestimo> listarEmprestimos(Usuario usuario){
        return emprestimos.stream()
                .filter(e -> e.getUsuario().equals(usuario))
                .toList();
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
