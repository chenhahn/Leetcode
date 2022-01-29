class MyHashMap {
    private LinkedList<Entry>[] map;
    private static final int SIZE = 10000;
    
    public MyHashMap() {
        map = new LinkedList[SIZE];
    }
    
    public void put(int key, int value) {
        int index = key % SIZE;
        if(map[index] == null) {
            map[index] = new LinkedList<Entry>();
            map[index].add(new Entry(key, value));
        } else {
            for(Entry entry: map[index]) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
            }
            map[index].add(new Entry(key, value));
        }
    }
    
    public int get(int key) {
        int index = key % SIZE;
        if(map[index] == null) 
            return -1;
        
        for (Entry entry: map[index]) {
            if(entry.key == key)
                return entry.value;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = key % SIZE;
        if(map[index] == null)
            return;
        
        for (Entry entry: map[index]) {
            if(entry.key == key) {
                map[index].remove(entry);
                return;
            }
        }
        return;
    }
    
    class Entry {
        public int key;
        public int value;
        public Entry(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */