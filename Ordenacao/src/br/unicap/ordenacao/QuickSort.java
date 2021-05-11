
package br.unicap.ordenacao;

public class QuickSort  implements Sort{

    @Override
    public int[] sort(int[] nos) {
        quickSort(nos,0,nos.length-1);
        return nos;
    }

    public void quickSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(array, inicio, fim);
            quickSort(array, inicio, posicaoPivo-1);
            quickSort(array, posicaoPivo+1,fim);
        }
    }

    private static int separar(int[] array, int inicio, int fim) {
        int pivo = array[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (array[i] <= pivo)
                i++;
            else if (pivo < array[f])
                f--;
            else {
                int troca = array[i];
                array[i] = array[f];
                array[f] = troca;
                i++;
                f--;
            }
        }
        array[inicio] = array[f];
        array[f] = pivo;
        return f;
    }
    
}
