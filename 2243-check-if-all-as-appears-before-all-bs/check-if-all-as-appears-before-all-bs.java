class Solution {
    public boolean checkString(String s) {
        // Once we find a 'b', no 'a' should appear afterward
        boolean seenB = false;
        
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                seenB = true; // mark that 'b' has appeared
            } else if (seenB && c == 'a') {
                // found 'a' after 'b' => invalid order
                return false;
            }
        }
        
        return true; // all 'a's before 'b's
    }
}
