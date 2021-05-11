package br.unicap.ordenacao;

public class BubbleSort implements Sort {

    @Override
    public int[] sort(int[] nos) {
        boolean swapped;
        int temp = 0;

        do {
            swapped = false;

            for (int i = 0; i < nos.length - 1; i++) {
                if (nos[i] > nos[i + 1]) {
                    temp = nos[i];
                    nos[i] = nos[i + 1];
                    nos[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return nos;
    }

}
