class Solution {
    record Interval(int left, int right){};
    public int[][] merge(int[][] intervals) {
        List<Interval> arr = new ArrayList<>();
        for(int[] i: intervals){
            arr.add(new Interval(i[0], i[1]));
        }
        arr.sort(Comparator.comparingInt(Interval::left));
        int ind = 0;
        List<Interval> result = new ArrayList<>();
        while(ind < arr.size()){
            if(result.isEmpty())
            {
                result.add(arr.get(ind));
                ind++;
                continue;
            }
            else if(result.getLast().right >= arr.get(ind).left){
                if (result.getLast().right >= arr.get(ind).right)
                    {
                        ind++;
                        continue;
                    }

                Interval deleted = result.removeLast();
                result.add(new Interval(deleted.left, arr.get(ind).right));
                ind++;
            }
            else{
                result.add(arr.get(ind));
                ind++;
            }
        }
        int[][] arrayResult = new int[result.size()][];
        ind = 0;
        for(Interval interval:result){
            arrayResult[ind++] = new int[]{interval.left, interval.right};
        }
        return arrayResult;
    }
}
