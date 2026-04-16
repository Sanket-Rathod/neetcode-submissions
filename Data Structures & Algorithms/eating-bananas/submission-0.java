class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1,hi=0;
        for(int pile:piles){
            hi = Math.max(hi,pile);
        }
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            System.out.println(lo + " : " + mid+ " : "+ hi);
            if(canEat(piles, h, mid)){
                hi = mid;
            }
            else lo = mid+1;
        }
        return hi;
    }
    private boolean canEat(int[] piles, int totalHours, int rate){
        int countOfHours = 0;
        for(int bananas:piles){
            countOfHours += Math.ceil((double)bananas/(double)rate);
            if(countOfHours > totalHours)return false;
        }
        System.out.println(rate + " : " + countOfHours);
        return countOfHours <= totalHours;
    }
}
