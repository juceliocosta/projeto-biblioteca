package repository;

import entity.Emprestimo;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoRepository {
    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

    public void registrarEmprestimo(Emprestimo emprestimo){
        emprestimos.add(emprestimo);
    }
}
