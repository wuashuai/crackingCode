package leetcode;


//Partition to K Equal Sum Subsets
//Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//Output: True
//Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

import java.util.Arrays;

public class KSumPartition {

    public static void main(String[] args){

        KSumPartition ks = new KSumPartition();

        int[] nums = {4, 3, 2, 3, 5, 2, 1};

        System.out.println(ks.canPartitionKSubsets(nums, 4));

        nums = new int[]{4, 3, 2, 3, 5, 2, 5};

        System.out.println(ks.canPartitionKSubsets(nums, 4));

        nums = new int[]{2, 5, 2, 5, 2, 5, 6, 1};

        System.out.println(ks.canPartitionKSubsets(nums, 4));

    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0) return false;

        int average = sum / k;

        int[] sums = new int[k];

        return helper(sums, average, nums, 0);
    }

    public boolean helper(int[] sums, int average, int[] nums, int start){
        if(start == nums.length) return true;

        for(int i = 0; i < sums.length; i++){
            if(sums[i] + nums[start] > average){
                continue;
            }
            sums[i] += nums[start];
            if(helper(sums, average, nums, start + 1)) return true;
            sums[i] -= nums[start];
        }

        return false;
    }
}
