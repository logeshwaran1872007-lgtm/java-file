Public class valid anagram {
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }
        
        // An array to store the character counts for the 26 lowercase English letters
        int[] charCounts = new int[26];
        
        // Increment count for characters in 's' and decrement for 't'
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }
        
        // If any count is not zero, the strings are not anagrams
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}