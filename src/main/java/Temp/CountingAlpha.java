package Temp;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

import  java.io.*;

public class CountingAlpha {
    public static void main (String[] args){
        System.out.println("Enter string");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(count_using_hm(str));
        count_using_array(str);

    }

    public static HashMap<Character,Integer> count_using_hm(String lstr){
        String str = lstr.toLowerCase();
        HashMap<Character,Integer> count_hm = new HashMap<Character, Integer>();
        for (int i=0;i<str.length();i++){
            Character c =str.charAt(i);
            count_hm.put(c,count_hm.getOrDefault(c,0)+1);
        }
        return count_hm;
    }

    public static void count_using_array(String str){
        String lstr = str.toLowerCase();

        int[] frequency = new int[26];

        for(int i =0 ; i< lstr.length(); i++){
            frequency[lstr.charAt(i) - 'a']++;
        }

        for(int i=0 ; i<lstr.length() ; i++){
            if(frequency[lstr.charAt(i)-'a']>0){
                System.out.println(str.charAt(i) + " : " + frequency[lstr.charAt(i)-'a']);
                frequency[lstr.charAt(i)-'a']=0;
            }

        }
    }


}
