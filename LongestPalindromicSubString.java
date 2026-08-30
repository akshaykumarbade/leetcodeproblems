public class LongestPalindromicSubString {

    public static void main(String[] args) {
        //find the longest palindromic substring of the given string.

        String s = "abababaa";

        LongestPalindromicSubString l = new LongestPalindromicSubString();
        String result = l.plindromicString(s);
        System.out.println("The longest palindromic substring in the string: "+s+" is : "+ result);

    }

    private String plindromicString(String s) {
        // If the string is null or has 0/1 character,
        // it is already a palindrome.
        //
        // Example:
        // "a" → palindrome
        // ""  → palindrome
        if( s == null || s.length() < 2) {
            return s;
        }

        // These store the START and END indexes
        // of the longest palindrome found so far.
        //
        // Initially, assume the longest palindrome
        // starts and ends at index 0.
        int start = 0;
        int end = 0;

        // Try every character as a possible CENTER of a palindrome.
        for(int i = 0; i < s.length(); i++) {
            // Case 1: Odd-length palindrome eg. "aba"
            int len1 = expandAroundCenter(s, i, i);
            // Case 2: Even-length palindrome eg. "abba"
            int len2 = expandAroundCenter(s, i, i + 1);

            // Take whichever palindrome is longer: odd-length OR even-length.
            int len = Math.max(len1, len2);

            // Check whether the palindrome we just found is longer than the longest palindrome found so far.
            //
            // Current longest length: end - start + 1
            if(len > end - start + 1) {
                // Calculate the starting index of the palindrome we just found.
                //
                // Example:
                // i = 2
                // len = 5
                //
                // start = 2 - (5 - 1) / 2
                //       = 2 - 2
                //       = 0
                start = i - (len - 1) / 2;

                // Calculate the ending index.
                //
                // Example:
                // i = 2
                // len = 5
                //
                // end = 2 + 5 / 2
                //     = 2 + 2
                //     = 4
                end = i + len / 2;
            }
        }
        // substring() excludes the ending index.
        //
        // Therefore, we use end + 1.
        //
        // Example:
        // start = 1
        // end = 3
        //
        // substring(1, 4)
        // gives indexes 1, 2, 3
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // Keep expanding outward as long as:
        //
        // 1. left hasn't gone outside the string
        // 2. right hasn't gone outside the string
        // 3. characters on both sides are equal
        // Since s[left] == s[right],
        // continue expanding.
        while (left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return right - left - 1;
    }
}
