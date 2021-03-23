package br.unicap.TiposDeDados;

public class LDENode<T extends Comparable<T>>{

    private T info;
    private LDENode<T> prox;
    private LDENode<T> ant;

    LDENode(T obj) {
        this.info = obj;
    }

    void setInfo(T obj) {
        this.info = obj;
    }

    T getInfo() {
        return this.info;
    }

    public LDENode<T> getProx() {
        return prox;
    }

    public void setProx(LDENode<T> prox) {
        this.prox = prox;
    }

    public LDENode<T> getAnt() {
        return ant;
    }

    public void setAnt(LDENode<T> ant) {
        this.ant = ant;
    }
    
}
