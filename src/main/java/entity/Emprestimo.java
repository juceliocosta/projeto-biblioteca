package entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private static final double VALOR_MULTA_DIARIA = 2.0;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private Livro livro;
    private Usuario usuario;

    public Emprestimo(Livro livro, Usuario usuario) {
        LocalDate dataDeHoje = LocalDate.now();
        LocalDate dataDevolucao = dataDeHoje.plusDays(15);

        this.dataEmprestimo = dataDeHoje;
        this.dataDevolucao = dataDevolucao;
        this.livro = livro;
        this.usuario = usuario;
    }

    public double calcularMulta() {
        if (dataDevolucao == null) {
            return 0.0;
        }

        LocalDate dataDeHoje = LocalDate.now();

        if (!dataDeHoje.isAfter(dataDevolucao)) {
            return 0.0;
        }

        long diasAtraso = ChronoUnit.DAYS.between(dataDevolucao, dataDeHoje);
        return diasAtraso * VALOR_MULTA_DIARIA;
    }


    // ----------getters e setters----------

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}