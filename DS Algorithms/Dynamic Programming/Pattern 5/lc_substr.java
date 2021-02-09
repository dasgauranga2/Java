
// Longest Common Substring
// Given two strings, find the 
// length of the longest common substring
// A substring is a contiguous sequence of characters
public class lc_substr {

    static int calls = 0;
    static Integer[][][] result;

    // given two strings
    // find the length of the 
    // longest common substring
    public static int lcs(String s1, String s2, int i, int j, int length) {
        //calls++;
        if (i == s1.length() || j == s2.length()) {
            return length;
        }
        
        // 'length' is lc substr 
        // ending at s1[i-1] and s2[j-1]
        int l1 = length;
        // if characaters at s1[i] and s2[j] are equal
        // we find the lc substr from the rest of the strings
        if (s1.charAt(i)==s2.charAt(j)) {
            l1 = lcs(s1,s2,i+1,j+1,length+1);
        }
        // we can remove s1[i] and find lc substr for the rest of the strings
        int l2 = lcs(s1,s2,i+1,j,0);
        // we can remove s2[j] and find lc substr for the rest of the strings
        int l3 = lcs(s1,s2,i,j+1,0);

        return Math.max(l1,Math.max(l2,l3));
    }

    // public static int lcs(String s1, String s2, int i, int j, int length) {
    //     calls++;
    //     if (i == s1.length() || j == s2.length()) {
    //         return length;
    //     }

    //     if (result[i][j][length] != null) {
    //         return result[i][j][length];
    //     }
        
    //     int l1 = length;
    //     if (s1.charAt(i)==s2.charAt(j)) {
    //         l1 = lcs(s1,s2,i+1,j+1,length+1);
    //     }
    //     int l2 = lcs(s1,s2,i+1,j,0);
    //     int l3 = lcs(s1,s2,i,j+1,0);

    //     result[i][j][length] = Math.max(l1,Math.max(l2,l3));
    //     return result[i][j][length]; 
    // }

    public static void main(String[] args) {

        String s1 = "GeeksforGeeks";
        String s2 = "GeeksQuiz";
        
        result = new Integer[s1.length()+1][s2.length()+1][Math.max(s1.length(),s2.length())+1];
        int length = lcs(s1,s2,0,0,0);
        
        System.out.println("LONGEST COMMON SUBSTRING : " + length);
        //System.out.println(calls);
    }
}