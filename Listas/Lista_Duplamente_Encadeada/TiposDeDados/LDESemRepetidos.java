package br.unicap.TiposDeDados;

public class LDESemRepetidos<T extends Comparable<T>> {

    private LDENode<T> inicio;
    private LDENode<T> fim;
    private int qtde;

    //INSERÇÃO
    public void inserirNoInicio(T obj) {
        LDENode<T> novo = new LDENode<>(obj);
        LDENode<T> aux;
        if (this.isEmpty()) {
            this.inicio = novo;
            this.fim = novo;
            this.qtde++;
        } else {
            aux = this.buscaSimples(obj);
            if (aux == null) {
                this.inicio.setAnt(novo);
                novo.setProx(this.inicio);
                this.inicio = novo;
                this.qtde++;
            } else {
                System.out.println("Valor Repetido!");
            }
        }
    }

    public void inserirNoFim(T obj) {
        LDENode<T> novo = new LDENode<>(obj);
        LDENode<T> aux;
        if (this.isEmpty()) {
            this.inicio = novo;
            this.fim = novo;
        } else {
            aux = this.buscaSimples(obj);
            if (aux == null) {
                novo.setAnt(this.fim);
                this.fim.setProx(novo);
                this.fim = novo;
            } else {
                System.out.println("Valor Repetido!");
            }
        }
        this.qtde++;
    }

    //REMOÇÃO
    public void removerNoFinal() {
        if (!this.isEmpty()) {
            if (this.qtde == 1) {
                this.inicio = this.fim = null;
            } else if (this.inicio.getProx() != null) {
                LDENode<T> anterior = this.fim.getAnt();
                anterior.setProx(null);
                this.fim = anterior;
            }
            System.out.println("Remoção Efetuada!");
            this.qtde--;
        } else {
            System.out.println("Lista Vazia!");
        }
    }
    
    public void remover(T obj) {
        LDENode<T> busca = null;
        LDENode<T> aux = this.inicio;
        if (this.isEmpty()) {
            System.out.println("Lista Vazia!");
        } else if (obj.compareTo(this.inicio.getInfo()) == 0 && this.qtde == 1) {
            this.inicio = this.fim = null;
            System.out.println("Remoção Efetuada!");
            qtde--;
        } else {
            while (aux != null) {
                if (aux.getInfo().compareTo(obj) == 0) {
                    busca = aux;
                }
                aux = aux.getProx();
            }

            if (busca != null) {
                if (busca.getInfo().compareTo(this.inicio.getInfo()) == 0) {
                    this.inicio = busca.getProx();
                    this.inicio.setAnt(null);
                } else if (busca.getInfo().compareTo(this.fim.getInfo()) == 0) {
                    busca.getAnt().setProx(null);
                    this.fim = busca.getAnt();
                } else {
                    LDENode<T> anterior = busca.getAnt();
                    anterior.setProx(busca.getProx());
                    busca.getProx().setAnt(anterior);
                }
                System.out.println("Remoção Efetuada!");
                qtde--;
            } else {
                System.out.println("Elemento não encontrado!");
            }
        }
    }

    //BUSCAS
    public LDENode<T> buscaSimples(T obj) {
        LDENode<T> aux = this.inicio;
        while (aux != null) {
            if (aux.getInfo().compareTo(obj) == 0) {
                return aux;
            }
            aux = aux.getProx();
        }
        return null;
    }

    public T buscaObjeto(T obj) {
        LDENode<T> aux = this.buscaSimples(obj);
        if (aux != null) {
            return aux.getInfo();
        } else {
            return null;
        }
    }

    //EXIBIÇÃO
    public void exibirTodos() {
        LDENode<T> aux = this.inicio;
        if (this.isEmpty()) {
            System.out.println("Lista Vazia");
        } else {
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }

    //OUTROS
    public boolean isEmpty() {
        return this.qtde == 0;
    }

    public int size() {
        return qtde;
    }
}
