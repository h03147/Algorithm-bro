package part_1.medium.dfs;

public class movingCount_swordOffer13 {

    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int rows, cols;
    private int threshold;
    private int[][] digitSum;
    private int cnt = 0;

    public int movingCount(int m, int n, int k) {
        rows = m;
        cols = n;
        threshold = k;
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked, 0, 0);
        return cnt;
    }

    private void dfs(boolean[][] marked, int r, int c) {
        if(r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c]) {
            return;
        }
        marked[r][c] = true;
        if(digitSum[r][c] > threshold) {
            return;
        }
        cnt++;
        for(int[] d : directions) {
            dfs(marked, r + d[0], c + d[1]);
        }
    }

    private void initDigitSum() {
        int size = Math.max(rows, cols);
        int[] digitOne = new int[size];
        for(int i = 0; i < digitOne.length; ++i) {
            int n = i;
            while(n > 0) {
                digitOne[i] += n % 10;
                n /= 10;
            }
        }
        digitSum = new int[rows][cols];
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                digitSum[i][j] = digitOne[i] + digitOne[j];
            }
        }
    }

}
