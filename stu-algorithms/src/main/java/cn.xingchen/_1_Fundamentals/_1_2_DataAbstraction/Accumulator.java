package cn.xingchen._1_Fundamentals._1_2_DataAbstraction;

/*************************************************************************
 *  Compilation:  javac Accumulator.java
 *
 *  Mutable data type that calculates mean of data values.
 *
 *************************************************************************/


public class Accumulator {
    private double total;
    private int N;

    public void addDataValue(double val) {
        N++;
        total += val;
    }

    public double mean() {
        return total / N;
    }

    @Override
    public String toString() {
        return "Mean (" + N + " values): " + String.format("%7.5f", mean());
    }
}
