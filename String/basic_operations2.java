
public class basic_operations2 {
    public static void main(String[] args) {
        
        String str = "now is not the time for this";
        // get the index of the first occurence of the specified character in the string
        System.out.println(str.indexOf('i'));
        // get the index of the last occurence of the specified character in the string
        System.out.println(str.lastIndexOf('t'));

        String str2 = "abcdefgh";
        // extract substring from a string by specifying the start index
        String substr1 = str2.substring(3);
        System.out.println(substr1);
        // extract substring from a string by specifying the start index and end index
        String substr2 = str2.substring(4,7);
        System.out.println(substr2);

        String str3 = "hello how do you do";
        // replaces all occurences of one character with another character
        String new_string  = str3.replace('o','a');
        System.out.println(new_string);
    }
}