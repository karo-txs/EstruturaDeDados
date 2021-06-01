package br.unicap.hash;
import java.util.LinkedList;

public class HashingByDivision_CollisionBySeparateChaining implements HashSimplified {
    // Hashing pelo resto da divisão com tratamento de colisão por endereçamento
    //fechado (listas ligadas)

    final int TAMANHO = 97;
    LinkedList[] space = new LinkedList[TAMANHO];
    int counter = 0;

    private int hash(int value) {
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

        if (space[index] == null) {
            return false;
        }

        for (int i = 0; i < space[index].size(); i++) {
            if (space[index].get(i).equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void put(int key) {
        int index = hash(key);
        if (space[index] == null) {
            space[index] = new LinkedList();
        }
        space[index].addLast(key);
        counter++;
    }

    public void print() {
        for (int i = 0; i < TAMANHO; i++) {
            if (space[i] == null) {
                System.out.println("pos: [" + i + "] = null");
            } else {
                System.out.println("pos: [" + i + "] = " + space[i].toString());
            }
        }
    }
}
