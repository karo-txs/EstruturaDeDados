package br.unicap.ordenacao;

public class ShellSort implements Sort {

    @Override
    public int[] sort(int[] nos) {
        int j, atual;
        for(int gap=nos.length/2;gap>0;gap/=2)
            for (int i = gap; i < nos.length; i += 1) {
                j = i;
                atual = nos[i];
                for (; j >= gap && nos[j - gap] > atual; j -= gap) {
                    nos[j] = nos[j - gap];
                }
                nos[j] = atual;
            }
        return nos;
    }
}
