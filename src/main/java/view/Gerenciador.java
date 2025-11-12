package view;

import entity.Administrador;
import entity.Livro;
import repository.EmprestimoRepository;
import repository.LivroRepository;

import java.util.Optional;

import static view.Utilitarios.entrada;
import static view.Utilitarios.mensagem;

public class Gerenciador {

    public void exibirGerenciador(EmprestimoRepository emprestimos, LivroRepository livros, Administrador usuario){
        String opcao = "1";

        while (!opcao.equals("0")) {
            opcao = entrada("""
                    (1) Adicionar Livro
                    (2) Remover Livro
                    (3) Atualizar Livro
                    (4) Histórico
                    (5) Histórico por Usuario
                    (6) Controle de Devolução
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
                        if(livros.registrarLivro(livro)) mensagem("Livro Registrado!");
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
                            if (livros.removerLivro(livro.get())) mensagem("Livro Removido!");
                        }
                    } catch (NumberFormatException e){
                        mensagem("ID Inválido!");
                    }

                }
                case "3" -> {
                }
                case "4" -> {
                }
                case "5" -> {
                }
                case "6" -> {
                }
                case "0" -> mensagem("Administrador " + usuario.getNome() + " Desconectado");
                default -> mensagem("Valor Inválido!");
            }
        }
    }
}
