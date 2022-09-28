package polynomial;

import java.util.Scanner;

public class Term {
    int coeff;
    int exponent;
    
    Term() {
    	
    }
    
    Term(int c,int e)
    {
        this.coeff=c;
        this.exponent=e;
    }
    
    void read(Scanner scan) {
        coeff=scan.nextInt();
        exponent=scan.nextInt();
    }
    
    void printTerm() {
        if(exponent!=0)
            System.out.format("%d x ^ %d", coeff, exponent);
        else if (exponent == 1)
            System.out.format("%d x", coeff);
        else
            System.out.format("%d", coeff);
    }
    
    int calc(int x) {
        return (int)(coeff * Math.pow(x, exponent));
    }
    
    boolean equals(int e)
    {
        return ((exponent==e) ? true : false);
    }
    
    int compare(int e)
    {
        if(exponent>=1)
        {
            return exponent==e ? 0 :1;
        }
        return -1;
    }
    
    void add(int c) {
        this.coeff += c;
    }
}