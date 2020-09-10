package S1;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    double[] results;
    int numberOfExperiments;

    public PercolationStats(int N, int T) {
        // perform T independent experiments on an N-by-N grid
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("Illegal Argument!");
        }

        results = new double[T];
        numberOfExperiments = T;

        for (int i=0; i < T; i++){
            Percolation percolation = new Percolation(N);
            while (!percolation.percolates()) {
                percolation.open(StdRandom.uniform(N), StdRandom.uniform(N));
            }
            results[i] = (double)percolation.numberOfOpenSites() / (N*N);
        }
        StdOut.println("Mean: " + mean());
        StdOut.println("Standard deviation: " + stddev());
        StdOut.println("95% confidence interval low: " + confidenceLow());
        StdOut.println("95% confidence interval high: " + confidenceHigh());
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
        return mean() - (1.96 * stddev() / Math.sqrt(numberOfExperiments));
    }

    public double confidenceHigh() {
        return mean() + (1.96 * stddev() / Math.sqrt(numberOfExperiments));
    }
}

