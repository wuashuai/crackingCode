package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerNumber {

    int[] count;

    public List<Integer> countSmaller(int[] nums) {

        if(nums.length == 0) return new ArrayList<>();

        count = new int[nums.length];

        int[] index = new int[nums.length];

        for(int i = 0; i < index.length; i++){
            index[i] = i;
        }

        helper(nums, index, 0, nums.length-1);

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) res.add(count[i]);

        return res;
    }

    public void helper(int[] nums, int[] index, int start, int end){

        if(start >= end) return;

        List<Integer> res = new ArrayList<>();

        int mid = (start + end) / 2;

        helper(nums, index, start, mid);
        helper(nums, index, mid+1, end);
        merge(nums, index, start, end);
    }

    public void merge(int[] nums, int[] index, int start, int end){
        int mid = (start + end) / 2;

        int i = start;
        int j = mid + 1;

        int c = start;

        int[] tmp = new int[nums.length];
        int[] tmpIndex = new int[nums.length];

        while(i <= mid || j <= end){
            int v = 0;
            if(i > mid){
                v = nums[j];
                tmpIndex[c] = index[j];
                j++;
            }else if(j > end){
                v = nums[i];
                count[index[i]] += (j-mid-1);
                tmpIndex[c] = index[i];
                i++;
            }else if(nums[i] > nums[j]){
                v = nums[j];
                tmpIndex[c] = index[j];
                j++;
            }else{
                v = nums[i];
                count[index[i]] += (j-mid-1);
                tmpIndex[c] = index[i];
                i++;
            }
            tmp[c++] = v;
        }

        for(i = start; i <= end; i++){
            nums[i] = tmp[i];
            index[i] = tmpIndex[i];
        }
    }

    public static void main(String[] args){
        CountSmallerNumber cs = new CountSmallerNumber();

        int[] nums = {5,2,6,1};
        cs.countSmaller(nums);
    }
}