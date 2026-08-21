// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> a) {
        if(a.isEmpty()){
            return new ArrayList<List<Pair>>();
        }
        List<List<Pair>> res = new ArrayList<>();
        int n = a.size();
        for(int i = 1; i < n ; i++){
            res.add(new ArrayList<>(a));
            Pair current = a.get(i);
            int j = i;
            while(j > 0 && a.get(j - 1).key > current.key){
                a.set(j, a.get(j - 1));
                j--;
            }
            a.set(j, current);
        }
        res.add(new ArrayList<>(a));
        return res;
    }
}
