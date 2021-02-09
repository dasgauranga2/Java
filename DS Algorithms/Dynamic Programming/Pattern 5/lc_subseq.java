
// Longest Common Subsequence
// Given two strings, find the 
// length of longest subsequence present in both of them
// A subsequence is a sequence that appears in the same relative order
// but not necessarily contiguous
public class lc_subseq {

    static int calls = 0;
    static Integer[][] result;

    // given two strings
    // find the length of the 
    // longest common subsequence
    // public static int lcs(String s1, String s2, int i, int j) {
    //     calls++;
    //     if (i == s1.length() || j == s2.length()) {
    //         return 0;
    //     }
    //     // if the characters s1[i] and s2[j] are equal
    //     // include them in the longest common subsequence
    //     // and find the lc subseq for the rest of the strings
    //     if (s1.charAt(i) == s2.charAt(j)) {
    //         return 1 + lcs(s1,s2,i+1,j+1);
    //     }

    //     // if the characters s1[i] and s2[j] are not equal
    //     // we can remove s1[i] and find lc subseq for the rest of the strings
    //     int l1 = lcs(s1,s2,i+1,j);
    //     // we can remove s2[j] and find lc subseq for the rest of the strings
    //     int l2 = lcs(s1,s2,i,j+1);

    //     // the lc subseq is the
    //     // maximum of the above results
    //     return Math.max(l1,l2);
    // }

    public static int lcs(String s1, String s2, int i, int j) {
        //calls++;
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (result[i][j] != null) {
            return result[i][j];
        }

        // if the characters s1[i] and s2[j] are equal
        // include them in the longest common subsequence
        // and find the lc subseq for the rest of the strings
        if (s1.charAt(i) == s2.charAt(j)) {
            result[i][j] = 1 + lcs(s1,s2,i+1,j+1);
        }
        else {
            // if the characters s1[i] and s2[j] are not equal
            // we can remove s1[i] and find lc subseq for the rest of the strings
            int l1 = lcs(s1,s2,i+1,j);
            // we can remove s2[j] and find lc subseq for the rest of the strings
            int l2 = lcs(s1,s2,i,j+1);

            // the lc subseq is the
            // maximum of the above results
            result[i][j] =  Math.max(l1,l2);
        }

        return result[i][j];
    }

    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        
        result = new Integer[s1.length()+1][s2.length()+1];
        int length = lcs(s1,s2,0,0);
        
        System.out.println("LONGEST COMMON SUBSEQUENCE : " + length);
        //System.out.println(calls);
    }
}