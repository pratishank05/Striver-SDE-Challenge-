class Solution {
    public int singleNumber(int[] nums) {
        // HashMap<Integer,Integer> map=new HashMap<>();

          Map<Integer,Integer> map = new HashMap();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0) + 1);
        }
        // Putting values in priority queue 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(a) - map.get(b));
        pq.addAll(map.keySet());

        return pq.poll();
    }
}