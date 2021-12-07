class RandomizedSet {
    private ArrayList<Integer> numbers;
    private HashMap<Integer, Integer> locations;
    private Random rand = new Random();
    public RandomizedSet() {
        numbers = new ArrayList<Integer>();
        locations = new HashMap<Integer, Integer>();
    }
    
    public boolean insert(int val) {
        if(locations.containsKey(val)){
            return false;
        }
        locations.put(val, numbers.size());
        numbers.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!locations.containsKey(val)){
            return false;
        }
        int location = locations.get(val);
        if(location < numbers.size() - 1){
            int lastNum = numbers.get(numbers.size() - 1);
            numbers.set(location, lastNum);
            locations.put(lastNum, location);
            
        }
        numbers.remove(numbers.size() - 1);
        locations.remove(val);
        return true;
    }
    
    public int getRandom() {
        return numbers.get(rand.nextInt(numbers.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */