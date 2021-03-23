package br.unicap.TiposDeDados;

public class LSEOrdenada<T extends Comparable<T>> {

    private LSENode<T> inicio;
    private LSENode<T> fim;
    private int qtde;

    //INSERÇÃO
    public void inserirOrdenado(T obj) {
        LSENode<T> novo = new LSENode(obj);
        LSENode<T> atual, anterior = null;
        if (this.isEmpty()) {
            this.inicio = this.fim = novo;
            qtde++;
            System.out.println("Valor inserido!");
        } else if (this.inicio.getInfo().compareTo(obj) > 0) {
            novo.setProx(this.inicio);
            this.inicio = novo;
            this.qtde++;
            System.out.println("Valor inserido!");
        } else if (this.fim.getInfo().compareTo(obj) < 0) {
            this.fim.setProx(novo);
            this.fim = novo;
            this.qtde++;
            System.out.println("Valor inserido!");
        } else {
            atual = this.inicio;
            while (true) {
                if (atual.getInfo().compareTo(obj) == 0) {
                    System.out.println("Valor repetido");
                    return;
                } else if (atual.getInfo().compareTo(obj) > 0) {
                    anterior.setProx(novo);
                    novo.setProx(atual);
                    qtde++;
                    System.out.println("Valor inserido!");
                    return;
                } else {
                    anterior = atual;
                    atual = atual.getProx();
                }
            }

        }
    }
    //BUSCA
   private LSENode<T> buscaSimples(T obj) {
        LSENode<T> aux = this.inicio;
        while (aux != null) {
            if (aux.getInfo().compareTo(obj) == 0) {
                return aux;
            }
            aux = aux.getProx();
        }
        return null;
    }

    public T buscaObjeto(T obj) {
        LSENode<T> aux = this.buscaSimples(obj);
        if (aux != null) {
            return aux.getInfo();
        } else {
            return null;
        }
    }
    //ATUALIZAÇÃO
     public void alterar(T obj) {
        LSENode<T> no = buscaSimples(obj);
        if (no == null) {
            System.out.println("No nao encontrado!");
        } else {
            no.setInfo(obj);
            System.out.println("Valor alterado com sucesso!");
        }
    }

    //REMOÇÃO
    public void remover(T obj) {
        LSENode<T> aux, anterior, atual;
        if (this.isEmpty()) {
            System.out.println("Lista Vazia!");
        } else if (this.inicio.getInfo().compareTo(obj) == 0) {
            this.inicio = this.inicio.getProx();
            if (this.isEmpty()) {
                this.fim = null;
                System.out.println("Remoção efetuada!");
            }
            this.qtde--;
        } else if (this.fim.getInfo().compareTo(obj) == 0) {
            aux = this.inicio;
            while (aux.getProx() != this.fim) {
                aux = aux.getProx();
            }
            aux.setProx(null);
            this.fim = aux;
            this.qtde--;
            System.out.println("Remoção efetuada!");
        } else {
            anterior = this.inicio;
            atual = anterior.getProx();
            boolean elementoNoMeio;
            /* Perguntas:
            1 - Como o codigo se comporta se o valor a ser removido for menor que o 1º da lista
            2 - Como o codigo se comporta se o valor a ser removido for maior que o ultimo da lista
            3 - Que melhorias podem ser feitas nesse codigo para aumentar sua eficiencia caso o valor a ser removido não 
            pertença a lista.
            */
            elementoNoMeio = this.inicio.getInfo().compareTo(obj)>0 || this.fim.getInfo().compareTo(obj)<0 
                    ? false : true;
            while (elementoNoMeio && atual != null) {
                if (atual.getInfo().compareTo(obj) == 0) {
                    anterior.setProx(atual.getProx());
                    this.qtde--;
                    System.out.println("Remoção efetuada!");
                    return;
                }else if(atual.getInfo().compareTo(obj)>0){
                    System.out.println("Elemento não encontrado!");
                    return;
                }
                else {
                    anterior = anterior.getProx();
                    atual = atual.getProx();
                }
            }
            
        }
    }
    //EXIBIÇÃO
    public void exibirTodos() {
        LSENode<T> aux = this.inicio;
        if (this.isEmpty()) {
            System.out.println("Lista Vazia");
        } else {
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }

    public void exibirUm(T obj) {
        LSENode<T> p = this.buscaSimples(obj);
        if (p != null) {
            System.out.println(p.getInfo());
        } else {
            System.out.println("Valor não encontrado!");
        }
    }

    //OUTROS
    public boolean isEmpty() {
        return this.qtde == 0;
    }

    //GETS E SETS
    public LSENode<T> getInicio() {
        return inicio;
    }

    public void setInicio(LSENode<T> inicio) {
        this.inicio = inicio;
    }

    public LSENode<T> getFim() {
        return fim;
    }

    public void setFim(LSENode<T> fim) {
        this.fim = fim;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
}
