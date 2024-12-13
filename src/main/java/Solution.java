import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long findScore(int[] nums) {
        long res = 0L;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]).thenComparing((int[] a) -> a[1]));
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        boolean[] used = new boolean[len];

        while (len != 0) {
            int[] cur = pq.poll();
            if (used[cur[1]]) {
                continue;
            }
            res += cur[0];
            used[cur[1]] = true;
            len--;
            if (cur[1] != 0) {
                if (!used[cur[1] - 1]) {
                    len--;
                }
                used[cur[1] - 1] = true;

            }
            if (cur[1] != nums.length - 1) {
                if (!used[cur[1] + 1]) {
                    len--;
                }
                used[cur[1] + 1] = true;

            }

        }

        return res;
    }
}