import java.util.HashMap;

public class LongestSubString {
    //find the longest sub string and it's length without repeating characters.

    public static void main (String[] arg) {
        String s = "akshaykumar";
        LongestSubString l = new LongestSubString();

        String result = l.longestSubString(s);
        int resultLength = result.length();

        System.out.println("The longest subString in String s = "+ s+ " is = "+result+ " with length= "+resultLength);

    }

    private String longestSubString(String s) {
        // Stores each character and the index where we last saw it.
        HashMap<Character, Integer> hashMap = new HashMap<>();

        //Left boundary of our current sliding window.
        //The substring between 'left' and 'right' should have no duplicate characters.
        int left = 0;

        // Stores the length of the longest substring found so far.
        int maxLength = 0;

        //Stores the starting index of the longest substring.
        int startIndex = 0;

        //'right' moves through the string one character at a time.
        for (int right = 0; right < s.length(); right++) {

            // Get the character at the current 'right' position.
            char current = s.charAt(right);

            // Check if we have already seen this character.
            if(hashMap.containsKey(current)) {
                // The character is repeated.
                // We need to move 'left' to a position AFTER the previous occurrence of this character.
                //
                // Example:
                // String:  a k s h a
                // Index:   0 1 2 3 4
                //
                // When right = 4, current = 'a'
                // Previous 'a' was at index 0.
                //
                // Therefore:
                // left = previous index + 1
                //      = 0 + 1
                //      = 1
                //
                // Math.max() makes sure that 'left' NEVER moves
                // backwards.
                left = Math.max(left, hashMap.get(current) + 1);
            }

            // Update the character's position in the HashMap.
            //
            // We always store its MOST RECENT position.
            //
            // Example:
            // First 'a' -> a = 0
            // Later 'a' -> a = 4
            //
            // So now the map contains:
            // a -> 4
            hashMap.put(current, right);

            // Calculate the length of the current window.
            //
            // Example:
            // left = 2
            // right = 8
            //
            // Length = 8 - 2 + 1 = 7
            int currentLength = right - left + 1;

            // Check whether the current substring is longer
            // than the longest substring found so far.
            if (currentLength > maxLength) {
                // Save the new maximum length.
                maxLength = currentLength;
                // Save where this longest substring starts.
                startIndex = left;
            }
        }
        // Extract the longest substring using:
        // starting position + length.
        return s.substring(startIndex, startIndex + maxLength);
    }
}
