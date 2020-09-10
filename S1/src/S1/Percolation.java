package S1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import static edu.princeton.cs.algs4.StdRandom.uniform;

public class Percolation {
    private boolean[][] grid;
    private int openSites;
    private Stopwatch sw;
    private WeightedQuickUnionUF wqu;
    private QuickFindUF qf;
    private int N;

    public Percolation(int N){ //creates an N-by-N grid, with all sites blocked
        this.N = N;
        if(N <= 0){
            throw new IllegalArgumentException("Value of N cannot be less than 1");
        }
        grid = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                grid[i][j] = false;
            }
        }
        wqu = new WeightedQuickUnionUF((N*N) + 2);
    }

    public void open(int row, int col) {
        if ((row < 0 || col < 0) && (row >= N-1 || col >= N-1)) {
            throw new IndexOutOfBoundsException("row or column out of bounds");
        };

        int location = encode(row, col);
        int N = grid.length;

        if (!isOpen(row, col)) {
            grid[row][col] = true;
            openSites++;
            if (row > 0) { // not top row
                if (isOpen((row - 1), col)) {
                    union(location, encode((row - 1), col));
                }
            } else { // this is the top row
                union(0, location);
            }

            if (row < (N - 1)) { //if not the bottom row
                if (isOpen((row + 1), col)) {
                    union(location, encode((row + 1), col));
                }
            } else { // is the bottom row
                union(location, (N * N + 1));
            }

            if (col > 0) { // if not left most
                if (isOpen(row, (col - 1))) {
                    union(location, encode(row, col - 1));
                }
            }

            if (col < N - 1) { // if not right most
                if (isOpen(row, (col + 1))) {
                    union(location, encode(row, col + 1));
                }
            }
        }

    }

    private int encode(int row, int col) {
        int N = grid.length;
        int code = (row * N + col + 1);
        return code;
    }

    private void union(int p1, int p2) {
        wqu.union(p1, p2);
    }

    public boolean isOpen(int row, int col) { //is the site open?
        if ((row < 0 || col < 0) && (row >= N-1 || col >= N-1)) {
            throw new IndexOutOfBoundsException("row or column out of bounds");
        };
        return grid[row][col];
    }

    public boolean isFull(int row, int col) { //is the site full?
        if ((row < 0 || col < 0) && (row >= N-1 || col >= N-1)) {
            throw new IndexOutOfBoundsException("row or column out of bounds");
        };
        int location = encode(row, col);
        return wqu.connected(location, 0);
    }

    public int numberOfOpenSites() { //return number of open sites;
        return openSites;
    }

    public boolean percolates() { //does the system percolate?
        int sink = (grid.length* grid.length) + 1;
        return wqu.connected(0,sink);
    }
    //testing
    public static void main(String[] args) {
        Stopwatch time = new Stopwatch();
        PercolationStats percolationtest = new PercolationStats(10,100);
        StdOut.println("Time: " + time.elapsedTime());

        //Percolation percolation = new Percolation(6);

        //StdOut.println("0,0 is open - Should be false: " + percolation.isOpen(0,0));

        //percolation.open(0,0);

        //StdOut.println("0,0 is open - Should now be true: " + percolation.isOpen(0,0));

        // testing out of bounds - should throw an error
        // percolation.open(-3,1);

        //StdOut.println("0,0 is full - should be true: " + percolation.isFull(0,0));

        //percolation.open(3,3);

        //StdOut.println("3,3 is full test - Should be false: " + percolation.isFull(3,3));

        //StdOut.println("Number of open sites: should return 2: " + percolation.numberOfOpenSites());
    }
}
