package org.fransanchez.exercises.hashing;

// 242. Valid Anagram
public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("aaaaaa", "aaaaaa"));
    }

    private static boolean isAnagram(final String s, final String t) {
        if (s.length() != t.length()) {
            return false;
        }

        final var lettersHash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            // Populate letters hash table
            final var letterAnagram = s.charAt(i);
            lettersHash[letterAnagram -'a']++;

            // Subtract letters hash table
            final var letterInput = t.charAt(i);
            lettersHash[letterInput -'a']--;
        }

        // Check that all letters have been used
        for (int hash : lettersHash) {
            if (hash != 0) {
                return false;
            }
        }

        return true;
    }
}
