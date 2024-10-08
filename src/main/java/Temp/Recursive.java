package Temp;

public class Recursive {
    public static void main(String []args){

        System.out.println(recursive_Factorial(5));
        System.out.println(recursive_Fibo(19));
        System.out.println(getSubsets("abc"));
        System.out.println(getSpacePermute("abc"));
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

    public static ArrayList<String> getSpacePermute(String str){

        ArrayList<String> listOfStrings = new ArrayList<>();
        String op = str.substring(0,1);

        // remember to check condition of str length ==1
        // if the length is one the remaining substring will be ""
        String ip = str.length() == 1 ? "" : str.substring(1);
        getSpacePermuteHelper(ip, op, listOfStrings);

        return listOfStrings;
    }

    private static void getSpacePermuteHelper(String ip, String op, ArrayList<String> listOfStrings){

        if(ip.length() == 0){
            listOfStrings.add(op);
            // make sure you add this return statement
            return;
        }

        String op1 = op + ip.substring(0,1);
        String op2 = op +" "+ ip.substring(0,1);
        String ip_ = ip.length() == 1 ? "" : ip.substring(1);

        getSpacePermuteHelper(ip_, op1, listOfStrings);
        getSpacePermuteHelper(ip_, op2, listOfStrings);
    }
}

