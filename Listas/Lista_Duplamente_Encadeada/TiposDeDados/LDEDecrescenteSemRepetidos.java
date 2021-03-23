package br.unicap.TiposDeDados;

public class LDEDecrescenteSemRepetidos<T extends Comparable<T>> {

    private LDENode<T> inicio;
    private LDENode<T> fim;
    private int qtd;

    public void inserir(T obj) {
        LDENode<T> novo = new LDENode(obj);
        LDENode<T> aux;
        if (this.isEmpty()) {
            this.inicio = this.fim = novo;
            System.out.println("Inserido com sucesso!");
            this.qtd++;
        } else {
            if (!obj.equals(this.inicio.getInfo())) {
                if (qtd == 1 && obj.compareTo(this.inicio.getInfo()) < 0) {
                    this.inicio.setProx(novo);
                    novo.setAnt(this.inicio);
                    System.out.println("Inserido com sucesso!");
                    this.qtd++;
                } else if (qtd == 1 && obj.compareTo(this.inicio.getInfo()) > 0) {
                    this.inicio.setAnt(novo);
                    novo.setProx(this.inicio);
                    System.out.println("Inserido com sucesso!");
                    this.qtd++;
                } else {
                    aux = this.fim;
                    boolean repetido = false;
                    while (aux.getAnt()!=null && aux.getInfo().compareTo(obj) < 0) {
                        aux = aux.getAnt();
                        if (obj.equals(aux.getInfo())) {
                            repetido = true;
                            return;
                        }
                    }
                    if (!repetido) {
                        if (obj.compareTo(this.inicio.getInfo()) > 0) {
                            novo.setProx(this.inicio);
                            this.inicio.setAnt(novo);
                            this.inicio = novo;
                        } else if (obj.compareTo(this.fim.getInfo()) <= 0) {
                            this.fim.setProx(novo);
                            novo.setAnt(fim);
                            this.fim = novo;
                        } else {
                            novo.setProx(aux.getProx());
                            aux.setProx(novo);
                            novo.setAnt(aux);
                            novo.getProx().setAnt(novo);
                        }
                        this.qtd++;
                        System.out.println("Inserido com sucesso!");

                    } else {
                        System.out.println("Valor Repetido!");
                    }
                }
            } else {
                System.out.println("Valor Repetido!");
            }
        }
    }

    public int qtdeAntes(T obj) {
        LDENode<T> aux = this.buscaSimples(obj);
        int qtde = 0;

        if (aux != null) {
            while (aux.getAnt() != null) {
                aux = aux.getAnt();
                qtde++;
            }
            return qtde;
        } else {
            return -1;
        }
    }

    public void exibirPorValor(T obj) {
        LDENode<T> aux = this.inicio;
        if (this.isEmpty()) {
            System.out.println("Lista Vazia");
        } else {
            while (aux != null) {
                if (aux.getInfo().compareTo(obj) == 0) {
                    System.out.println(aux.getInfo());
                }
                aux = aux.getProx();
            }
        }
    }

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

    private LDENode<T> buscaSimples(T obj) {
        LDENode<T> aux = this.inicio;
        while (aux != null) {
            if (aux.getInfo().equals(obj)) {
                return aux;
            }
            aux = aux.getProx();
        }
        return null;
    }

    public T buscaObj(T obj) {
        LDENode<T> aux = this.buscaSimples(obj);
        if (aux != null) {
            return aux.getInfo();
        } else {
            return null;
        }
    }

    public void alterar(T novo) {
        LDENode<T> busca = this.buscaSimples(novo);

        if (busca != null) {
            this.remover(busca.getInfo());
            this.inserir(busca.getInfo());
        } else {
            System.out.println("Valor nao encontrado!");
        }

    }

    public void removerNoInicio() {
        if (!this.isEmpty()) {
            if (this.qtd == 1) {
                this.inicio = this.fim = null;
            } else if (this.inicio.getProx() != null) {
                this.inicio = this.inicio.getProx();
            }
            System.out.println("Remoção Efetuada!");
            this.qtd--;
        } else {
            System.out.println("Lista Vazia!");
        }
    }

    public void remover(T obj) {
        LDENode<T> busca = null;
        LDENode<T> aux = this.inicio;
        if (this.isEmpty()) {
            System.out.println("Lista Vazia!");
        } else if (obj.equals(this.inicio.getInfo()) && this.qtd == 1) {
            this.inicio = this.fim = null;
            System.out.println("Remoção Efetuada!");
            qtd--;
        } else {
            while (!aux.getInfo().equals(obj)) {
                aux = aux.getProx();
            }
            busca = aux;
            if (busca != null) {
                if (busca.getInfo().equals(this.inicio.getInfo())) {
                    this.inicio = busca.getProx();
                    this.inicio.setAnt(null);
                } else if (busca.getInfo().equals(this.fim.getInfo())) {
                    busca.getAnt().setProx(null);
                    this.fim = busca.getAnt();
                } else {
                    LDENode<T> anterior = busca.getAnt();
                    anterior.setProx(busca.getProx());
                    busca.getProx().setAnt(anterior);
                }
                System.out.println("Remoção Efetuada!");
                qtd--;
            } else {
                System.out.println("Elemento não encontrado!");
            }
        }
    }

    public T retirarObj(T obj) {
        LDENode<T> busca = null;
        LDENode<T> aux = this.inicio;
        if (this.isEmpty()) {
            System.out.println("Lista Vazia!");
        } else if (obj.equals(this.inicio.getInfo()) && this.qtd == 1) {
            this.inicio = this.fim = null;
            qtd--;
            return obj;
        } else {
            while (!aux.getInfo().equals(obj)) {
                aux = aux.getProx();
            }
            busca = aux;
            if (busca != null) {
                if (busca.getInfo().equals(this.inicio.getInfo())) {
                    this.inicio = busca.getProx();
                    this.inicio.setAnt(null);
                } else if (busca.getInfo().equals(this.fim.getInfo())) {
                    busca.getAnt().setProx(null);
                    this.fim = busca.getAnt();

                } else {
                    LDENode<T> anterior = busca.getAnt();
                    anterior.setProx(busca.getProx());
                    busca.getProx().setAnt(anterior);
                }

                qtd--;
                return obj;
            } else {
                System.out.println("Elemento não encontrado!");
                return null;
            }
        }

        return null;
    }

    public boolean isEmpty() {
        return this.qtd == 0;
    }

    public LDENode<T> getInicio() {
        return inicio;
    }

    public LDENode<T> getFim() {
        return fim;
    }

    public int getQtd() {
        return qtd;
    }
}
