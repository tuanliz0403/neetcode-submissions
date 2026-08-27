class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length <= 0) return "";
        StringBuilder builder = new StringBuilder();
        int ind = 0;
        while(true){
            Character c = null;
            for(String string : strs){
                if(ind >= string.length()){
                    return builder.toString();
                }
                if(c == null) {
                    c = string.charAt(ind);
                }
                else if(c.compareTo(string.charAt(ind)) != 0){
                    return builder.toString();
                }

            }
                            builder.append(c);
                ind++;
        }
    }
}