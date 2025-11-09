package view;

import entity.Livro;
import entity.Usuario;
import repository.LivroRepository;

import java.util.Optional;

import static view.Console.entrada;
import static view.Console.mensagem;

public class Catalogo {
    public void exibirCatalogo(Usuario usuario){
        LivroRepository livros = new LivroRepository();
        String opcao = "1";

        while (!opcao.equals("0")){
            opcao = entrada("""
                    (1) Consultar Livros
                    (2) Realizar empréstimo
                    (3) Devolver Livro
                    (4) Consultar detalhe do Livro
                    (5) Consultar Emprestimos e Devoluções
                    (6) Exibir Controle de devolução
                    (7) Exibir Histórico
                    (0) Sair
                      Opção:\s"""
            );

            switch (opcao) {
                case "1" -> livros.listarLivros();
                case "2" -> {
                    try {
                        livros.listarLivros();
                        int ID = Integer.parseInt(entrada("ID do Livro: "));
                        Optional<Livro> livro = livros.encontrarLivro(ID);

                        livro.ifPresent(usuario::registrarEmprestimo);
                        if (livro.isPresent()) {
                            usuario.registrarEmprestimo(livro.get());
                            mensagem("Empréstimo Realizado!");
                        }
                        if (livro.isEmpty()) mensagem("Livro não Existente!");
                    } catch (NumberFormatException e) {
                        mensagem("Valor Inválido!");
                    }
                }
                case "3" -> {
                }
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
