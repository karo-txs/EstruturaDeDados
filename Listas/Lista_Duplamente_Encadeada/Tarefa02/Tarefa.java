package br.unicap.dados;

import java.util.Objects;

public class Tarefa implements Comparable<Tarefa> {

    private int prioridade;
    private String descricao;

    public Tarefa() {

    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        if (prioridade <= 0 || prioridade > 10) {
            this.prioridade = -1;
        } else {
            this.prioridade = prioridade;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao.replace(" ", "").matches("^[a-zA-Z]*$")) {
            this.descricao = descricao;
        } else {
            this.descricao = "XXXX";
        }
    }

    @Override
    public String toString() {
        return "Tarefa{" + "prioridade=" + prioridade + ", descricao=" + descricao + '}';
    }

    @Override
    public int compareTo(Tarefa o) {
        if (this.prioridade < o.prioridade) {
            return -1;
        } else if (this.prioridade > o.prioridade) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this.getDescricao().equalsIgnoreCase(((Tarefa) o).getDescricao())) {
            result = true;
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

}
