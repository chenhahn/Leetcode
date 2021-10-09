class LRUCache {
    private HashMap<Integer, Node> hashmap;
    private final int CACHE_SIZE;
    Node dummyHead = new Node(-1, -1);
    Node dummyTail = new Node(-1, -1);

    public LRUCache(int capacity) {
        hashmap = new HashMap<>();
        CACHE_SIZE = capacity;
    }
    
    public int get(int key) {
        if(!hashmap.containsKey(key)){
            return -1;
        }else{
            Node tempNode = hashmap.get(key);
            remove(tempNode);
            addToHead(tempNode);
            return tempNode.getValue();
        }
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(!hashmap.containsKey(key)){
            if(CACHE_SIZE == hashmap.size()){
                hashmap.remove(dummyTail.pre.getKey());
                remove(dummyTail.pre);
            }
        }else{
            remove(hashmap.get(key));
        }
        addToHead(node);
        hashmap.put(key, node);
    }
    
    private void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        node.pre = null;
    }
    
    private void addToHead(Node node){
        if(dummyHead.next == null){
            dummyHead.next = node;
            node.pre = dummyHead;
            node.next = dummyTail;
            dummyTail.pre = node;
            dummyTail.next = null;
        }else{
            node.next = dummyHead.next;
            dummyHead.next = node;
            node.pre = dummyHead;
            node.next.pre = node;
        }
    }
}

class Node{
    private int key, value;
    Node pre, next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
    
    public int getKey(){
        return key;
    }
    
    public int getValue(){
        return value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */