package br.unicap.hash;

public class HashingByMultiplication implements HashSimplified{
    // Hashing pela multiplicação de acordo com a relação proposta por Donald Knuth [1973]

    final double A = 49; // 64 e 49 são primos entre si
    final double w = 64;
    final int TAMANHO = 97;
    Integer [] space = new Integer[TAMANHO];
    int counter = 0;

    private int hash(int value){
        double aux = ((A/w) * value) % TAMANHO;
        return (int) aux;
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
        int element = space[index]==null?-1:space[index];
        return element == key;
    }

    @Override
    public void put(int key) {
        int index = hash(key);
        space[index] = key;
        counter++;
    }
}
