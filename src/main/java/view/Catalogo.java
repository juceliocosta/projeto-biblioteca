package view;

import entity.Emprestimo;
import entity.Leitor;
import entity.Livro;
import repository.EmprestimoRepository;
import repository.LivroRepository;

import java.util.Optional;

import static view.Utilitarios.entrada;
import static view.Utilitarios.mensagem;

public class Catalogo {
    public void exibirCatalogo(EmprestimoRepository emprestimos, LivroRepository livros, Leitor usuario){
        String opcao = "1";

        while (!opcao.equals("0")){
            opcao = entrada("""
                    (1) Consultar Livros
                    (2) Realizar empréstimo
                    (3) Devolver Livro
                    (4) Consultar detalhe do Livro
                    (5) Consultar Emprestimos e Devoluções
                    (0) Sair
                      Opção:\s"""
            );

            switch (opcao) {
                case "1" -> mensagem(livros.listarLivros(), false);
                case "2" -> {
                    try {
                        mensagem(livros.listarLivros(), false);
                        int ID = Integer.parseInt(entrada("ID do Livro: "));
                        Optional<Livro> livro = livros.encontrarLivro(ID);

                        if (livro.isPresent()) {
                            boolean registrado = usuario.registrarEmprestimo(livro.get(), emprestimos);
                            if (registrado) mensagem("Empréstimo Realizado!");
                            else mensagem("Livro Indisponível no momento");
                        }
                        if (livro.isEmpty()) mensagem("ID Inválido!");
                    } catch (NumberFormatException e) {
                        mensagem("ID Inválido!");
                    }
                }
                case "3" -> {
                    mensagem(usuario.listarEmprestimos(emprestimos), false);
                    if (usuario.temEmprestimos(emprestimos)){
                        try {
                            String ID = entrada("ID do Livro: ");
                            Optional<Livro> livro = livros.encontrarLivro(Integer.parseInt(ID));
                            if (livro.isPresent()) {
                                Livro livroEncontrado = livro.get();
                                usuario.registrarDevolucao(livroEncontrado, emprestimos);
                                //verificar o emprestimo se a devolução passou dos 15 dias e aplicar a multa
                                Optional<Emprestimo> emprestimo =  emprestimos.encontrarEmprestimo(livro.get(), usuario);
                                if (emprestimo.isPresent()){
                                    double multa = emprestimo.get().calcularMulta();
                                    if (multa > 0) mensagem("Livro Devolvido: \nTitulo: "+
                                            livroEncontrado.getTitulo()+
                                            "Multa por Atraso: "+String.format("%.2f", multa));
                                }
                                mensagem("Livro Devolvido: \nTitulo: " + livroEncontrado.getTitulo());
                            } else mensagem("ID inválido");

                        } catch (NumberFormatException e){
                            mensagem("ID inválido!");
                        }
                    }
                }
                case "4" -> {
                    mensagem(livros.listarLivros(), false);
                    try {
                        int ID = Integer.parseInt(entrada("ID do Livro: "));
                        Optional<Livro> livro = livros.encontrarLivro(ID);

                        livro.ifPresent(value ->
                                mensagem(value.detalharLivro(), false));
                    } catch (NumberFormatException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "5" -> mensagem(usuario.listarEmprestimos(emprestimos), false);
                case "0" -> mensagem("Usuário "+usuario.getNome()+" Desconectado");
                default -> mensagem("Valor Inválido!");
            }
        }

    }

}

/*
Catálogo de Livros:
Leitores podem consultar o catálogo de livros, realizar empréstimos e devoluções.
Consultar detalhes dos livros (autor, título, disponibilidade).
Empréstimos e Devoluções:
Registro de empréstimos e devoluções de livros.
Controle de data de devolução e cálculo de multa por atraso.
Histórico:
 */
