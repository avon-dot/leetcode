package leetcode.editor.cn;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> count = new HashMap<String, Integer>();
//        统计每一个词语的数量
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
//
//        List<String> ans = new ArrayList<String>();
//        for (Map.Entry<String,Integer> entry: count.entrySet()) {
//            ans.add(entry.getKey());
//        }
//
//        ans.sort((o1, o2) ->
//                count.get(o1) == count.get(o2) ? o1.compareTo(o2) :
//                        count.get(o2) - count.get(o1));
//
//        return ans.subList(0,k);
//    }
//        PriorityQueue<Map.Entry<String,Integer>> priorityQueue = new PriorityQueue<>((o1, o2) ->
//                o1.getValue() == o2.getValue()? o2.getKey().compareTo(o1.getKey()):o1.getValue() - o2.getValue());

        PriorityQueue<String> priorityQueue = new PriorityQueue<>((o1, o2) ->
                count.get(o1) == count.get(o2) ? o2.compareTo(o1) : count.get(o1) - count.get(o2));
        for (Map.Entry<String,Integer> entry: count.entrySet()) {
            priorityQueue.offer(entry.getKey());
            if (priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        List<String> ans = new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            ans.add(priorityQueue.poll());
        }

        Collections.reverse(ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
