package entity;

import repository.EmprestimoRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Leitor extends Usuario {
        public Leitor(String nome, String senha) {
        super(nome, senha, "Leitor");
    }

    public String listarEmprestimos(EmprestimoRepository emprestimos){
        List<Emprestimo> lista = emprestimos.listarEmprestimos(this);
        if (lista.isEmpty()) return "\tLista Vazia";
        else return lista.stream()
                .filter(e -> e.getUsuario().getId().equals(this.getId()))
                .map(e ->"ID: "+e.getLivro().getId()+
                        "\nLivro: "+ e.getLivro().getTitulo()+
                        "\nData de Empréstimo: "+ e.getDataEmprestimo()+
                        "\nData de Devolução: "+ Objects.toString(e.getDataDevolucao(), "Não Devolvido")+
                        "\nMulta por Atraso: "+e.calcularMulta()+
                        "\n----------------------------------------"
                )
                .collect(Collectors.joining("\n"));
    }
    public boolean temEmprestimos(EmprestimoRepository emprestimos){
        return !emprestimos.listarEmprestimos(this).isEmpty();
    }
}