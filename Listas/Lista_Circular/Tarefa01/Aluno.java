package br.unicap.dados;

public class Aluno implements Comparable<Aluno> {

    private String matricula;
    private String nome;
    private double mediaFinal;
    private int qtdeFaltas;

    public Aluno(String matricula) {
        this.matricula = matricula;
    }

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public void somarFalta(int qtde) {
        this.qtdeFaltas += qtde;
    }

    public void subtrairFalta(int qtde) {
        this.qtdeFaltas -= qtde;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public String getNome() {
        return this.nome;
    }

    public void setMediaFinal(double n) {
        this.mediaFinal = n;
    }

    public double getMediaFinal() {
        return this.mediaFinal;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getQtdeFaltas() {
        return qtdeFaltas;
    }

    public void setQtdeFaltas(int qtdeFaltas) {
        this.qtdeFaltas = qtdeFaltas;
    }

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", nome=" + nome + ", mediaFinal=" + mediaFinal + ", qtdeFaltas=" + qtdeFaltas + '}';
    }

    @Override
    public int compareTo(Aluno a) {
        return this.matricula.compareTo(a.getMatricula());
    }
}
