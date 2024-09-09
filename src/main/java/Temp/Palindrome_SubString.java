package Temp;

public class Palindrome_SubString {
    public static void main(String args[]){

        System.out.println(longestPalindrome("babax"));
    }

    public static String longestPalindrome(String s) {

        if(s.equals(null)){
            return null;
        }

        if(s.length()==1){
            return s;
        }

        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)){
                return s;
            }else{
                return s.substring(0,1);
            }
        }

        int [][]pal = new int[s.length()][s.length()];
        for (int i=0;i<s.length();i++){
            for(int j=0; j<s.length(); j++){
                if(i==j){
                    pal[i][j]=1;
                }

                if(Math.abs(j-i) ==1){
                    if(s.charAt(j)==s.charAt(i)){
                        pal[i][j]=1;
                    }else{
                        pal[i][j]=0;
                    }
                }
            }
        }

        return getPalindrome(pal,s);

    }

    private static String getPalindrome(int[][] pal, String s) {
        int diff = 2;
        while(diff <= s.length()-1){
            int i=0;
            int j=i+diff;
            while(j!=s.length()){
                if((s.charAt(i)==s.charAt(j)) && pal[i+1][j-1]==1){
                    pal[i][j]=1;
                }else{
                    pal[i][j]=0;
                }
                i++;
                j++;
            }
            diff++;
        }

        int max =0;
        int []ind = new int[2];
        for(int p=0;p<s.length();p++){
            for(int q=p;q<s.length();q++){
                if(pal[p][q]==1 && Math.abs(p-q)>max){
                    max = Math.abs(p-q);
                    ind[0]=p;
                    ind[1]=q;
                }
            }
        }
        return s.substring(ind[0],ind[1]+1);
    }
}
