
package br.unicap.ed1.model;

public class Termo implements Comparable<Termo>{
    private String nome;
    private String descricao;

    public Termo(String nome) {
        this.nome = nome;
    }
    
    public Termo(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public int compareTo(Termo t) {
       return this.nome.compareToIgnoreCase(t.nome);
    }

    @Override
    public String toString() {
        return nome + ":" + descricao;
    }
    
}
