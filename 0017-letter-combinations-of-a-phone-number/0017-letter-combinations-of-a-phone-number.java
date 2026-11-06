class Solution {
    private void backtrack(int ind, String digits, StringBuilder sb, List<String> ans, String[] mapping){
        if(ind == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letters = mapping[digits.charAt(ind) - '0'];
        for(int i = 0; i<letters.length(); i++){
            char ch = letters.charAt(i);
            sb.append(ch);
            backtrack(ind+1, digits, sb, ans, mapping);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] mapping = {
            " , ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"
        };
        backtrack(0, digits, new StringBuilder(), ans, mapping);
        return ans;
    }
}