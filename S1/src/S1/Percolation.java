package S1;


import edu.princeton.cs.algs4.Stopwatch;

public class Percolation {
    private boolean[][] grid;
    private int size;
    private int openSites;
    private Stopwatch sw;
    private WeightedQuickUnionUF wqu;
    private QuickFindUF qf;

    public Percolation(int N){ //creates an N-by-N grid, with all sites blocked
        size = N;
        grid = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                grid[i][j] = false;
            }
        }
    }

    public void open(int row, int col) {
        openSites++;
        grid[row][col] = true;
    }

    public boolean isOpen(int row, int col) { //is the site open?
        return grid[row][col];
    }

    public boolean isFull(int row, int col) { //is the site full?
        return false;
    }

    public int numberOfOpenSites() { //return number of open sites
        System.out.println("Number of open sites: " + openSites);
        return 0;
    }

    public boolean percolates() { //does the system percolate?
        return false;
    }

    public static void main(String[] args) {


    }
}
