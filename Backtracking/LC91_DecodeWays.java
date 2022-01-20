class Solution {
    Map<String, String> map;
    int calls = 0;
     List<String> LETTERS = IntStream.range(1, 27).mapToObj(Integer::toString).collect(Collectors.toList());
    
    
    public int numDecodings(String s) {
        
        System.out.println(LETTERS);
        map = new HashMap();
        
        int[] memo = new int[s.length()];
        int res = dfs(0, s, memo);
        System.out.println("calls"+calls);
        return res;
    }
    
    private int dfs(int index, String s, int[] memo) {
        calls++;
        // if we reach end of the string we find valid pattern
        if( index == s.length()) return 1;
        
        if(memo[index] != 0) return memo[index];
        
        
        
        String remaining_str = s.substring(index);
        
        for(String key: LETTERS) {
            if(remaining_str.startsWith(key)) {
                memo[index]+= dfs(index+key.length(), s, memo);
            }
        }
        
        return memo[index];
        
    }
}
