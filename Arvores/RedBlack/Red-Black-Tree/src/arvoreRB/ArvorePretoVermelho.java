package arvoreRB;

public class ArvorePretoVermelho extends AbstractArvoreBinariaDePesquisa<No> {

    public ArvorePretoVermelho() {
    }

    @Override
    public No novoNode(int key) {
        return new No(key);
    }

    @Override
    public No inserir(int key) {
        No node = inserirNoHelper(raiz, key);

        //se o node for a raiz ou o avo for nulo, retornar
        if (node.getPai() == null || node.getPai().getPai() == null) {
            return node;
        }
        consertarInsercao(node); //corrigir inserção/cores
        return node;
    }

    private void consertarInsercao(No n) {
        No tio;

        //Caso 1: Arvore vazia -> n se torna raiz (retornado na função de inserir)
        //Caso 2: pai de n é Preto -> não precisa verificar (não passa no while)     
        //Caso 3: o pai de n é Vermelho:
        while (n.getPai().isRed()) {

            if (n.getPai() == n.getPai().getPai().getDireita()) {
                tio = n.getPai().getPai().getEsquerda();

                if (tio != null && tio.isRed()) {
                    // Caso 3.1: Pai e Tio ambos Vermelhos -> inverter cores do pai, tio e avo
                    tio.setIsRed(false);
                    n.getPai().setIsRed(false);
                    n.getPai().getPai().setIsRed(true);
                    n = n.getPai().getPai();
                } else {
                    //Caso 3.2: Pai é Vermelho e Tio é preto ou nulo
                    if (n == n.getPai().getEsquerda()) {
                        // Caso 3.2.2: o Pai é filho da direita do avo e n é filho esquerdo
                        // do Pai -> filho vira o pai e rotação a direita para reduzir para o caso 3.2.1
                        n = n.getPai();
                        rotacaoDireita(n);
                    }
                    // Caso 3.2.1: o Pai é filho da direita do avo e n é filho direito
                    // do pai -> cor do pai: preto, cor do avo: vermelho, rotação a esquerda no avo
                    n.getPai().setIsRed(false);
                    n.getPai().getPai().setIsRed(true);
                    rotacaoEsquerda(n.getPai().getPai());
                }

            } else {
                tio = n.getPai().getPai().getDireita(); // uncle

                if (tio != null && tio.isRed()) {
                    // Caso 3.1 invertido esquerda<->direita
                    tio.setIsRed(false);
                    n.getPai().setIsRed(false);
                    n.getPai().getPai().setIsRed(true);
                    n = n.getPai().getPai();
                } else {
                    if (n == n.getPai().getDireita()) {
                        // Caso 3.2.2 invertido esquerda<->direita
                        n = n.getPai();
                        rotacaoEsquerda(n);
                    }
                    // Caso 3.2.1 invertido esquerda<->direita
                    n.getPai().setIsRed(false);
                    n.getPai().getPai().setIsRed(true);
                    rotacaoDireita(n.getPai().getPai());
                }
            }
            if (n == raiz) {
                break;
            }
        }
        raiz.setIsRed(false);
    }

    @Override
    public No deletar(int key) {

        //procura o no a ser deletado
        No node = procurar(key);

        if (node == null) {
            return null;
        }
        No sucessor, filho; //no sucessor e filho do sucessor

        //determina o sucessor do no que será removido
        sucessor = sucessor(node);

        //determina quem é o filho do sucessor
        if (sucessor.getEsquerda() != null) {
            filho = sucessor.getEsquerda();
        } else {
            filho = sucessor.getDireita();
        }

        //se o filho do sucessor não for nulo, ajusta o pai deste filho
        if (filho != null) {
            filho.setPai(sucessor.getPai());
        }

        //se sucessor é raiz, raiz recebe o filho do sucessor, senão verifica
        //se o filho do sucessor vai ser filho da direita ou da esquerda do pai
        //do sucessor
        if (sucessor.getPai() == null) {
            raiz = filho;
        } else if (sucessor == sucessor.getPai().getEsquerda()) {
            sucessor.getPai().setEsquerda(filho);
        } else {
            sucessor.getPai().setDireita(filho);
        }

        //ajusta o novo valor caso o sucessor nao seja igual ao no a ser removido
        if (sucessor != node) {
            node.setChave(sucessor.getChave());
        }

        //se o sucessor é preto, consertar cor (casos 3.1 | 3.2 | 3.3 | 3.4)
        if (sucessor.isRed() == false) {
            consertarRemocao(raiz, filho);
        }
        return sucessor;
    }

    private void consertarRemocao(No raiz, No filho) {
        //'filho' = filho do sucessor
        //'irmao' = irmao do sucessor
        No irmao;
        if (filho != null) {
            while (filho != raiz && filho.isRed() == false) {
                if (filho == filho.getPai().getEsquerda()) {//lado esquerdo 
                    irmao = filho.getPai().getDireita();
                    if (irmao.isRed()) {
                        caso1(irmao, filho, false);         // caso 3.1 
                    }
                    if (!verificaCor(irmao.getDireita()) && !verificaCor(irmao.getEsquerda())) {
                        caso2(irmao, filho);                // caso 3.2
                    } else {
                        if (irmao.getDireita().isRed() == false) {
                            caso3(irmao, filho, false);     // caso 3.3
                        }
                        caso4(irmao, filho, false);         // caso 3.4
                        filho = raiz;
                    }
                } else {                            //lado direito
                    irmao = filho.getPai().getEsquerda();
                    if (irmao.isRed()) {
                        caso1(irmao, filho, true);          // caso 3.1 invertido
                    }
                    if (!verificaCor(irmao.getDireita()) && !verificaCor(irmao.getEsquerda())) {
                        caso2(irmao, filho);                // caso 3.2 invertido
                    } else {
                        if (irmao.getEsquerda().isRed() == false) {
                            caso3(irmao, filho, true);      // caso 3.3 invertido
                        }
                        caso4(irmao, filho, true);          // caso 3.4 invertido
                        filho = raiz;
                    }
                }
            }
            filho.setIsRed(false);
        }
    }

    //Casos de remoção para o no preto (3.1 | 3.2 | 3.3 | 3.4)
    //O irmao do filho do sucessor é vermelho: Troca as cores do irmao e do pai
    //do filho, rotaciona à esquerda usando o pai como pivô
    private void caso1(No irmao, No filho, boolean casoEspelhado) {
        irmao.setIsRed(false);
        filho.getPai().setIsRed(true);

        if (casoEspelhado) {
            rotacaoDireita(filho.getPai());
            irmao = filho.getPai().getEsquerda();
        } else {
            rotacaoEsquerda(filho.getPai());
            irmao = filho.getPai().getDireita();
        }
    }

    //O irmao do filho do sucessor é preto e ambos os filhos do irmao sao pretos:
    //muda a cor do irmao para vermelho e o pai agora é o novo filho
    public void caso2(No irmao, No filho) {
        irmao.setIsRed(true);
        filho = filho.getPai();
    }

    //O irmão do filho do sucessor é preto, o filho esquerdo do irmao é vermelho
    //e o filho da direita do irmao é preto: Troca as cores do irmao e de seu
    //filho esquerdo (ou direito dependendo se é caso espelhado e rotaciona a 
    //árvore à direita (ou a esquerda caso espelhado) usando o irmão como pivô
    //Este caso ajusta a árvore para o caso 3.4
    public void caso3(No irmao, No filho, boolean casoEspelhado) {
        if (casoEspelhado) {
            irmao.getDireita().setIsRed(false);
            irmao.setIsRed(true);
            rotacaoEsquerda(irmao);
            irmao = filho.getPai().getEsquerda();
        } else {
            irmao.getEsquerda().setIsRed(false);
            irmao.setIsRed(true);
            rotacaoDireita(irmao);
            irmao = filho.getPai().getDireita();
        }
    }

    //O irmão do filho do sucessor é preto e o filho direito (ou esquerdo caso
    //espelhado) do irmao é vermelho: rotaciona a árvore à esquerda usando como
    //pivô o sucessor. Sucessor e o filho direito (ou esquerdo caso espelhado) 
    //do irmao são pintados de preto
    public void caso4(No irmao, No filho, boolean casoEspelhado) {
        irmao.setIsRed(filho.getPai().isRed());
        filho.getPai().setIsRed(false);
        if (casoEspelhado) {
            irmao.getEsquerda().setIsRed(false);
            rotacaoDireita(filho.getPai());
        } else {
            irmao.getDireita().setIsRed(false);
            rotacaoEsquerda(filho.getPai());
        }
    }

    private No sucessor(No x) {
        No y;
        if (x.getEsquerda() == null || x.getDireita() == null) {
            return x;
        } else {
            //se a subárvore à esquerda não é nula, o sucessor é
            //o nó mais à direita desta subárvore
            if (x.getEsquerda() != null) {
                return maximo(x.getEsquerda());
            }

            //senão, o sucessor é o ancestral mais baixo de x, cujo
            //filho direito também é um ancestral de x
            y = x.getPai();
            while (y != null && x == y.getEsquerda()) {
                x = y;
                y = y.getPai();
            }
            return y;
        }
    }

    //retorna a cor de um determinado nó: true = vermelho / false = preto/null
    private boolean verificaCor(No no) {
        if (no == null) {
            return false;
        } else {
            return no.isRed();
        }
    }

//<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>    
    public void rotacaoEsquerda(No n) {
        No aux = n.getDireita();
        n.setDireita(aux.getEsquerda());
        if (aux.getEsquerda() != null) {
            aux.getEsquerda().setPai(n);
        }
        aux.setPai(n.getPai());
        if (n.getPai() == null) {
            this.raiz = aux;
        } else if (n == n.getPai().getEsquerda()) {
            n.getPai().setEsquerda(aux);
        } else {
            n.getPai().setDireita(aux);
        }
        aux.setEsquerda(n);
        n.setPai(aux);
    }

    public void rotacaoDireita(No n) {
        No aux = n.getEsquerda();
        n.setEsquerda(aux.getDireita());
        if (aux.getDireita() != null) {
            aux.getDireita().setPai(n);
        }
        aux.setPai(n.getPai());
        if (n.getPai() == null) {
            this.raiz = aux;
        } else if (n == n.getPai().getDireita()) {
            n.getPai().setDireita(aux);
        } else {
            n.getPai().setEsquerda(aux);
        }
        aux.setDireita(n);
        n.setPai(aux);
    }

    @Override
    public No procurar(int key) {
        return procurarNoHelper(raiz, key);
    }

}
