class LRUCache {
    int capacity;
    Map<Integer, Node> cache;
    DoublyLinkedList list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoublyLinkedList();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        list.moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        // Si la key ya existe
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            list.moveToHead(node); // "Recientemente usado" al frente de la fila
            return;
        }

        // Si es una nueva key
        Node node = new Node(key, value);
        cache.put(key, node);
        list.appendToHead(node);

        // Si se llegó al máximo de capacidad
        if(cache.size() > capacity){
            Node lru = list.removeTail();
            cache.remove(lru.key);
        }
    }

}

class DoublyLinkedList { // Para evitar time complexity > O(1) en get y put debemos usar una estructura de datos para colocar la última key usada hasta adelante de una lista
    Node head;
    Node tail;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void appendToHead(Node node) {
        node.prev = null;
        node.next = head;

        if (head != null) head.prev = node;

        head = node;

        if (tail == null) tail = node; // si es el primer nodo añadido
    }

    public void removeNode(Node node){
        if(node == null) return;

        // Por si el nodo está enlazado
        if(node.prev != null){ // si el nodo no es la cabeza
            node.prev.next = node.next;
        } else{
            head = node.next; // si el nodo es la cabeza, pasamos el apuntador head al nodo siguiente
        }

        if(node.next != null){ // si el nodo no es la cola, )
            node.next.prev = node.prev; 
        } else{
            tail = node.prev; // si el nodo es la cola, pasamos el apuntado tail al nodo anterior
        }

        node.prev = null;
        node.next = null;
    }

    public Node removeTail(){
        if(tail == null) return null;
        Node node = tail;
        removeNode(node);
        return node;
    }

    public void moveToHead(Node node){
        if(node == head) return; //evitar trabajo innecesario si queremos mover la cabeza a la cabeza
        removeNode(node);
        appendToHead(node);
    }
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}