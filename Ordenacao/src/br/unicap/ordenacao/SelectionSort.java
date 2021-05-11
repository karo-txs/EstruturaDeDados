package br.unicap.ordenacao;

public class SelectionSort implements Sort {

    @Override
    public int[] sort(int[] nos) {

        int[] a = nos;
        int temp = 0, aux;
        for (int i = 0; i < nos.length - 1; i++) {
            aux = i;
            for (int j = i + 1; j < nos.length; j++) {
                if (a[j] < a[i]) {
                    aux = j;
                }
            }
            temp = a[i];
            a[i] = a[aux];
            a[aux] = temp;
        }

        return nos;
    }

}
