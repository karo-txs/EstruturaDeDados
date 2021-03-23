package br.unicap.dados;
public class Aluno implements Comparable <Aluno> {
    private String nome;
    private double nota;
    public Aluno (String n) { // construtor
        this.nome = n;
    }
     public void setNome (String n){
        this.nome = n;
    }   
    public String getNome () {
        return this.nome;
    }   
    public void setNota (double n) {
        this.nota = n;
    }   
    public double getNota () {
        return this.nota;
    }
    public String toString () {
        return this.nome + " " + this.nota;
    }
    @Override
    public int compareTo(Aluno a) {
        return this.nome.compareTo(a.getNome());
    }
}
