class Solution {
    public void sortColors(int[] nums) {
int ones=0,zeros=0,twos=0,ct=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                zeros++;
            }
            if(nums[i]==1)
            {
                ones++;
            }
            if(nums[i]==2)
            {
                twos++;
            }
            }
        for(int i=0;i<zeros;i++)
        {
            nums[ct]=0;
            ct++;
        }
                for(int i=0;i<ones;i++)
        {
            nums[ct]=1;
            ct++;
        }        for(int i=0;i<twos;i++)
        {
            nums[ct]=2;
            ct++;
        }
        }
    }
