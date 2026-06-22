// Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement_number = target - nums[i];
            if (map.containsKey(complement_number)){
                return new int[]{map.get(complement_number), i};
            }

            // Construir el map mientras iteramos, para evitar que regrese el mismo índice
            // Si no existe el número en el map entonces lo añadimos
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
