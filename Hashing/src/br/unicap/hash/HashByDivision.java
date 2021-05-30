package br.unicap.hash;

public class HashByDivision implements HashSimplified{

    final int TAMANHO = 91;
    Integer [] espaco = new Integer[TAMANHO];
    int counter = 0;

    private int hash(int value){
        return value % TAMANHO;
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
        Integer element = espaco[index];
        return element == key;
    }

    @Override
    public void put(int key) {
        int index = hash(key);
        espaco[index] = key;
        counter++;
    }

}