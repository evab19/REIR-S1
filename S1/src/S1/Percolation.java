package S1;

public class Percolation {
    public Percolation(int N){

    }

    public void open(int row, int col) {
        System.out.println("Trying to open " + row + ", " + col);
    }

    public boolean isOpen(int row, int col) {
        if (row==2) {
            return true;
        }
        return false;
    }

    public boolean isFull(int row, int col) {
        return false;
    }

    public int numberOfOpenSites() {
        return 0;
    }

    public boolean percolates() {
        return false;
    }

    public static void main(String[] args) {

    }
}
