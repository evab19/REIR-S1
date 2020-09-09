package S1;

import java.util.*;

public class Percolation {

    Set<Integer> grid;
    private int size;

    public Percolation(int N){ //creates an N-by-N grid, with all sites blocked
        //boolean array
        size = N;
        grid = new HashSet<>();
    }

    private int encode(int i, int j) { //encodes the sites in the grid to a 1dimensional array
        return 0;
    }

    public void open(int row, int col) {
        grid.add(row * size + col);

    } //open site

    public boolean isOpen(int row, int col) { //is the site open?
        return (grid.contains(row*size + col));
    }

    public boolean isFull(int row, int col) { //is the site full?
        return false;
    }

    public int numberOfOpenSites() { //return number of open sites
        System.out.println("Number of open sites: ");
        return 0;
    }

    public boolean percolates() { //does the system percolate?
        return false;
    }

    public static void main(String[] args) {


    }
}
