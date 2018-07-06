/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indigotest;

/**
 *
 * @author Valenzuela
 */
public class LPS {
    private int K;
    private int N;
    private long number;

    public static void main(String[] args) {
        LPS lps = new LPS();
        
        long num= 3675356291l;
       
        lps.setK(5);
        lps.setN(10);
        lps.setNumber(num);
        System.out.println(lps.findGP());
        
    }
    
    public void setNumber(long number){
        this.number=number;
    }
    public void setK(int K){
        if(K< 1)K=1;
        else if(K>7)K=7;
        
        this.K= K;
    }
    public void setN(int N){
        if(N < this.K)N=this.K;
        else if(N > 1000)N=1000;
        
        this.N=N;
    }
    
    public long  findGP(){
        int i=0;
        long subNumber;
        long multiply;
        long maximum=0;
        
        while(continueSplit(i,this.number)){
            subNumber = splitNumber(i,this.number);
            multiply = multiplyDigits(subNumber);
            if(maximum < multiply)
                maximum = multiply;
            i++;
        }
        return maximum;
    } 
    
    public boolean continueSplit(int startPos, long number){
        String snumber = String.valueOf(number);
        String subNumber= snumber.substring(startPos);
        if(subNumber.length()>=this.K)return true;
        return false;
    }
    
    public long splitNumber(int startPos, long number){
        String snumber = String.valueOf(number);
        String subNumber="0";
        long result;
        subNumber = snumber.substring(startPos,startPos + this.K);
        result= Long.parseLong(subNumber);
        return result;
    }
    
    public long multiplyDigits(long number){
        long digit;
        long multiply=1;
        while(number>0){
            digit = number%10;
            number/=10;
            multiply*=digit;
        }
        return multiply;
    }
    
}
