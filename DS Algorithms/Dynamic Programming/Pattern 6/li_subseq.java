
// Longest Increasing Subsequence
// Given a sequence of numbers
// find the length of the
// longest subsequence such that
// all elements of the subsequence
// are in increasing order
public class li_subseq {

    static int calls = 0;
    static Integer[] result;

    // given a sequence of numbers
    // find the length of longest increasing subsequence 
    // starting at index i
    // public static int lis(int[] nums, int i) {
    //     calls++;
    //     if (i == nums.length-1) {
    //         return 1;
    //     }
        
    //     int max_length = 1;
    //     // we look for numbers greater than nums[i]
    //     // if we can find one we find the li subseq from that number
    //     // we do this for each number
    //     for (int k=i+1; k<nums.length;k++) {
    //         if (nums[k] > nums[i]) {
    //             max_length = Math.max(max_length, 1+lis(nums,k));
    //         }
    //     }

    //     return max_length;
    // }

    public static int lis(int[] nums, int i) {
        //calls++;
        if (i == nums.length-1) {
            return 1;
        }

        if (result[i] != null) {
            return result[i];
        }
        
        int max_length = 1;
        // we look for numbers greater than nums[i]
        // if we can find one we find the li subseq from that number
        // we do this for each number
        for (int k=i+1; k<nums.length;k++) {
            if (nums[k] > nums[i]) {
                max_length = Math.max(max_length, 1+lis(nums,k));
            }
        }

        result[i] = max_length;
        return result[i];
    }
    

    public static void main(String[] args) {

        int[] NUMS = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        
        result = new Integer[NUMS.length+1];
        //int length = ed(s1,s2,0,0);
        int ml = 1;
        for (int i=0; i<NUMS.length; i++) {
            int length = lis(NUMS,i);
            ml = Math.max(ml, length);
        }
        System.out.println("LONGEST INCREASING SUBSEQUENCE : " + ml);        
        //System.out.println(calls);
    }
}