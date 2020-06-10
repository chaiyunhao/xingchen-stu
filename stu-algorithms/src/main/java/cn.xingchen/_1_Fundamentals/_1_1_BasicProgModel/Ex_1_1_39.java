package cn.xingchen._1_Fundamentals._1_1_BasicProgModel;

import cn.xingchen.StdLib.StdOut;
import cn.xingchen.StdLib.StdRandom;

import java.util.Arrays;

public class Ex_1_1_39 {

    public static int experiment(int n) {
        int[] a = new int[n],
              b = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(100000, 1000000);
            b[i] = StdRandom.uniform(100000, 1000000);
        }
        
        Arrays.sort(b);
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (BinarySearch.rank(a[i], b) >= 0) {
                count++;
            }
        }
        
        return count;
    }
    
    public static void batch(int t, int n) {
        long count = 0;
        for (int i = 0; i < t; i++) {
            count += experiment(n);
        }
        
        double avg = 1.0 * count / t;
        
        StdOut.printf("%8d: %9.2f\n", n, avg);
    }
    
    public static void main(String[] args) {
        int t = Integer.parseInt(args[0]);
        
        int[] ns = { 1000, 10000, 100000, 1000000 };

        for (int n : ns) {
            batch(t, n);
        }
        
        /*
                 1000:      0.96
                10000:    110.68
               100000:  10527.36
              1000000: 670822.20
         */
    }
}
