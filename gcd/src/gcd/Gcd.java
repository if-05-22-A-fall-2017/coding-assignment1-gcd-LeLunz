/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Luis
 */
public class Gcd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = gcdPrimeFactors(13, 13); // Answer: 13
        int b = gcdEucledian(13, 13);
        if (a == b && a == 13) {System.out.println("Test 1 is right");}
        else{System.out.println("Error Test 1 False");}
        a = gcdPrimeFactors(37, 600); // Answer: 1
        b = gcdEucledian(37, 600);
        if (a == b && a == 1) {System.out.println("Test 2 is right");}
        else{System.out.println("Error Test 2 False");}
        a = gcdPrimeFactors(20, 100); // Answer: 20 
        b = gcdEucledian(20, 100);
        if (a == b && a == 20) {System.out.println("Test 3 is right");}
        else{System.out.println("Error Test 3 False");}
        a = gcdPrimeFactors(624129, 2061517); // Answer: 18913
        b = gcdEucledian(624129, 2061517);
        if (a == b && a == 18913) {System.out.println("Test 4 is right");}
        else{System.out.println("Error Test 4 False");}
    }
    public static int gcdPrimeFactors(int a, int b){
        List<Integer> numbers1 = new LinkedList<>();
        List<Integer> numbers2 = new LinkedList<>();
        int res = 1;
        while(a != 1){
            int x = LittlestPrime(a);
            a = a / x;
            numbers1.add(x);
        }
        while(b != 1){
            int x = LittlestPrime(b);
            b = b / x;
            numbers2.add(x);
        }
        for (int x : numbers1) {
            if (numbers2.contains(x)) {
                res *= x;
                numbers2.remove(new Integer(x));
            }
        }
        return res;
    }
    public static int LittlestPrime(int prime){
        for (int i = 2; i <= prime; i++) {
            int j;
            for (j = 2; j < i; j++) {
                if (i % j == 0 && i != j) {
                    break;
                }
            }
            if (i % j != 0 || i == j) {
                if (prime % j == 0) {
                    return j;
                }
            }
        }
        return 1;
    }
    public static int gcdEucledian(int a, int b){
        return b != 0 ? gcdEucledian(b, a%b) : a;
    }
}
