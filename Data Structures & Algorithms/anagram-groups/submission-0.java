class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            storeWord(word, map);
        }

        return new ArrayList<>(map.values());
    }

    public String getSortedWord(String word) { // convertir en un anagrama ordenado
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
        // eat -> aet
        // tea -> aet
        // ate -> aet
    }

    public void storeWord(String word, Map<String, List<String>> map) {
        String key = getSortedWord(word); // "eat" -> "aet"

        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(word); // obtiene el arreglo del map al que le pertenece esa key y guarda .add() el valor dentro de ese arreglo
    }
}
