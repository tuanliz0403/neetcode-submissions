

/**
 * Encode/Decode a list of strings safely.
 * Format: <len>#<string> repeated. Works with any characters.
 * Time: O(total length). Space: O(total length).
 */
class Solution {
    /** Encode list into one string. */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) sb.append(s.length()).append('#').append(s);
        return sb.toString();
    }

    /** Decode string back into list. */
    public List<String> decode(String str) {
        List<String> out = new ArrayList<>();
        int i = 0, n = str.length();
        while (i < n) {
            int j = i;
            while (str.charAt(j) != '#') j++;              // read length
            int len = Integer.parseInt(str.substring(i, j));
            int start = j + 1;
            out.add(str.substring(start, start + len));    // read payload
            i = start + len;
        }
        return out;
    }
}
