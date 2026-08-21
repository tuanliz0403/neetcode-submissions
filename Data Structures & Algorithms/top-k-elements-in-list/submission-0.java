class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.put(x, freq.getOrDefault(x, 0) + 1);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for(Map.Entry<Integer, Integer> i:freq.entrySet()){
            pq.offer(new int[]{i.getKey(), i.getValue()});
            if(pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++) res[i] = pq.poll()[0];
        return res;
    }
}
