package br.unicap.ordenacao;

public class HeapSort implements Sort {

    @Override
    public int[] sort(int[] nos) {

        int i, temp;
        for (i = nos.length / 2 - 1; i >= 0; i--) {
            heapify(nos, nos.length, i);
        }
        for (i = nos.length - 1; i >= 0; i--) {
            temp = nos[0];
            nos[0] = nos[i];
            nos[i] = temp;
            heapify(nos, i, 0);
        }
        return nos;
    }

    void heapify(int arr[], int size, int i) {
        int temp, largest = i;
        int left = 2 * i + 1;
        int right = left + 1;

        largest = left < size && arr[left] > arr[largest] ? left : largest;
        largest = right < size && arr[right] > arr[largest] ? right : largest;

        if (largest != i) {
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, size, largest);
        }
    }
}
