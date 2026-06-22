class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // clave = lista de frecuencias (firma del anagrama)
        // valor = lista de palabras que comparten esa firma
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // Construimos la clave de frecuencias
            List<Integer> key = buildKey(word);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word); // añadir la lista de frecuencias como key y el array de palabras como value
        }

        return new ArrayList<>(map.values());
    }

    /**
     * Construye una lista de tamaño 26 con la frecuencia de letras.
     * "eat" -> [1,0,0,0,1,0,...,1]
     */
    private List<Integer> buildKey(String word) {

        List<Integer> freq = new ArrayList<>(26);

        for (int i = 0; i < 26; i++) {
            freq.add(0);
        }

        // Contamos cada letra
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // obtener la posición de la letra
            freq.set(index, freq.get(index) + 1); // coloca la frecuencia en esa posición
        }

        return freq;
    }
}