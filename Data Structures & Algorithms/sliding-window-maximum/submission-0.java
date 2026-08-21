 class Solution{
        public int[] maxSlidingWindow(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        int[] result = new int[nums.length - k + 1];
        int l = 0, r = 0;
        while(r < nums.length){
            queue.add(nums[r]);
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);
            if(r - l + 1 == k){
                result[r - k + 1] = queue.peek();
                freq.put(nums[l], freq.getOrDefault(nums[l], 0) - 1);
                while(freq.getOrDefault(queue.peek(), 1) <= 0) queue.poll();
                l++; 
            }
            r++; 
        }
        return result;
    }
 }