package com.example;

/**
 * Created by levin on 3/27/17.
 */

public class RandomQuestions {


    public static void shuffle(int arr[]){
        for(int i = arr.length - 1; i >= 0; i--){
            int random = (int)(Math.random() * (i + 1)) ;
            System.out.print(random +  " ");
            swap(arr, random, i);
        }
    }

    public static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int rand7(){
        int r = (rand5() - 1) * 5 + rand5();
        while (r > 21) {   // I just need to ignore [22, 25]
            r = (rand5() - 1) * 5 + rand5();
        }
        return (r % 7) + 1;
    }

    private int rand5(){
        return (int) (Math.ceil(Math.random() * 5));
    }

}
