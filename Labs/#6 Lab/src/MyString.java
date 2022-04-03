import java.util.Locale;

public class MyString {
    public static void main(String[] args) {
//        String x = "A man, a plan, a canal: Panama";
//        String Y = "How and you too, for ";
//        System.out.println(encrypt(Y));
//
//        System.out.println(isPalindrome(x));
        System.out.println(encrypt("Hello its great to see you"));
    }
    public static String reverseString(String a){
        StringBuilder reversed = new StringBuilder(a).reverse();
        return reversed.toString();
    }
//    public static boolean isPalindrome(String str) {
//            String newStr = cleanString(str);
//            return newStr.equalsIgnoreCase(reverseString(newStr));
//    }
//    public static String cleanString(String a){
//        String[]tokens = a.split("[!#$:;,.\\-_ ']",0);
//        StringBuilder Clean = new StringBuilder();
//        for (String x : tokens) {
//            x.trim();
//            Clean.append(x);
//        }
//
//        return Clean.toString();
//    }
//    public static String ShortHnaded(String str) {
//        String[] replacment = {"&", "2", "U", "4"};
//        String[] replace = {"and", "to", "you", "for"};
//        for(int i=0;i< replacment.length; i++) {
//            str = str.replaceAll(replace[i],replacment[i]);
//        }
//        String empty = "";
//        String[] splits = str.split(" ",0);
//        for ( String x: splits) {
//            if (x.length() > 1) {
//                x = x.replaceAll("[AOUIEaioue]", "");
//            }
//            empty += x + " ";
//        }
//
//        return empty;
//
//    }
//    public static int numberOfSentences(String str) {
//        String[] splits = str.split("[.,!?]",0);
//        return splits.length;
//    }
//    public static int numberOfWords(String str) {
//        int n = 0;
//        String[] splits = str.split(" ", 0);
//        for (String x : splits)
//            if (splits.length > 3) {
//                n++;
//            }
//        return n;
//    }
    public static String encrypt(String str) {
        str = reverseString(str).toUpperCase();
        String[] replacment = {"0", "\\$", "1"};
        String[] replace = {"O", "S", "L"};
        for(int i=0;i< replacment.length; i++) {
            str = str.replaceAll(replace[i],replacment[i]);
        }

        return "**" + str + "**";
    }

}
