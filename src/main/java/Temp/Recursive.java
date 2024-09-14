package Temp;

public class Recursive {
    public static void main(String []args){

        System.out.println(recursive_Factorial(5));
        System.out.println(recursive_Fibo(19));
        System.out.println(getSubsets("abc"));
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

    // return all the subsets for a string
    // to get unique subsets pass hashset
    public static ArrayList<String> getSubsets(String str){
        String op = "";
        ArrayList<String> subsets = new ArrayList<>();
        getSubsetRecursive(str,op,subsets);
        return  subsets;
    }

    private static void getSubsetRecursive(String ip, String op, ArrayList<String> subsets){
        if(ip == ""){

            // when the i/p is empty string, add the o/p to subsets, which is final o/p
            subsets.add(op);
            return;
        }

        // We have 2 choices
        // to get either consider the first char, or to neglect it
        String op1 = op;

        // inserting the first char to the op
        String op2 = op + ip.substring(0,1);

        ip = ip.length() == 1?"":ip.substring(1);

        getSubsetRecursive(ip,op1,subsets);
        getSubsetRecursive(ip, op2, subsets);
    }
}

