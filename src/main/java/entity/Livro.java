package entity;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int quantidade; // para controle de quantidade de livros disponíveis
    private boolean disponibilidade;

    public Livro(int id, String titulo, String autor, int quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.quantidade = quantidade;
    }

    private void atualizarDisponibilidade() {
        disponibilidade = quantidade > 0;// se for maior que 0, o livro está disponível
    }

    public void emprestar() {
        if (quantidade > 0) {
            quantidade--;
        }
        atualizarDisponibilidade();
    }

    public void devolver() {
        quantidade++;
        atualizarDisponibilidade();
    }

    public boolean isDisponivel() {
        atualizarDisponibilidade();
        return disponibilidade;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", quantidade=" + quantidade +
                ", disponibilidade=" + disponibilidade +
                '}';
    }

    // ----------getters e setters----------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = Math.max(0, quantidade);
        atualizarDisponibilidade();
    }

}