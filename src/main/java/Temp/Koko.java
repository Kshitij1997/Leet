package Temp;

public class Koko {
    public static void main(String args[]){

        int [] piles = {30,11,23,4,20};

        System.out.println("Final result: " + minEatingSpeed(piles, 6));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        // complexity = O(NLog(MaxSpeed))
        // the max speed she will have is max(piles[i])
        // lowest speed will be 1
        // accepted answer lie as a subset ot 1 - max_ples[i]/h
        // find the lowest speed for which time <= h

        // Step 1 to get the list of acceptable answers

        int max_speed = getMax(piles);


        int low = 1;
        int high = max_speed;
        int mid =0;
        while(low <= high){
            mid = low + (high - low)/2;
            if(getHours(mid, piles) <= h){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        // IMP : return low remember if low is invalid then eventually it will
        // point to correct answer at the end, smae with high
        return low;
    }


    private static int getHours(int speed, int [] piles){
        int h =0 ;
        for(int i =0 ; i < piles.length ; i++){

            h += Math.ceil((double)piles[i]/speed);

        }

        return h;
    }


    private static int getMax(int [] piles){
        int mx = Integer.MIN_VALUE;

        for(int i =0 ; i< piles.length ; i++ ){
            if(mx <= piles[i]){
                mx = piles[i];
            }
        }

        return mx;
    }
}
