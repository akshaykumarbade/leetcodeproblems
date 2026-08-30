public class ConvertStringToIntegerATOI {
    //convert the given string to 32-bit integer
    //ignoring leading whitespaces.
    //read leading + and - signs and numbers 0-9.
    //stop the read if any non int values comes.
    //eg "-45ab6" will be -45
    // "ab98-45" will be 0.
    // "98bc-9" will be 98.
    // " -98cn08" will be -98.
    // "-abc98" will be 0.

    public static void main(String[] args) {
        String s = " -98abc076";
        String s2 = "abc";
        String s3 = " 45bc48t";
        String s4 = "";
        ConvertStringToIntegerATOI c = new ConvertStringToIntegerATOI();
        int result = c.convertToInt(s);
        int result2 = c.convertToInt(s2);
        int result3 = c.convertToInt(s3);
        int result4 = c.convertToInt(s4);
        System.out.println("String : "+ s+ " to int: "+ result);
        System.out.println("String : "+ s2+ " to int: "+ result2);
        System.out.println("String : "+ s3+ " to int: "+ result3);
        System.out.println("String : "+ s4+ " to int: "+ result4);


    }

    private int convertToInt(String s) {
        // i is our pointer to traverse the string
        int i = 0;
        // store the length of string so we don't call length() method again and again.
        int n = s.length();

        //skip the leading whitespaces until we get any other than whitespace.
        while(i<n && s.charAt(i) == ' ') {
            i++;
        }

        //return 0 if the string contains only whitespaces and no numbers.
        if (i == n) {
            return 0;
        }

        //determine the sign of number. default positive
        int sign = 1;
        //if the current character is - then number is negative then change sign to negative and vice versa.
        if(s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        //the number we are building from the string will be stored in result.
        int result = 0;

        //continue reading characters as long as they are digits
        while(i<n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            // Convert the character into an actual integer digit.
            //
            // Example:
            // s.charAt(i) = '7'
            //
            // '7' - '0' = 7
            //
            // This works because digit characters are stored
            // sequentially in Unicode/ASCII.
            int digit = s.charAt(i) - '0';

            //make sure the result won't exceed the java int range.
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit>7)) {
                if(sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            //add the current digit to result.
            // eg. result is 9 and current digit 8 then 9 * 10 = 90 + 8 = 98.
            result = result * 10 + digit;

            //to the next character.
            i++;
        }
        //return the final result with correct sign.
        //eg result is 98 but with sign - then 98 * -1 = -98.
        return result * sign;
    }
}
