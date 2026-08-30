public class PalindromeNumber {

    //check whether the given number is palindrome or not.
    public static void main (String[] args) {
        int a = 121;
        int b = 456;
        int c = 23232;
        PalindromeNumber p = new PalindromeNumber();
        String result = p.palindrome(a) ? "a palindrome": "not a palindrome";
        String result2 = p.palindrome(b) ? "a palindrome": "not a palindrome";
        String result3 = p.palindrome(c) ? "a palindrome": "not a palindrome";
        System.out.println("The number: "+ a+ " is "+ result);
        System.out.println("The number: "+ b+ " is "+ result2);
        System.out.println("The number: "+ c+ " is "+ result3);

    }

    private boolean palindrome(int a) {
        //negative number can not be palindrome.
        if(a < 0) {
            return false;
        }
        //the number ending with 0 can not be palindrome.
        if( a % 10 == 0 && a != 0) {
            return false;
        }

        int reversedHalf = 0;

        //reverse only half of the digit.
        while( a > reversedHalf) {
            //take the last digit of a
            int digit = a % 10;
            // add that digit to reversedHalf
            reversedHalf = reversedHalf * 10 + digit;
            //remove the last digit from a
            a = a / 10;

        }
        //first for even and second for odd numbers.
        return a == reversedHalf || a == reversedHalf / 10;

    }
}
