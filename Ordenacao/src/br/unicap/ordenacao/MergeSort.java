package br.unicap.ordenacao;
import java.util.Arrays;

public class MergeSort implements Sort {

    @Override
    public int[] sort(int[] nos) {
        int n = nos.length;
        if (n<2)
            return nos;
        int middle = n/2;
        int [] left = Arrays.copyOfRange(nos, 0, middle);
        int [] right = Arrays.copyOfRange(nos, middle, n);

        sort(left);
        sort(right);
        merge(left, right, nos);

        return nos;
    }

    private void merge(int []left, int[] right, int [] finalArray) {
        int nLeft = left.length, nRight = right.length, indexLeft = 0, indexRight = 0, indexArray = 0;

        while(indexLeft<nLeft && indexRight<nRight) {
            if(left[indexLeft]<=right[indexRight]) {
                finalArray[indexArray]=left[indexLeft];
                indexLeft++;
            } else {
                finalArray[indexArray]=right[indexRight];
                indexRight++;
            }
            indexArray++;
        }

        while(indexLeft<nLeft) {
            finalArray[indexArray]=left[indexLeft];
            indexLeft++;
            indexArray++;
        }
        while(indexRight<nRight) {
            finalArray[indexArray]=right[indexRight];
            indexRight++;
            indexArray++;
        }
    }

}
