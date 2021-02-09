
// Edit Distance
// Given two strings find the 
// minimum number of operations required
// to convert one string to another
// The following operations are valid :-
// 1. Insert one character
// 2. Delete one character
// 3. Replace one character with another character
public class edit_distance {

    static int calls = 0;
    static Integer[][] result;

    // given two strings
    // get the edit distance between them 
    // public static int ed(String s1, String s2, int i, int j) {
    //     calls++;
    //     if (i == s1.length()) {
    //         return s2.length()-j;
    //     }
    //     if (j == s2.length()) {
    //         return s1.length()-i;
    //     }

    //     // if characters at s1[i] and s2[j] are equal
    //     // find the edit distance for the rest of the strings
    //     if (s1.charAt(i) == s2.charAt(j)) {
    //         return ed(s1,s2,i+1,j+1);
    //     } 

    //     // else if characters at s1[i] and s2[j] are not equal
    //     // we can perform one of the three operations

    //     // 1. replace s1[i] with s2[j]
    //     int cost1 = 1 + ed(s1,s2,i+1,j+1);
    //     // 2. delete character s1[i]
    //     int cost2 = 1 + ed(s1,s2,i+1,j);
    //     // 3. insert s2[j] at the beginning of s1
    //     int cost3 = 1 + ed(s1,s2,i,j+1);

    //     return Math.min(cost1,Math.min(cost2,cost3));
    // }

    public static int ed(String s1, String s2, int i, int j) {
        //calls++;
        if (i == s1.length()) {
            return s2.length()-j;
        }
        if (j == s2.length()) {
            return s1.length()-i;
        }

        if (result[i][j] != null) {
            return result[i][j];
        }

        // if characters at s1[i] and s2[j] are equal
        // find the edit distance for the rest of the strings
        if (s1.charAt(i) == s2.charAt(j)) {
            result[i][j] =  ed(s1,s2,i+1,j+1);
        }
        else {
            // else if characters at s1[i] and s2[j] are not equal
            // we can perform one of the three operations

            // 1. replace s1[i] with s2[j]
            int cost1 = 1 + ed(s1,s2,i+1,j+1);
            // 2. delete character s1[i]
            int cost2 = 1 + ed(s1,s2,i+1,j);
            // 3. insert s2[j] at the beginning of s1
            int cost3 = 1 + ed(s1,s2,i,j+1);

            result[i][j] = Math.min(cost1,Math.min(cost2,cost3));
        }
        
        return result[i][j];
    }

    public static void main(String[] args) {

        String s1 = "food";
        String s2 = "money";
        
        result = new Integer[s1.length()+1][s2.length()+1];
        int distance = ed(s1,s2,0,0);
        
        System.out.println("EDIT DISTANCE : " + distance);
        //System.out.println(calls);
    }
}