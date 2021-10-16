class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int maxProfit = 0;
        List<Job> jobs = new ArrayList<>();
        for(int i = 0; i < startTime.length; i++){
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        
        jobs.sort((a, b) -> (a.endTime - b.endTime));
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(Job job: jobs){
            Integer lastBeforeStart = map.floorKey(job.startTime);
            int profitBeforeStart = lastBeforeStart == null ? 0 : map.get(lastBeforeStart);
            maxProfit = Math.max(maxProfit, profitBeforeStart + job.profit);
            map.put(job.endTime, maxProfit);
        }
        return maxProfit;
    }
    
    class Job {
            int startTime;
            int endTime;
            int profit;
            public Job(int startTime, int endTime, int profit){
                this.startTime = startTime;
                this.endTime = endTime;
                this.profit = profit;
            }
        }
}