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

    public boolean registrarEmprestimo(Livro livro, EmprestimoRepository repositorio) {
        if (livro.estaDisponivel()) {
            Emprestimo novoEmprestimo = new Emprestimo(livro, this);
            livro.emprestar();
            return repositorio.registrarEmprestimo(novoEmprestimo);
        }
        return false;
    }

    public boolean registrarDevolucao(Livro livro, EmprestimoRepository repositorio){
        if (repositorio.temEmprestimo(livro, this)) {
            repositorio.devolverEmprestimo(livro, this);
            livro.devolver();

            return true;
        }
        return false;
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


