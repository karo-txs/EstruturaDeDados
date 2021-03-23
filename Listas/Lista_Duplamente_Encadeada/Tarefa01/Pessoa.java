package br.unicap.dados;

public class Pessoa implements Comparable<Pessoa> {

    private String nome;
    private String rg;

    public Pessoa() {
    }

    public Pessoa(String n) {
        this.setNome(n);
    }

    public Pessoa(String n, String rg) { // construtor
        this(n);
        this.setRg(rg);
    }

    public void setNome(String nome) {
        if (nome.replace(" ", "").matches("^[a-zA-Z]*$")) {
            this.nome = nome;
        } else {
            this.nome = "XXXX";
        }
    }

    public void setRg(String rg) {
        if (rg.matches("^\\d+$") && rg.length()==8) {
            this.rg = rg;
        } else {
            this.rg = "XXXX";
        }
    }

    public String getNome() {
        return this.nome;
    }

    public String getRg() {
        return rg;
    }

    @Override
    public int compareTo(Pessoa o) {
        return this.getRg().compareTo(o.getRg());
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", rg=" + rg + '}';
    }

}
