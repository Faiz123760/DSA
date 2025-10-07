import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            while (!st.isEmpty() && a < 0 && st.peek() > 0) {
                if (Math.abs(a) > st.peek()) {
                    st.pop(); // right one smaller → destroyed
                } else if (Math.abs(a) == st.peek()) {
                    st.pop(); // both destroyed
                    destroyed = true;
                    break;
                } else {
                    destroyed = true; // left one destroyed
                    break;
                }
            }

            if (!destroyed) st.push(a);
        }

        // convert stack to array
        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}
