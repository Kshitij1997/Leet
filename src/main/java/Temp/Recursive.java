package Temp;

public class Recursive {
    public static void main(String []args){

        System.out.println(recursive_Factorial(5));
        System.out.println(recursive_Fibo(19));
    }

    // fn = n * fn-1
    // if n == 0 1
    public static int recursive_Factorial(int n){

        if( n == 0){
            return 1;
        }

        return  n * recursive_Factorial(n-1);
    }

    // return nth fibonacci number
    // fn = f(n-1) + f(n-2)
    // n = 1 , 0
    // n = 2  = 1
    public static int recursive_Fibo(int n){
        if(n <= 0){
            return -1;
        }
        if(n == 1){
            return 0;
        } else if (n == 2) {
            return 1;
        }
        return recursive_Fibo(n-1) + recursive_Fibo(n-2);
    }
}

