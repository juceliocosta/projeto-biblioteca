package view;

import entity.Usuario;
import repository.LivroRepository;

import static view.Console.entrada;

public class Catalogo {
    public void exibirCatalogo(Usuario usuario){
        String opcao = "1";

        while (!opcao.equals("0")){
            opcao = entrada("(1) Consultar Livros\n" +
                    "(2) Realizar empréstimo\n"+
                    "(3) Devolver Livro\n"+
                    "(4) Consultar detalhe do Livro\n"+
                    "(5) Consultar Emprestimos e Devoluções\n"+
                    "  Opção: "
            );

            if (opcao.equals("1")){
                LivroRepository livros = new LivroRepository();
                livros.listarLivros();
            } else if (opcao.equals("2")) {

            }
        }

    }

}

/*
Usuários (Admin e Leitor):

Administradores podem gerenciar o acervo (adicionar, remover e atualizar livros).
Leitores podem consultar o catálogo de livros, realizar empréstimos e devoluções.
Catálogo de Livros:

Adicionar e remover livros do catálogo.
Consultar detalhes dos livros (autor, título, disponibilidade).
Empréstimos e Devoluções:

Registro de empréstimos e devoluções de livros.
Controle de data de devolução e cálculo de multa por atraso.
Histórico:

Exibição do histórico de empréstimos por usuário.
 */
