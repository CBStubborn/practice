package personal.practices.basic;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
       if( b != 0) {
           return a / b;
       } else {
           return Integer.MIN_VALUE;
       }
    }
}
