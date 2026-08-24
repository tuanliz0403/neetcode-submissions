class Solution {
    record Pair(int first, int second){}

    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> line = new Stack();
        ArrayList<Pair> arr = new ArrayList();
        for(int i = 0; i < position.length; i++){
            arr.add(new Pair(position[i], speed[i]));
        }
        arr.sort(Comparator.comparingInt(Pair::first));
        for(Pair pair:arr) {
            double currentTime = (double) (target - pair.first) / pair.second;
            while (!line.isEmpty() && line.peek() <= currentTime) 
            {
                // System.out.printf("Popping %f\n", line.peek());
                line.pop();
            }
            line.push(currentTime);
        }
        return line.size();
    }
}
