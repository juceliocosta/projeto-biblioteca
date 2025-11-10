package view;

import entity.Livro;
import entity.Usuario;
import repository.EmprestimoRepository;
import repository.LivroRepository;

import java.util.Optional;

import static view.Console.entrada;
import static view.Console.mensagem;

public class Catalogo {
    public void exibirCatalogo(Usuario usuario){
        LivroRepository livros = new LivroRepository();
        EmprestimoRepository emprestimos = new EmprestimoRepository();
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
                        if (livro.isEmpty()) mensagem("Livro não Existente!");
                    } catch (NumberFormatException e) {
                        mensagem("Valor Inválido!");
                    }
                }
                case "3" -> {

                }
                case "4" -> {
                    mensagem(livros.listarLivros(), false);
                    try {
                        int ID = Integer.parseInt(entrada("ID do Livro: "));
                        Optional<String> livro = livros.detalharLivro(ID);

                        livro.ifPresent(l -> mensagem(l, false));
                        if (livro.isEmpty()) mensagem("Livro não Existente!");
                    } catch (NumberFormatException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "5" -> mensagem(emprestimos.listarEmprestimos(usuario), false);
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
