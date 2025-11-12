package repository;

import entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public Optional<Emprestimo> encontrarEmprestimo(Livro livro, Usuario usuario){
        return emprestimos.stream()
                .filter(e -> e.getLivro().equals(livro) && Objects.equals(e.getUsuario(), usuario))
                .findFirst();
    }

    public List<Emprestimo> listarEmprestimos(Usuario usuario){
        return emprestimos.stream()
                .filter(e -> e.getUsuario().equals(usuario))
                .toList();
    }

    public List<Emprestimo> listarEmprestimos(){
        return emprestimos.stream().toList();
    }
}
