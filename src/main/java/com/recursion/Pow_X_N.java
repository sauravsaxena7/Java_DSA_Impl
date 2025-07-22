package com.recursion;

/**
 Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 Example 1:

 Input: x = 2.00000, n = 10
 Output: 1024.00000
 Example 2:

 Input: x = 2.10000, n = 3
 Output: 9.26100
 Example 3:

 Input: x = 2.00000, n = -2
 Output: 0.25000
 Explanation: 2-2 = 1/22 = 1/4 = 0.25


 Constraints:

 -100.0 < x < 100.0
 -231 <= n <= 231-1
 n is an integer.
 Either x is not zero or n > 0.
 -104 <= xn <= 104

 */

public class Pow_X_N {

    private static double powerTo(double x, int n,int flag) {

        if(n==0){
            return x;
        }
        System.out.println("Flag::: "+flag+" x::: "+x);
        if(flag==-1){
            x=1/x*(powerTo(x,n/2,flag));
        }else{
            double res=powerTo(x,n/2,flag) ;
            x=x*res;
            System.out.println("n::"+n+" Flag::: "+flag+" x::: "+x+" res:: "+res);
        }

        //x=x*x;

        return x;

    }


    public static double myPow(double x, int n) {

        int flag = 1;
        if(n<0) flag=-1;
        double result = powerTo(x,Math.abs(n),flag);

        System.out.println("result: "+result);


//        if(n%2==0){
//            if(flag==-1){
//                result= (1/(result*result));
//            }else{
//                result=result*result;
//            }
//
//        }else{
//            if(flag==-1){
//                result=1/(result*result*x);
//            }else{
//                result=result*result*x;
//            }
//        }
        return result;

    }



    public static void main(String [] args){
        System.out.println(myPow(2.0,6));
    }
}
