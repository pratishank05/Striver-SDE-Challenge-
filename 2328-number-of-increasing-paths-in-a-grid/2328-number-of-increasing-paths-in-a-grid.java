class Solution{ 
public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length, mod = (int) (1e9 + 7), ans = 0;
        Integer[][] path = new Integer[m][n], directions = new Integer[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                ans = (ans + dfs(grid, i, j, -1, path, directions, m, n, mod)) % mod;
        return ans;
    }

    private int dfs(int[][] grid, int i, int j, int pre, Integer[][] path, Integer[][] directions, int m, int n, int mod) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] <= pre) return 0; // Invalid
        if (path[i][j] != null) return path[i][j]; // Already explored
        int numPaths = 0;
        for (Integer[] dir : directions)
            numPaths = (numPaths + dfs(grid, i + dir[0], j + dir[1], grid[i][j], path, directions, m, n, mod)) % mod;
        return path[i][j] = (1 + numPaths) % mod; // 1 for the current cell
    }
}