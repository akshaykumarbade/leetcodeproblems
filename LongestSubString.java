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
        HashMap<Character, Integer> hashMap = new HashMap<>();

        int left = 0;
        int maxLength = 0;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if(hashMap.containsKey(current)) {
                left = Math.max(left, hashMap.get(current) + 1);
            }

            hashMap.put(current, right);
            int currentLength = right - left + 1;

            if (currentLength > maxLength) {
                maxLength = currentLength;
                startIndex = left;
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }
}
