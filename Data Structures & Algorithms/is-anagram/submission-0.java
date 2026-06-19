//Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> s_map = createMapFromString(s);
        Map<Character, Integer> t_map = createMapFromString(t);

        return s_map.equals(t_map);
    }

    public Map<Character, Integer> createMapFromString(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        return map;
    }
}
