class Solution {

    public int minOperations(String s, int k) {

        // Step 1: Get length of string
        int n = s.length();

        // Step 2: Count how many zeros exist in the string initially
        // This is our starting state
        int startZeros = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                startZeros++;
            }
        }

        // Step 3: If there are no zeros, string already contains all '1'
        // So no operations are needed
        if (startZeros == 0) {
            return 0;
        }

        // Step 4: Create an array to store minimum operations needed
        // operations[z] = minimum operations required to reach z zeros
        int[] operations = new int[n + 1];

        // Initialize all values as -1 meaning "not visited yet"
        Arrays.fill(operations, -1);

        // Step 5: Create two TreeSets
        // evenSet will store all even zero counts
        // oddSet will store all odd zero counts
        // TreeSet helps us quickly find valid next states in sorted order
        TreeSet<Integer> evenSet = new TreeSet<>();
        TreeSet<Integer> oddSet = new TreeSet<>();

        // Step 6: Fill TreeSets with all possible zero counts from 0 to n
        for (int count = 0; count <= n; count++) {

            if (count % 2 == 0) {
                evenSet.add(count);
            } else {
                oddSet.add(count);
            }
        }

        // Step 7: Create a queue for BFS (Breadth First Search)
        // BFS ensures minimum operations are found first
        Queue<Integer> queue = new LinkedList<>();

        // Add starting state (initial zero count)
        queue.offer(startZeros);

        // It takes 0 operations to reach starting state
        operations[startZeros] = 0;

        // Remove starting state from TreeSet because it is now visited
        if (startZeros % 2 == 0) {
            evenSet.remove(startZeros);
        } else {
            oddSet.remove(startZeros);
        }

        // Step 8: Start BFS traversal
        while (!queue.isEmpty()) {

            // Get current number of zeros
            int z = queue.poll();

            // Step 9: Calculate minimum possible zeros after flip
            // This formula comes from flipping substring of length k
            int minNewZ = z + k - 2 * Math.min(k, z);

            // Step 10: Calculate maximum possible zeros after flip
            int maxNewZ = z + k - 2 * Math.max(0, k - n + z);

            // Step 11: Choose correct TreeSet based on even or odd parity
            TreeSet<Integer> currSet;

            if (minNewZ % 2 == 0) {
                currSet = evenSet;
            } else {
                currSet = oddSet;
            }

            // Step 12: Find first valid number >= minNewZ
            Integer val = currSet.ceiling(minNewZ);

            // Step 13: Process all valid zero counts in range [minNewZ, maxNewZ]
            while (val != null && val <= maxNewZ) {

                int newZ = val;

                // Step 14: Update minimum operations required
                // It takes one more operation than current state
                operations[newZ] = operations[z] + 1;

                // Step 15: If zero zeros reached, return answer
                // This means all characters are now '1'
                if (newZ == 0) {
                    return operations[newZ];
                }

                // Step 16: Add new state to queue to explore further
                queue.offer(newZ);

                // Step 17: Remove this state from TreeSet so it is not visited again
                currSet.remove(val);

                // Step 18: Find next valid value in TreeSet
                val = currSet.ceiling(minNewZ);
            }
        }

        // Step 19: If we cannot reach zero zeros, return -1
        // Means it is impossible
        return -1;
    }
}