
public class basic_operations {
    public static void main(String[] args) {
        
        String str = "Hello how are you";

        // length of the string
        System.out.println(str.length());

        String str1 = "abc";
        String str2 = "xyz";
        // concatenate two strings
        System.out.println(str1+str2);

        // get the character of a string
        // at the specified index 
        char ch = str.charAt(3);
        System.out.println(ch);

        // convert all the characters in a string
        // into a character array
        char[] char_array = str.toCharArray();

        String s1 = "hello";
        String s2 = "hell";
        String s3 = "hello";
        // compare two strings for equality
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));

        String s4 = "Ram"; 
        String s5 = "Ram"; 
        String s6 = "Shyam"; 
        String s7 = "ABC"; 
        // compare two strings lexicographically
        System.out.println(s4.compareTo(s5)); 
        System.out.println(s4.compareTo(s6)); 
        System.out.println(s4.compareTo(s7)); 
    }
}