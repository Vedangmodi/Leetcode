class Solution {

    public int[] getBiggestThree(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        // try every cell as center
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                // size 0 rhombus -> single cell
                add(set, grid[r][c]);

                // increase rhombus size
                for (int s = 1; r - s >= 0 && r + s < rows &&
                                c - s >= 0 && c + s < cols; s++) {

                    int sum = 0;

                    // walk on 4 edges of diamond
                    for (int k = 0; k < s; k++) {

                        sum += grid[r - s + k][c + k];   // top -> right
                        sum += grid[r + k][c + s - k];   // right -> bottom
                        sum += grid[r + s - k][c - k];   // bottom -> left
                        sum += grid[r - k][c - s + k];   // left -> top
                    }

                    add(set, sum);
                }
            }
        }

        return build(set);
    }

    // keep only 3 biggest values
    private void add(TreeSet<Integer> set, int val) {
        set.add(val);
        if (set.size() > 3)
            set.pollFirst();   // remove smallest
    }

    // convert to array in descending order
    private int[] build(TreeSet<Integer> set) {

        int[] ans = new int[set.size()];
        int i = 0;

        Iterator<Integer> it = set.descendingIterator();
        while (it.hasNext())
            ans[i++] = it.next();

        return ans;
    }
}