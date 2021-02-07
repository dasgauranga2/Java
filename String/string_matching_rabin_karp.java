
public class string_matching_rabin_karp {

    // d is the number of characters in the input set
    public final static int d = 10;

    static void search(String pattern, String txt, int q) {
        // length of the text
        int n = txt.length();
        // length of the pattern
        int m = pattern.length();
        int i, j;
        // variable for storing hash value of pattern
        int p = 0;
        // variable for storing hash value of text
        int t = 0;
        int h = 1;

        for (i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }
        
        // calculate hash value for pattern and text
        for (i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // find the match
        for (i = 0; i <= n - m; i++) {
            // check if the hash values of
            // pattern and text match
            if (p == t) {
                for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pattern.charAt(j))
                    break;
                }

                if (j == m)
                System.out.println("Pattern is found at position: " + (i + 1));
            }

            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;
                if (t < 0)
                t = (t + q);
            }
        }
    }

    public static void main(String[] args) {
        
        String txt = "AEFCDDAEFGZ";
        String pat = "AEF";
        // q is a prime number that can be randomly chosen
        int q = 13;

        search(pat, txt, q);
    }
}