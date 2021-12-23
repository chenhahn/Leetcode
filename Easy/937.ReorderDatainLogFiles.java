class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myCompare = new Comparator<String>() {
            public int compare(String log1, String log2) {
                String[] splits1 = log1.split(" ", 2);
                String[] splits2 = log2.split(" ", 2);
                
                boolean isDigit1 = Character.isDigit(splits1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(splits2[1].charAt(0));
                
                if(!isDigit1 && !isDigit2) {
                    int cmp = splits1[1].compareTo(splits2[1]);
                    if(cmp == 0) {
                        return splits1[0].compareTo(splits2[0]);
                    } 
                    return cmp;
                }
                if(!isDigit1 && isDigit2) {
                    return -1;
                } else if (isDigit1 && !isDigit2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        Arrays.sort(logs, myCompare);
        return logs;
    }
}
/*	
	Time Complexity: O(M * N * logN)
	~Array.sort() is O(N * logN) <- compare() function would be invoked O(N * logN) times.
	~For each compare() function, it could take up to O(M) times, since we compare the contents of the logs.
	
	Space Complexity: O(M * logN)
	~For each compare() function, we would neet up to O(M) space to hold the parsed logs
	~In addtion, since the implementation of Array.sort() is based on quicksort algorithm whose space complexity is O(log N).
	 Since each log could be of O(M) space, we would need O(M * logN) space to hold the intermediate values for sorting.
	~In total, the overall space complexity of the algorithm is O(M+M*logN)=O(M*logN).
*/