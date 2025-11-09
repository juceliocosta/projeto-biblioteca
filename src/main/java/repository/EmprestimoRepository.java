package repository;

import entity.Emprestimo;
import entity.Livro;
import entity.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmprestimoRepository {
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public void registrarEmprestimo(Emprestimo emprestimo){
        emprestimos.add(emprestimo);
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
}
