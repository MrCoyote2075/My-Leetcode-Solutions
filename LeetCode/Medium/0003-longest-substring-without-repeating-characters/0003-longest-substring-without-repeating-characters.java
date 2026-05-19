class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int l=0;
        int longSub=0;
        HashSet<Character> set=new HashSet<>();
        for(int r=0; r<s.length(); r++){
            char c=s.charAt(r);
            
            while(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            longSub=Math.max(longSub, r-l+1);
        }
        return longSub;
    }
}