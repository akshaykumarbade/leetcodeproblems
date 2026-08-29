public class ReverseIntegerLeetCode {

    public static void main(String[] args) {
        //reverse a 32bit signed integer

        int a = 857357;
        ReverseIntegerLeetCode reverseIntegerLeetCode = new ReverseIntegerLeetCode();
        int b = reverseIntegerLeetCode.reverse(a);
        System.out.println("The reverse of int "+ a+ " is "+ b);
    }

    private int reverse(int x) {
        int res = 0;

        while(x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check for positive overflow before multiplying:
            // 1. If res > Integer.MAX_VALUE / 10, multiplying by 10 overflows.
            // 2. If res == Integer.MAX_VALUE / 10, it overflows if the next digit is > 7.
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            // Check for negative underflow before multiplying:
            // 1. If res < Integer.MIN_VALUE / 10, multiplying by 10 underflows.
            // 2. If res == Integer.MIN_VALUE / 10, it underflows if the next digit is < -8.
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            res = (res * 10) + digit;
        }
        return res;
    }
}
