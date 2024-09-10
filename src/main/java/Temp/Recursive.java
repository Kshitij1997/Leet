package Temp;

public class Recursive {
    public static void main(String []args){
        System.out.println(recursive_Factorial(5));
    }

    // fn = n * fn-1
    // if n == 0 1
    public static int recursive_Factorial(int n){

        if( n == 0){
            return 1;
        }

        return  n * recursive_Factorial(n-1);
    }
}

