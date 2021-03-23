package br.unicap.TiposDeDados;

public class LDEC<T extends Comparable<T>> {

    private LDENode<T> inicio;
    private LDENode<T> fim;
    private int qtd;

    public void inserirNoInicio(T obj) {
        LDENode<T> novo = new LDENode<>(obj);
        if (this.isEmpty()) {
            this.inicio = this.fim = novo;
        } else {
            novo.setProx(this.inicio);
            this.inicio.setAnt(novo);
            this.inicio = novo;
        }
        this.garantirCircularidade();
        this.qtd++;
    }

    public void inserirNoFim(T obj) {
        LDENode<T> novo = new LDENode(obj);
        if (this.isEmpty()) {
            this.inicio = this.fim = novo;
            this.garantirCircularidade();
            this.qtd++;
        } else {
            this.fim.setProx(novo);
            novo.setProx(this.inicio);
            novo.setAnt(fim);
            this.fim = novo;
            this.garantirCircularidade();
            this.qtd++;
        }
    }

    public void removerNoInicio() {
        if (!this.isEmpty()) {
            if (this.qtd == 1) {
                this.inicio = this.fim = null;
            } else if (this.qtd == 2) {
                this.inicio = this.inicio.getProx();
                this.fim = this.inicio;
            } else if (this.inicio.getProx() != null) {
                this.inicio = this.inicio.getProx();
                this.fim.setProx(this.inicio);
            }
            this.garantirCircularidade();
            System.out.println("Remoção Efetuada!");
            this.qtd--;

        } else {
            System.out.println("Lista Vazia!");
        }
    }

  public boolean remover(T obj) {
        boolean result = true;
        LDENode<T> aux;
        if (this.isEmpty()) {
            result = false;
        } else if (obj.compareTo(this.inicio.getInfo()) == 0 && this.qtd == 1) {
            this.inicio = this.fim = null;
            qtd--;
        } else {
            
            for(aux = this.inicio;aux.getProx()!=this.inicio && aux.getInfo().compareTo(obj)!=0;aux = aux.getProx()){
            }
            
            if (aux.getInfo().compareTo(this.inicio.getInfo()) == 0) {
                this.inicio = aux.getProx();
                this.inicio.setAnt(null);
                this.garantirCircularidade();
                qtd--;
            } else if (aux.getInfo().compareTo(this.fim.getInfo()) == 0) {
                aux.getAnt().setProx(null);
                this.fim = aux.getAnt();
                this.garantirCircularidade();
                qtd--;
            } else {
                if (aux.getInfo().compareTo(obj) == 0) {
                    LDENode<T> anterior = aux.getAnt();
                    anterior.setProx(aux.getProx());
                    aux.getProx().setAnt(anterior);
                    qtd--;
                } else {
                    result = false;
                }
            }
        }
        return result;
    }
    

    /*
    Considere uma lista duplamente encadeada circular genérica. Implemente um método
    concatenar, na classe LDEC (lista duplamente encadeada circular), que deverá fazer a
    concatenação de duas listas lineares duplamente encadeadas circulares, de forma que L1 = L1 +
    L2, ou seja, ao final do método, todos os nós ficarão pertencendo a lista L1 e a lista L2 ficará vazia.
    A ordem dos nós na lista deverá permanecer a mesma.
    Exemplo de chamada: L1.concatenar (L2);
     */
    public void concatenar(LDEC<T> listaB) {
        if (listaB.isEmpty() && this.isEmpty()) {
            System.out.println("Ambas as listas Vazias!");
        } else if (listaB.isEmpty()) {
            System.out.println("Lista B Vazia!");
        } else {
            int tamB = listaB.qtd;
            int cont = 0;
            LDENode<T> aux = listaB.inicio;
            do {
                this.inserirNoFim(aux.getInfo());
                listaB.removerNoInicio();
                aux = aux.getProx();
                cont++;
            } while (tamB > cont);
            System.out.println("Concatenação concluida!");
        }
    }

    /*
    Implemente uma função dividir, na classe LDEC (lista duplamente encadeada circular), que
    deverá dividir uma lista em duas outras. A função irá dividir a lista original ao meio, de forma que
    a lista original permaneça com os nós de sua primeira metade e seja criada uma outra lista para
    abrigar o restante dos nós. A função deve retornar a nova lista criada.
    Exemplo de chamada: L2 = L1.dividir ( );
     */
    public LDEC<T> dividir() {
        LDEC<T> listaC = new LDEC<>();

        if (!this.isEmpty()) {
            int tam = this.size();
            int metade = tam / 2;
            LDENode<T> aux = this.inicio;
            
            for (int i = 0; i < metade; i++) {
                aux = aux.getProx();
            }

            for (int i = metade; i < tam; i++) {
                listaC.inserirNoFim(aux.getInfo());
                this.remover(aux.getInfo());
                aux = aux.getProx();
            }
        } else {
            System.out.println("Lista Vazia!");
        }
        return listaC;
    }

    public void exibitTodos() {
        LDENode<T> aux = this.inicio;
        if (this.isEmpty()) {
            System.out.println("Lista Vazia");
        } else {
            do {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            } while (aux != this.inicio);
        }
    }

    public boolean isEmpty() {
        return this.inicio == null;
    }

    public int size() {
        return this.qtd;
    }

    private void garantirCircularidade() {
        this.fim.setProx(this.inicio);
        this.inicio.setAnt(this.fim);
    }
}
