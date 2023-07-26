class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n=dist.length;
        if(n-1>=hour){
            return -1;
        }
        
        int l=0,r=10000000;
        double sum=0.0;
        while(l<=r){
            int mid=(l+r)/2;
            for(int i=0; i<n-1; i++){
                sum+=Math.ceil((double)dist[i]/mid);
            }
            sum+=(double)dist[n-1]/mid;
            if(sum<=hour){
                r=mid-1;
            }else{
                l=mid+1;
            }
            sum=0.0;
        }
        return r+1;
    }
}