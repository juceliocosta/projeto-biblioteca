package entity;

import repository.EmprestimoRepository;

public abstract class Usuario {
    private int id;
    private String nome;
    //private String tipo_usuario;

    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
        //this.tipo_usuario = tipo_usuario;
    }

    public void registrarEmprestimo(){};
        EmprestimoRepository emprestimo = new EmprestimoRepository();

    public void registrarDevolucao(){};


    //----------Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
/*
    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

 */
}


