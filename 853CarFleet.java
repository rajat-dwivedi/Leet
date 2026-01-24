//853https://leetcode.com/problems/car-fleet/
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //get the number of cars
        int n = position.length;
        
        //create a 2d array to store car data
        double[][] cardata = new double[n][2];
        
        for(int i=0;i<n;i++){
            //multiply with 1d to make double from int
            //stores the position
            cardata[i][0] = position[i]*1d;
            //stores the time taken
            cardata[i][1] = ((target-position[i])*1d)/speed[i];
        }
        
        //sort according to position 
        Arrays.sort(cardata,(a,b)->(Double.compare(a[0],b[0])));
        
        
        int nof = 1;
        double tt = cardata[n-1][1];
        for(int i=n-2;i>=0;i--){
            if(cardata[i][1]>tt){
                nof++;
                tt = cardata[i][1];
            }
        }
        
        return nof;
    }
}