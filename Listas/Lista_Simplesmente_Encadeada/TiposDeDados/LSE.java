package br.unicap.TiposDeDados;
public class LSE<T extends Comparable<T>> {

    private LSENode<T> inicio;
    private LSENode<T> fim;
    private int qtde;

    //ADIÇÃO
    public void inserirNoInicio(T obj) {
        LSENode<T> novo = new LSENode<T>(obj);
        if (this.isEmpty()) {
            this.inicio = novo;
            this.fim = novo;
        } else {
            novo.setProx(this.inicio);
            this.inicio = novo;
        }
        this.qtde++;
    }

    public void inserirNoFim(T obj) {//inserir novo no no final da lista 
        LSENode<T> novo = new LSENode<T>(obj);
        if (this.isEmpty()) {
            this.inicio = novo;
            this.fim = novo;
        } else {
            this.fim.setProx(novo);
            this.fim = novo;
        }
        qtde++;
    }

    //REMOÇÃO
    public void removerNoFim() {
        if (!this.isEmpty()) {
            if (this.qtde == 2) {
                this.inicio.setProx(null);
            } else if (this.inicio.getProx() != null) {
                LSENode<T> penultimo = proximoElemento(this.inicio.getProx());
                penultimo.setProx(null);
                this.fim = penultimo;
            } else {
                this.inicio = this.fim = null;
            }
            System.out.println("Remoção Efetuada!");
            this.qtde--;
        } else {
            System.out.println("Lista Vazia!");
        }
    }

    public void removerNoInicio() {
        if (!this.isEmpty()) {
            if (this.inicio.getProx() != null) {
                this.inicio = this.inicio.getProx();
            } else {
                this.inicio = this.fim = null;
            }
            System.out.println("Remoção Efetuada!");
            this.qtde--;
        } else {
            System.out.println("Lista Vazia!");
        }
    }
    
    public void remover(T obj) {
        LSENode<T> busca = this.buscaSimples(obj);
        if (busca != null) {
            if (busca.getInfo().compareTo(this.inicio.getInfo()) == 0) {
                this.inicio = busca.getProx();
            } else {
                LSENode<T> anterior = this.elementoAnterior(this.inicio, busca);
                anterior.setProx(busca.getProx());
            }
            System.out.println("Remoção Efetuada!");
            qtde--;
        } else {
            System.out.println("Elemento não encontrado!");
        }
    }

    //BUSCA
    //Busca Proximo elemento ate chegar ao fim
    private LSENode<T> proximoElemento(LSENode<T> elemento) {
        if (elemento.getProx().equals(this.fim)) {
            return elemento;
        }
        return proximoElemento(elemento.getProx());
    }
    
    private LSENode<T> elementoAnterior(LSENode<T> inicio, LSENode<T> elemento) {
        if (inicio.getProx().equals(elemento)) {
            return inicio;
        }
        return elementoAnterior(inicio.getProx(), elemento);
    }

    public LSENode<T> buscaSimples(T obj) {
        LSENode<T> aux = this.inicio;
        while (aux != null) {
            if (aux.getInfo().compareTo(obj) == 0) {
                return aux;
            }
            aux = aux.getProx();
        }
        return null;
    }

    //ALTERAÇÃO
    public void alterar(T antigo, T novo) {
        LSENode<T> noAntigo = buscaSimples(antigo);
        if (noAntigo == null) {
            System.out.println("No nao encontrado!");
        } else {
            noAntigo.setInfo(novo);
            System.out.println("Valor alterado com sucesso!");
        }
    }

    //EXIBIÇÃO
    public void exibirTodos() {
        LSENode<T> aux = this.inicio;
        if (this.isEmpty()) {
            System.out.println("Lista Vazia");
        } else {
            while (aux != null) {
                System.out.print(aux.getInfo() + " ");
                aux = aux.getProx();
            }
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
