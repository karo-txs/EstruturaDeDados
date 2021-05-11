package br.unicap.ordenacao;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class SortingApp {

    static final private int ARRAY_MAX_INT = 10000;
    static final private int ARRAY_MAX_ARRAY = 100000;
    private Sort sortStrategy;

    public SortingApp(Sort sort) {
        this.sortStrategy = sort;
    }

    public int[] sort(int[] data) {
        return sortStrategy.sort(data);
    }

    public void changeStrategy(Sort anotherStrategy) {
        sortStrategy = anotherStrategy;
    }

    public boolean verifyData(int arr[]) {
        int n = arr.length - 1;
        for (int i = 0; i < n; ++i) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] getDummyData() {
        Random r = new Random();
        int[] data = new int[ARRAY_MAX_ARRAY];
        for (int i = 0; i < ARRAY_MAX_ARRAY; i++) {
            data[i] = r.nextInt(ARRAY_MAX_INT);
        }
        return data;
    }

    public static void go(Runnable r) {
        Instant start = Instant.now();
        r.run();
        Instant end = Instant.now();
        Duration interval = Duration.between(start, end);

        System.out.println("Tempo em nano para procurar: " + (interval.getNano() / 1000));
    }

    public static void main(String[] args) {
        System.out.println("Bubble");
        SortingApp app = new SortingApp(new BubbleSort());
        int[] dummyData = getDummyData();
        testSort(app, dummyData);

        System.out.println("Selection");
        app.changeStrategy(new SelectionSort());
        testSort(app, dummyData);

        System.out.println("Insertion");
        app.changeStrategy(new InsertionSort());
        testSort(app, dummyData);

        System.out.println("Shell");
        app.changeStrategy(new ShellSort());
        testSort(app, dummyData);

        System.out.println("Merge");
        app.changeStrategy(new MergeSort());
        testSort(app, dummyData);

        System.out.println("Quick");
        app.changeStrategy(new QuickSort());
        testSort(app, dummyData);

        System.out.println("Heap");
        app.changeStrategy(new HeapSort());
        testSort(app, dummyData);
    }

    private static void testSort(SortingApp app, int[] dummyData) {

        Runnable doIt;
        doIt = new Runnable() {
            @Override
            public void run() {
                int[] ordered;
                ordered = app.sort(dummyData);
                if (!app.verifyData(ordered)) {
                    System.out.println("não está ordenado");
                }
            }
        };
        go(doIt);

    }
}
