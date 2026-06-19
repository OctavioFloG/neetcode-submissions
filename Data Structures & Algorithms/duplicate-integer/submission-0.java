class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num)) return true; // Si ya existe entonces regresa false
        }
        return false;
    }
}