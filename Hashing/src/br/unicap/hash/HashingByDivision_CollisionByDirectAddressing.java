package br.unicap.hash;

public class HashingByDivision_CollisionByDirectAddressing implements HashSimplified{
    // Hashing pelo resto da divisão com tratamento de colisão por endereçamento aberto (com re-haching)

    final int TAMANHO = 500;
    Integer [] space = new Integer[TAMANHO];
    int counter = 0;

    private int hash(int value){
        return value % TAMANHO;
    }

    private int hash2(int value){return 1 + (value % (TAMANHO-1));}

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
        int aux = 0;
        int value = space[index]==null?-1:space[index];
        while(value!=key){
            if(aux>TAMANHO) break;
            index = (index + hash2(key))% TAMANHO; // re-hash
            value = space[index]==null?-1:space[index];
            aux++;
        }
        int element = space[index]==null?-1:space[index];
        return element == key;
    }

    @Override
    public void put(int key) {
        int index = hash(key);
        while(space[index]!=null){
            index = (index + hash2(key)) % TAMANHO; // re-hash
        }
        space[index] = key;
        counter++;
    }
}