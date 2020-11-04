package com.datastructure;

public class PrimeNumber {

    public static void main(String args[]){

        PrimeNumber obj = new PrimeNumber();
        int n = 2147483647;//Integer.MAX_VALUE;
        System.out.println("Entered number is "+ n);
        System.out.println(obj.findPrimeNtimes(n));
        System.out.println(obj.findPrimeRootN(n));
    }

    public boolean findPrimeNtimes(int n) {

        long start = System.currentTimeMillis();


        boolean prime = true;
        for (int i=2; i< n-1; i++) {

           if( n % i == 0){
               prime = false;
               break;
           }

        }

        long end = System.currentTimeMillis() - start;
        System.out.println("Time taken findPrimeNtimes =  "+ end);
        return prime;
    }

    public boolean findPrimeRootN(int n) {


        long start = System.currentTimeMillis();

        boolean prime = true;

        double sqrtN = Math.sqrt(n);

        for(int i=2; i<= sqrtN; i++){
            if( n % i == 0){
                prime = false;
                break;
            }
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("Time taken findPrimeRootN =  "+ end);
        return prime;
    }
}
