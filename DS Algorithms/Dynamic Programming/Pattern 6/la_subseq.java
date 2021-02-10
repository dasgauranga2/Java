
// Longest Alternating Subsequence
// Given a sequence find the length of the
// longest subsequence such that
// it is alternating
// A sequence x1,x2,...,xn is alternating if
// x1 < x2 > x3 < x4 > x5 < .... xn or
// x1 > x2 < x3 > x4 < x5 > .... xn
public class la_subseq {

    static int calls = 0;
    static Integer[][] result;

    // given a sequence of numbers
    // find the length of longest alternating subsequence 
    // starting at index i
    // public static int las(int[] nums, int i, boolean flag) {
    //     calls++;
    //     if (i == nums.length-1) {
    //         return 1;
    //     }

    //     int length = 0;
    //     for (int j=i+1; j<nums.length; j++) {
    //         // for index greater than i
    //         // we look for an element
    //         // greater/lesser than nums[i]
    //         // flag tells us whether we should look
    //         // for a greater or smaller element
    //         if (flag && nums[j] > nums[i]) {
    //             length = Math.max(length,1 + las(nums,j,false));
    //         }
    //         else if (!flag && nums[j] < nums[i]) {
    //             length = Math.max(length,1 + las(nums,j,true));
    //         }
    //     }

    //     return length;
    // }

    public static int int_bool(boolean a) {
        if (a) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int las(int[] nums, int i, boolean flag) {
        //calls++;
        if (i == nums.length-1) {
            return 1;
        }

        if (result[i][int_bool(flag)] != null) {
            return result[i][int_bool(flag)];
        }

        int length = 0;
        for (int j=i+1; j<nums.length; j++) {
            // for index greater than i
            // we look for an element
            // greater or smaller than nums[i]
            // flag tells us whether we should look
            // for a greater or smaller element
            if (flag && nums[j] > nums[i]) {
                length = Math.max(length,1 + las(nums,j,false));
            }
            else if (!flag && nums[j] < nums[i]) {
                length = Math.max(length,1 + las(nums,j,true));
            }
        }

        result[i][int_bool(flag)] = length;
        return result[i][int_bool(flag)];
    }

    public static void main(String[] args) {

        int[] NUMS = {10, 22, 9, 33, 49, 50, 31, 60};
        
        result = new Integer[NUMS.length+1][2];
        // thr first element will always be part of the
        // longest alternating subsequence
        // from first element we look for subsequences
        // such that next element is grater or smaller than first element
        // then find out the max of both of them
        int length = Math.max(las(NUMS,0,true), las(NUMS,0,false));
        System.out.println("LONGEST ALTERNATING SUBSEQUENCE : " + length);        
        //System.out.println(calls);


    }
}