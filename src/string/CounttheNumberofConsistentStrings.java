package string;

public class CounttheNumberofConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {

        int[] freq = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            freq[allowed.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            boolean valid = true;

            for (int j = 0; j < s.length(); j++) {
                if (freq[s.charAt(j) - 'a'] == 0) {
                    valid = false;
                    break;
                }
            }


            if (valid) count++;

        }

        return count;

    }
}
