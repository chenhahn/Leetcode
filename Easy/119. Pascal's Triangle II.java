class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j+1) + row.get(j));
            }
        }
        return row;
    }
}

// Time complexity: O(n^2)  ->    1+2+3+...+n
// Space complexity: O(n)