package br.unicap.ordenacao;

public class InsertionSort implements Sort{

    @Override
    public int[] sort(int[] nos) {
        int aux;
        for (int i = 0; i < nos.length; i++) {
            aux = nos[i];
            for (int j = i - 1; j >= 0 && nos[j] > aux; j--) {
                nos[j + 1] = nos[j];
                nos[j] = aux;
            }
        }
        return nos;
    }
}
