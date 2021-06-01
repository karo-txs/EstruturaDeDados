package br.unicap.hash;

import java.util.LinkedList;

public class HashingByDivision_CollByCoalescedChainingBasement implements HashSimplified {
    //Hashing pelo resto da divisão com tratamento de colisão por encadeamento coalescido
    //com porão de tamanho = 10
    

    final int TAMANHO = 97;
    final int PORAO = 10;
    LinkedList[] space = new LinkedList[TAMANHO];
    int counter = 0;

    public HashingByDivision_CollByCoalescedChainingBasement() {
        for (int i = 0; i < space.length; i++) {
            space[i] = new LinkedList();

            space[i].addFirst(null); //elemento da tabela hash (First)
            space[i].addLast(-2);   //-2 indica que está vazio (Last)
        }
    }

    private int hash(int value) {
        return value % (TAMANHO - PORAO);
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public boolean containsKey(int key) {
        int index = hash(key);
        if (space[index].getLast().equals(-2)) {
            return false;
        }
        while(!space[index].getLast().equals(-1)){     
            if (space[index].getFirst().equals(key)) {
                return true;
            }
            index = (int) space[index].getLast();         
        }   
        return space[index].getFirst().equals(key);
     
    }

    @Override
    public void put(int key) {
        int index = hash(key);
        
        //enquanto houver valor na chave (não for vazio com o next -2), procurar fim da cadeia
        while (!space[index].getLast().equals(-2)) { 
            int atual = index;

            if (space[index].getLast().equals(-1)) { //achou fim da cadeia, pode inserir
                for (int i = TAMANHO - 1; i > 0; i--) { //procura chave vazia a partir do fim (porão)
                    if (space[i].getFirst() == null) {
                        index = i;
                        break;
                    }
                }
                space[atual].set(1, index); //info do ponteiro é atualizada com o index encontrado do porão
                space[index].set(0, key);   //seta a info no porão
                space[index].set(1, -1);    //seta o ponteiro do porão como -1 (fim da cadeia)
                break;
            } else {
                index = (int) space[index].get(1); //se não for fim da cadeia, aponta pra próxima chave
            }
        }

        //caso vazio (-2)
        space[index].set(0, key); //insere o valor da chave na tabela
        space[index].set(1, -1);  //seta como -1 (fim da cadeia)
        counter++;
    }

    public void print() {
        for (int i = 0; i < TAMANHO - PORAO; i++) {
            if (space[i] == null) {
                System.out.println("index: [" + i + "] = null");
            } else {
                System.out.println("index: [" + i + "] = " + space[i].toString());
            }
        }
        for (int i = TAMANHO - PORAO + 1; i < TAMANHO; i++) {
            if (space[i] == null) {
                System.out.println("porao: [" + i + "] = null");
            } else {
                System.out.println("porao: [" + i + "] = " + space[i].toString());
            }
        }

    }
}
