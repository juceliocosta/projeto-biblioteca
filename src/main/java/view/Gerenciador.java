package view;

import entity.Administrador;
import repository.EmprestimoRepository;
import repository.LivroRepository;

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
                }
                case "2" -> {
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
