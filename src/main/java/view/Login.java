package view;
import repository.UsuarioRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    Scanner scan = new Scanner(System.in);
    UsuarioRepository usuarios = new UsuarioRepository();

    public boolean fazerLogin(){
        System.out.println("Fazer login\t\t(1)");
        System.out.println("Cadastrar-se\t(2)");
        System.out.print("\t\t  Opção: ");
        int opcao = scan.nextInt();

        if (opcao == 1) return logar();
        else if (opcao == 2) return cadastrar();

        return false;
    }

    private boolean logar(){
        boolean logado = false;
        try{
            System.out.print("Nome do Usuario: ");
            String nome = scan.next();
            System.out.print("Senha numerica: ");
            int id = scan.nextInt();
            logado = usuarios.eCadastrado(nome, id);

            System.out.println(logado ? "Usuário logado": "Login Inválido");
        } catch (InputMismatchException e) {
            System.out.println("Digite valores válidos");
        }
        return logado;
    }

    private boolean cadastrar(){
        boolean cadastrado = false;
        try{
            System.out.print("Nome do Usuario: ");
            String nome = scan.next();
            System.out.print("Senha numerica: ");
            int id = scan.nextInt();
            cadastrado = usuarios.eCadastrado(nome, id);

            if (!cadastrado){

            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Digite valores válidos");
        }
        return cadastrado;
    }
}
