package entity;

import repository.EmprestimoRepository;

public abstract class Usuario {
    private String id;
    private String nome;
    private String senha;
    private String tipo_usuario;

    public Usuario(String id, String nome, String senha, String tipo_usuario) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.tipo_usuario = tipo_usuario;
    }

    public void registrarEmprestimo(Livro livro) {
        Emprestimo novoEmprestimo = new Emprestimo(livro, this);
        EmprestimoRepository emprestimo = new EmprestimoRepository();

        emprestimo.registrarEmprestimo(novoEmprestimo);
    }
    public void registrarDevolucao(Livro livro){
        EmprestimoRepository emprestimo = new EmprestimoRepository();
        emprestimo.devolverEmprestimo(livro, this);
    }


    //----------Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() { return senha;}

    public void setSenha(String senha) { this.senha = senha; }

    public String getTipo_usuario() { return tipo_usuario; }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
}


