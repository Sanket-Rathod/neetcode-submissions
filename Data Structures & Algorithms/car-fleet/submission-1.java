class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] pair = new int[n][2];
        for(int i=0;i<n;i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a,b) -> (a[0]-b[0]));
        double[] numberOfHours = new double[n];
        for(int i=0;i<n;i++){
            numberOfHours[i] = (double)(target-pair[i][0])/(double)pair[i][1];
        }
        double prevTime = numberOfHours[n-1];
        int carFleet =0;

        for(int i=n-1;i>=0;i--){
            double time = numberOfHours[i];
            System.out.println(prevTime + " : "+ time);
            if(prevTime < time){
                carFleet++;
                prevTime = time;
            }
            // carFleet++;//1,2,3,1
        }
        return ++carFleet;
    }
}
