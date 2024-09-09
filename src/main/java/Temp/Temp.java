package Temp;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.sort;

public class Temp  {

    public static void main(String args[]){
//        System.out.println("Enter : ");
//        Scanner scanner = new Scanner(System.in);
//        stringTrimming(scanner.nextLine());



//        Integer[] a = {1,2,3} ;
//
//        List<Integer> tmp = Arrays.asList(1,2,3,4);
//
//        List<Integer> ints = Arrays.asList(a);
//
//
//
//        int[] a = new int[5];
//        try{
//            a[6]  = 30/0 * a[6];
//        }catch(ArrayIndexOutOfBoundsException e){
//            System.out.println("Array Index out of bounds");
//        }catch(ArithmeticException e){
//            System.out.println("Arithmetic exception");
//        }


        int [] a = {1,5,2,3,8,1};
        Arrays.sort(a);
        System.out.println();

        String s ="helooo";
        System.out.println(s.substring(0,1));

    }

    static void test_Hash_Set(){

        try{
            return;
        }catch (Exception e){

        }finally {
            System.out.println("This block gets executed no matter what");
        }
        System.out.println("Enter your name:");
        Scanner sc = new Scanner(System.in);

        String arg = sc.next();
        int x=sc.nextInt();
        Integer[] a = {1,2,3,};
        Set<Integer> hs = new HashSet<>(Arrays.asList(a));
        System.out.println(hs);

        String[] array = {"a", "b", "c"};
        Set<String> set = new HashSet<>(Arrays.asList(array));

        System.out.println(Arrays.toString(a));
    }

   public static LinkedHashMap<Integer, String> sortHM (HashMap<Integer, String> passedHM){
//       HashMap<Integer,String> hm = new HashMap<Integer,String>();
//       hm.put(1,"zil");
//       hm.put(6,"audrey");
//       hm.put(3,"dave");
//       hm.put(4,"dave");
//       hm.put(5,"karen");
//       hm.put(9,"leman");
//
//       System.out.println("The sorted hm is:" + sortHM (hm));
        LinkedHashMap<Integer,String> sortedHM = new LinkedHashMap<Integer,String>();

        List<Integer> keys = new ArrayList<Integer>(passedHM.keySet());
        List<String> vals = new ArrayList<String>(passedHM.values());

        Collections.sort(keys);
        Collections.sort(vals);

        Iterator<String> valueit = vals.iterator();

        while (valueit.hasNext()){
            String val = valueit.next();
            Iterator<Integer> keyit = keys.iterator();
            while(keyit.hasNext()){
                Integer k = keyit.next();
                String cmp1 = passedHM.get(k);
                String cmp2 = val;

                if(cmp1.equals(cmp2)){
                    sortedHM.put(k,val);
                    keyit.remove();
                    break;
                }
            }

        }

        return  sortedHM;
    }

    public static  void stringTrimming(String s){
        System.out.println("Trimmed : " + s.trim().replaceAll(" +"," "));
    }

    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> hm = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {

            Character si = s.charAt(i);
            Character ti = t.charAt(i);

            if (hm.containsKey(si)) {
                if (hm.get(si) != ti) {
                    return false;
                } else {
                    if (hm.containsValue(ti)) return false;
                    else hm.put(si, ti);
                }
            }
        }
    return true;
    }



    public static boolean wordPattern(String pattern, String s) {

        // "abba"  = "dog cat cat dog"
        // a -> dog
        // b -> cat
        s= s.trim().replaceAll(" +"," ");
        String[] astr = s.split(" ");
        if(pattern.length() != astr.length){
            return false;
        }

        HashMap<Character,String> hm = new HashMap<Character,String>();

        for(int i =0 ; i< pattern.length() ; i++){
            char k = pattern.charAt(i);
            if(hm.containsKey(k)){
                System.out.println(astr[i]);
                if(!hm.get(k).equals(astr[i])){
                    return false;
                }
            }else{
                if(hm.containsValue(astr[i])) return false;
                hm.put(k,astr[i]);
            }
        }

        return true;

    }
    
    public static void streamUsage (){
        List<Integer> r = new ArrayList<Integer>(IntStream.range(0,10).boxed().collect(Collectors.toList()));
        System.out.println(r);

        // return list of character that are in both the strings

        String a1 = "liverpool";
        String a2 = "manchester";


    }

}




