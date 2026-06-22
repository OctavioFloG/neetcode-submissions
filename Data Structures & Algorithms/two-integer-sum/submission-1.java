// Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[]{0,0};
        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }

            // Construir el map mientras iteramos, para evitar que regrese el mismo índice
            // Si no existe el número en el map entonces lo añadimos
            map.put(nums[i], i);
        }
        return result;
    }
}
