package S1;


import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    public static double[] results;

    public PercolationStats(int N, int T) {
        // perform T independent experiments on an N-by-N grid
        Percolation percTest = new Percolation(N);
        for (int i=0; i < T; i++){
          percTest.percolates();
          results[i] = percTest.numberOfOpenSites();

        }

    }

    public double mean() {
        // sample mean of percolation threshold
        return StdStats.mean(results);

    }

    public double stddev() {
        //sample standard deviation of percolation threshold
        return StdStats.stddev(results);
    }

    public double confidenceLow() {
        // low endpoint og 95% confidence interval
        return 0;
    }

    public double confidenceHigh() {
        // high endpoint of 95% confidence interval
        return 0;
    }
}
