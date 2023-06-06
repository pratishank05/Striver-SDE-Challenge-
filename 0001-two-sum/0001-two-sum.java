class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n= nums.length;
        int[] ans=new int[2];
        ArrayList<Integer> arrli= new ArrayList<>();
        for(int i:nums)arrli.add(i);
        outer: for(int i=0;i<n;i++){
            int diff=target-nums[i];
            if(arrli.contains(diff)&& arrli.indexOf(diff)!=i){
                ans[0]=i;
                ans[1]=arrli.indexOf(diff);
                break outer;
            }
        }
        return ans;
    }
}