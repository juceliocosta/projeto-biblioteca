package view;

import entity.Administrador;
import entity.Livro;
import repository.EmprestimoRepository;
import repository.LivroRepository;

import java.util.Optional;

import static view.Utilitarios.entrada;
import static view.Utilitarios.mensagem;

public class Gerenciador {

    public void exibirGerenciador(EmprestimoRepository emprestimos, LivroRepository livros, Administrador admin){
        String opcao = "1";

        while (!opcao.equals("0")) {
            opcao = entrada("""
                    (1) Registrar Livro
                    (2) Remover Livro
                    (3) Atualizar Livro
                    (4) Exibir Histórico
                    (0) Sair
                      Opção:\s"""
            );

            switch (opcao) {
                case "1" -> {
                    try{
                        String titulo = entrada("Titulo do Livro: ");
                        String autor = entrada("Autor do Livro: ");
                        String quantidade = entrada("Quantidade de Livros: ");
                        Livro livro = new Livro(titulo, autor, Integer.parseInt(quantidade));
                        boolean registrado = admin.registrarLivro(livros, livro);
                        if(registrado) mensagem("Livro Registrado!");
                    } catch (NumberFormatException e){
                        mensagem("ID Inválido!");
                    }
                }
                case "2" -> {
                    try{
                        mensagem(livros.listarLivros(), false);
                        String ID = entrada("ID do Livro: ");
                        Optional<Livro> livro = livros.encontrarLivro(Integer.parseInt(ID));
                        if (livro.isPresent()) {
                            boolean removido = admin.removerLivro(livros, livro.get());
                            if (removido) mensagem("Livro Removido!");
                        }
                    } catch (NumberFormatException e){
                        mensagem("ID Inválido!");
                    }

                }
                case "3" -> {
                    try{
                        mensagem(livros.listarLivros(), false);
                        String ID = entrada("ID do Livro: ");
                        String titulo = entrada("\nDigite 0 para Cancelar\nEditar Titulo: ");
                        String autor = entrada("\nDigite 0 para Cancelar\nEditar Autor: ");
                        String qnt = entrada("\nDigite 0 para Cancelar\nEditar Quantidade: ");

                        boolean atualizado = admin.atualizarLivro(livros,
                                Integer.parseInt(ID), titulo, autor, Integer.parseInt(qnt));

                        if (atualizado) mensagem("Livro Atualizado!");
                        else mensagem("ID Inválido!");
                    } catch (NumberFormatException e){
                        mensagem("Entrada Inválida!");
                    }
                }
                case "4" -> {
                    String historico = admin.historicoUsuarios(emprestimos);
                    mensagem(historico, false);
                }
                case "0" -> mensagem("Administrador " + admin.getNome() + " Desconectado");
                default -> mensagem("Valor Inválido!");
            }
        }
    }
}
