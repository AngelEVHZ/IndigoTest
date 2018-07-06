/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indigotest;

import java.util.Scanner;

/**
 *
 * @author Valenzuela
 */
public class LPP {
    private int N;

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("T = ");
        int T = scan.nextInt();
        int []palindromes = new int[T];
        int N;
        LPP lpp = new LPP();
        if(T<1)T=1;
        else if(T>100)T=100;
        
        for(int i=0; i<T;i++){
            System.out.println("N = ");
            N = scan.nextInt();
            lpp.setN(N);
            palindromes[i] = lpp.findLPP();
        }
        System.out.println("");
        for(int i=0; i<palindromes.length;i++){
            System.out.println(palindromes[i]);
        }
           
    }
    

    public void setN(int N){
        if( (101101 > N) ){
            this.N=101102;
        } else if(  N >= 1000000){
            this.N = 999999;
        } else{
            this.N=N;
        }
    }
    
    public int findLPP(){
        int min =100;
        int max=999;
        int largest=0;
        int mult;
        for(int a=max; a >= min; a--){
            for(int b=max ; b >= min; b--){
                mult= a*b;
                if( mult < this.N ){
                    if( isPalindrome(mult)){
                        if(mult > largest){
                            largest = mult;
                        }
                    }
                }
            }
        }
        return largest;
    }
    
    public boolean isPalindrome(int number){
        int originalN = number;
        int newN= 0;
        while(number > 0) { 
            newN = newN*10 + number%10; 
            number /= 10; 
        } 
        return originalN == newN; 
    }
    
}
