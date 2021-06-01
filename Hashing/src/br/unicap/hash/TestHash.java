package br.unicap.hash;

import java.util.Random;

public class TestHash {

    static final private int ARRAY_MAX_INT = 100;
    static final private int ARRAY_MAX_ARRAY = 97;

    public static int[] getDummyData() {
        Random r = new Random();
        int[] data = new int[ARRAY_MAX_ARRAY];
        for (int i = 0; i < ARRAY_MAX_ARRAY; i++) {
            data[i] = r.nextInt(ARRAY_MAX_INT);
        }
        return data;
    }

    public static void main(String[] args) {
        int[] dummyData = getDummyData();
        int valueTest = 66;
        boolean enteredValue = false;

        HashingByMultiplication hashMultiplication = new HashingByMultiplication();
        HashingByDivision_CollisionByDirectAddressing hashCDA = new HashingByDivision_CollisionByDirectAddressing();
        HashingByDivision_CollisionBySeparateChaining hashCSC = new HashingByDivision_CollisionBySeparateChaining();
        HashingByDivision_CollByCoalescedChainingBasement hashCCB = new HashingByDivision_CollByCoalescedChainingBasement();

        for (int i : dummyData) {
            hashMultiplication.put(i);
            hashCDA.put(i);
            hashCSC.put(i);
            hashCCB.put(i);

            if (i == valueTest) {
                enteredValue = true;
            }
        }

        System.out.println("Hash-Multiplication size: " + hashMultiplication.size());
        System.out.println("Hash-Division (CollisionByDirectAddressing) size: " + hashCDA.size());
        System.out.println("Hash-Division (CollisionBySeparateChaining) size: " + hashCSC.size());
        System.out.println("Hash-Division (CollisionByCoalescedChainBasement) size: " + hashCCB.size());

        System.out.println("-------------------------------------------------");

        String msgInsertion = enteredValue ? "The value " + valueTest + " has been entered"
                : "The value " + valueTest + " has not been entered";
        System.out.println(msgInsertion);
        System.out.println("Hash-Multiplication contains: " + hashMultiplication.containsKey(valueTest));
        System.out.println("Hash-Division (CollisionByDirectAddressing) contains: " + hashCDA.containsKey(valueTest));
        System.out.println("Hash-Division (CollisionBySeparateChaining) contains: " + hashCSC.containsKey(valueTest));
        System.out.println("Hash-Division (CollisionByCoalescedChainBasement) contains: " + hashCCB.containsKey(valueTest));

//        descomentar para visualizar as tabelas hash        
//        System.out.println("--------- print hashtable ----------");
//        System.out.println("Hash-Division (CollisionBySeparateChaining): ");
//        hashCSC.print();
//        System.out.println("\n\nHash-Division (CollisionByCoalescedChainBasement) contains: ");
//        hashCCB.print();
    }
}
