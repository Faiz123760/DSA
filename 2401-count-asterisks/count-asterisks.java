class Solution {
    public int countAsterisks(String s) {
        int count = 0;
        boolean inside = false; // track if we are inside '|' bars

        for (char c : s.toCharArray()) {
            if (c == '|') {
                inside = !inside; // toggle state
            } else if (c == '*' && !inside) {
                count++;
            }
        }

        return count;
    }
}
