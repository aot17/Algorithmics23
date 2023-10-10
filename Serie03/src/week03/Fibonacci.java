package week03;

import org.w3c.dom.ls.LSOutput;

public class Fibonacci {
    //     Function Implementation:
    //          Create two functions to calculate the n-th Fibonacci number:
    //          One using a naive approach with O(2^n) complexity.
    //          Another using a more efficient approach with O(n) complexity.


    // approach with O(2^n) complexity.


    static int printFibonacciSimple(int n) {
        // Here, there is two steps in the return statement, which makes the method be executed twice, and it leads to an unefficient algorithm O(2^n).

            if (n <= 1)
                return 1;
            else

                return printFibonacciSimple(n - 1) + printFibonacciSimple(n - 2);
    }


    // approach with O(n) complexity.
    static int n1=0,n2=1,n3=0;
    static void printFibonacciEfficient(int count){
        // Here, there is only one step, it stores the values of the two old number which lead to one step efficient algorithm O(n) complexity

        if(count>0){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;

            System.out.print(" "+n3);
            printFibonacciEfficient(count-1);
        }

    }


    //    Time Measurement:
    //          Use Java's System.currentTimeMillis() function to measure the time it takes to calculate the n-th Fibonacci number for each approach.
    //          This will help determine the execution time of each function.
    public static void main(String args[]){
//          printFibonacciEfficient
        int count=10;
        int realCount=count-2;
        System.out.print("The " + realCount + " first Fibonnaci number are : ");
//        System.out.print(n1+" "+n2);
        long timeStart0 = System.currentTimeMillis();
        printFibonacciEfficient(realCount);
        long timeEnd0 = System.currentTimeMillis();
        long totalTime0 = timeEnd0-timeStart0;
        System.out.println( "\n" + "This approach takes " + totalTime0 + " ms");


        //  printFibonacciSimple
        int n = 8;
        long timeStart = System.currentTimeMillis();
        int result = printFibonacciSimple(n);
        long timeEnd = System.currentTimeMillis();
        long totalTime = timeEnd-timeStart;
        System.out.println("\n" +"The " + n + "-th Fibonnaci number is : "+ result +"\n" + "This approach takes " + totalTime + " ms");

    }


    //    Time Measurement:
    //          Use Java's System.currentTimeMillis() function to measure the time it takes to calculate the n-th Fibonacci number for each approach.
    //          This will help determine the execution time of each function.
    //
    //    Plotting Results:
    //          Plot the results of the calculations on a graph with a normal scale.
    //          Plot the results on a log-log scale graph. This means both the x-axis and y-axis should be in logarithmic scales.
    //
    //    Interpretation:
    //          Provide a brief interpretation of the results obtained from the calculations and graphs.
    //          This should include an analysis of the execution time differences between the two approaches and any observations made from the plotted graphs.





}
