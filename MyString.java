

/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        if(str == ""){
            return 0;
        }
        int counter = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ch){
                counter++;
            }
        }
        return counter;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
         if(str1 == null || str2 == null){
            return false;
         }
         if(str1.length()>str2.length()){
            return false;
         }
         char [] arr1 = new char[str1.length()];
         char [] arr2 = new char[str2.length()];
         int counter=0;
         for(int i =0; i< str2.length(); i++){
            arr2[i] = str2.charAt(i);
         }
         for(int i =0; i< str1.length(); i++){
            arr1[i] = str1.charAt(i);
         }
         for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if(arr2[i] == arr1[j]){
                    counter++;
                    arr1[j] = ' ';
                    break;
                }
            }       
         }
         if(counter == str1.length()){
            return true;
         }
        return false;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        if(str == null){
            return " ";
        }
        String spacestr = "";
        for(int i = 0; i<str.length(); i++){
            spacestr += str.charAt(i);
            if(i<str.length()-1){
                spacestr += " ";
            }
        }
        return spacestr;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String str = "";
        for(int i=0; i<n; i++){
            str += (char)((int)(('a' + Math.random()*26)));
        }
        return str;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        String str = "";
        boolean add = true;
        char[] arr = new char[str2.length()];
        for(int i=0;i<str2.length();i++){
            arr[i] = str2.charAt(i);
        }
        for (int i = 0; i < str1.length(); i++) {
            for(int j = 0; j<arr.length; j++){
                if(str1.charAt(i) == arr[j]){
                    arr[j] = ' ';
                    add = false;
                    break;
                }
            }
            if(add){
                str+=str1.charAt(i);
            }
            add = true;
        }
        return str;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
