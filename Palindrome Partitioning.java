public class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] isP = new boolean[s.length()][s.length()];
        List<List<String>> result = new LinkedList<List<String>>();
        List<String> curr = new LinkedList<String>();
        calIsP(isP, s);
        process(result, isP, s, curr, 0);
        return result;
    }
    private void process(List<List<String>> result, boolean[][] isP, String s, List<String> curr, int start) {
        if (start == s.length()) {
            result.add(new LinkedList<String>(curr));
        }
        for (int i = start; i < s.length(); i ++) {
            if (isP[start][i] == true) {
                curr.add(s.substring(start, i + 1));
                process(result, isP, s, curr, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
    private void calIsP(boolean[][] isP, String s) {
        for (int i = 0; i < s.length(); i ++) {
            isP[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i ++) {
            isP[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int k = 2; k < s.length(); k ++) {
            for (int i = 0; i + k < s.length(); i ++) {
                isP[i][i + k] = s.charAt(i) == s.charAt(i + k) && isP[i + 1][i + k - 1] == true;
            }
        }
    }
}
