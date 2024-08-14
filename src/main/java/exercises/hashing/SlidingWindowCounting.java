package exercises.hashing;

import java.util.HashMap;
import java.util.HashSet;

/*
Example 1: You are given a string s and an integer k. Find the length of the longest substring that contains at most k distinct characters.

For example, given s = "eceba" and k = 2, return 3. The longest substring with at most 2 distinct characters is "ece".

 */
public class SlidingWindowCounting {
    public int findLongestSubstring(final String s) {
        var left = 0;
        final var characters = new HashMap<Character, Integer>();
        var distinctCharacters = 0;
        var result = 0;

        for (int right = 0; right < s.length(); right++) {
            final var character = s.charAt(right);
            var count = characters.get(character);
            if (count == null || count == 0) {
                distinctCharacters++;
                count = 1;
            }
            characters.put(character, count);

            while (distinctCharacters > 2) {
                final var leftChar = s.charAt(left);
                var leftCount = characters.get(leftChar);
                characters.put(leftChar, --leftCount);
                left++;
                if (leftCount == 0) {
                    distinctCharacters--;
                }
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        final var sut = new SlidingWindowCounting();
        final var result = sut.findLongestSubstring("eceba");

        System.out.println(result);
    }
}
