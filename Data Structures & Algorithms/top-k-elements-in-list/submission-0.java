class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, 1 + count.getOrDefault(num, 0));
        }

        List<Integer>[] freq = new ArrayList[nums.length + 1];
        for (int num : count.keySet()) {
            int c = count.get(num);
            if (freq[c] == null) {
                freq[c] = new ArrayList<>();
            }
            freq[c].add(num);
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i >= 0; i--) {
            if (freq[i] != null) {
                for (int n : freq[i]) {
                    result[index] = n;
                    index++;
                    if (index == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
