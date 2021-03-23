package br.unicap.TiposDeDados;

public class LSEC<T extends Comparable<T>> {

    private LSENode<T> inicio;
    private LSENode<T> fim;
    private int qtd;

    public void inserirNoInicio(T obj) {
        LSENode<T> novo = new LSENode(obj);

        if (this.isEmpty()) {
            this.inicio = this.fim = novo;
            this.fim.setProx(this.inicio);
            this.qtd++;
        } else {
            novo.setProx(this.inicio);
            this.inicio = novo;
            this.fim.setProx(this.inicio);
            this.qtd++;
        }
    }

    public void inserirNoFim(T obj) {
        LSENode<T> novo = new LSENode(obj);

        if (this.isEmpty()) {
            this.inicio = this.fim = novo;
            this.fim.setProx(this.inicio);
            this.qtd++;
        } else {
            this.fim.setProx(novo);
            novo.setProx(this.inicio);
            this.fim = novo;
            this.qtd++;
        }
    }

    public void removerNoFim() {
        LSENode<T> aux;
        if (!this.isEmpty()) {
            if (this.qtd == 1) {
                this.inicio = this.fim = null;
            } else if (this.qtd == 2) {
                this.inicio.setProx(null);
                this.fim = this.inicio;
            } else if (this.inicio.getProx() != null) {
                for (aux = this.inicio; aux.getProx() != this.fim; aux = aux.getProx()) {
                }
                this.fim = aux;
                this.fim.setProx(this.inicio);
            }
            System.out.println("Remoção Efetuada!");
            this.qtd--;
        } else {
            System.out.println("Lista Vazia!");
        }
    }

    public T buscaObjeto(T obj) {
        LSENode<T> aux = this.inicio;
        if (!this.isEmpty()) {
            do {
                if (aux.getInfo().compareTo(obj) == 0) {
                    return aux.getInfo();
                }
                aux = aux.getProx();
            } while (aux != this.inicio);
        }
        return null;
    }

    private LSENode<T> buscaSimples(T obj) {
        LSENode<T> aux = this.inicio;
        if (!this.isEmpty()) {
            do {
                if (aux.getInfo().compareTo(obj) == 0) {
                    return aux;
                }
                aux = aux.getProx();
            } while (aux != this.inicio);
        }
        return null;
    }

    public void remover(T obj) {
        LSENode<T>aux = this.inicio;
        LSENode<T> busca = this.buscaSimples(obj);
        if (busca != null) {
            if (this.qtd == 1) {
                this.inicio = this.fim = null;
            } else if (busca.getInfo().compareTo(this.inicio.getInfo()) == 0) {
                this.inicio = busca.getProx();
                this.fim.setProx(this.inicio);
            } else {
                while(aux.getProx().getInfo().compareTo(obj) != 0){
                    aux = aux.getProx();
                }
                aux.setProx(busca.getProx());
            }
            System.out.println("Remoção Efetuada!");
            qtd--;
        } else {
            System.out.println("Elemento não encontrado!");
        }
    }

    public void exibitTodos() {
        LSENode<T> aux = this.inicio;
        if (this.isEmpty()) {
            System.out.println("Lista Vazia");
        } else {
            do {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            } while (aux != this.inicio);
        }
    }

    public boolean ehIgual(LSEC<T> listaB) {
        boolean result = true;
        if (this.isEmpty() && listaB.isEmpty()) {
            result = true;
        } else if (listaB.size()!=this.size()) {
            result = false;
        } else {
            LSENode<T> aux = this.inicio;
            LSENode<T> auxB = listaB.inicio;

            do{
                if(aux.getInfo().compareTo(auxB.getInfo())!=0){
                    result = false;
                    break;
                }else{
                    auxB = auxB.getProx();
                }
                aux = aux.getProx();
            }while(aux!=this.inicio);
        }
        return result;
    }

    public boolean isEmpty() {
        return this.inicio == null;
    }

    public int size() {
        return this.qtd;
    }

}
