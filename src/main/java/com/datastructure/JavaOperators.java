package com.datastructure;

public class JavaOperators {

    public static void main(String args[]){

        int a = 6;
        int b = 2;
        System.out.println("(a,b): "+ a + "," + b);

        System.out.println("A list of all assignment operators");
        System.out.println("a=6 "+ (a));
        System.out.println("a+=3 "+ (a += 3));
        System.out.println("a-=3 "+ (a -= 3));
        System.out.println("a*=3 "+ (a *= 3));
        System.out.println("a/=3 "+ (a /= 3));
        System.out.println("a%=3 "+ (a %= 3));
        System.out.println("5&=3 "+ (a &= 3));
        System.out.println("a|=3 "+ (a |= 3));
        System.out.println("a^=3 "+ (a ^= 3));
        System.out.println("a>>=3 "+ (a >>= 3));
        System.out.println("a<<=3 "+ (a <<= 3));

        System.out.println("A list of all Arithmetic operators");
        System.out.println("a+b: "+ (a+b));
        System.out.println("a-b: "+ (a-b));
        System.out.println("a*b: "+ (a*b));
        System.out.println("a/b: "+ (a/b));
        System.out.println("a%b: "+ (a%b));
        System.out.println("a|b: "+ (a|b));
        System.out.println("a++: "+ (a++));
        System.out.println("++a: "+ (++a));

        System.out.println("A list of all Bitwise operators");
        System.out.println("5&1 "+ (5 & 1));
        System.out.println("5|1 "+ (5 | 1));
        System.out.println("~5 "+ (~ 5));
        System.out.println("5^1 "+ (5 ^ 1));
        System.out.println("9 <<1 "+ (9 << 1));
        System.out.println("9 >>1 "+ (9 >> 1));
        System.out.println("9 >>>1 "+ (9 >>> 1));

        System.out.println("To print binary (bit) values");
        System.out.println("Printing bit values of 0 to 10 =");
        for (int i=0; i<=10; i++){
            System.out.println("Binary(bit) value of ("+i+")=" + Integer.toBinaryString(i));
            System.out.println("Binary(bit) count of ("+i+")=" + Integer.bitCount(i));
        }

        int max = Integer.MAX_VALUE;
        System.out.println("Binary(bit) value of Integer.MAX_VALUE=" + Integer.toBinaryString(max));
        System.out.println("Binary(bit) count of bit 1's Integer.MAX_VALUE=" + Integer.bitCount(max));

        long twoPower32 = (long) Math.pow(2, 32);
        System.out.println("twoPower32 (2 to power 32) =" + twoPower32);
        System.out.println("twoPower32 Binary(bit) value =" + Long.toBinaryString(twoPower32));

        for (int i=0; i< 64; i++){
            System.out.println("twoPower ("+i+")  =" + (long) Math.pow(2, i));
        }

        System.out.println("2 power -2 ="+ Math.pow(2, -2));




    }
}
