//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.
package assign1;

public class TetrisGrid {
	private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int row = grid.length, col = grid[0].length;
		if (row*col == 0){
			return;
		}
		
		boolean[][] newGrid = new boolean[row][col];

		int k = 0;
		for (int j=0; j<col; j++){
			int flag = 0;
			for (int i=0; i<row; i++){
				if (grid[i][j] == false){
					flag = 1;
				}
			}
//			System.out.println(flag);
			if (flag == 1){
				for (int i=0; i<row; i++){
					newGrid[i][k] = grid[i][j];
				}
				k++;
			}
		}
//		for (int i=0; i<row; i++){
//			for (int j=0; j<col; j++){
//				System.out.format(String.valueOf(newGrid[i][j])+',');
//			}
//			System.out.println();
//		}
		for (int i=0; i<row; i++){
			for (; k<col; k++){
				newGrid[i][k] = false;
			}
		}
		grid = newGrid;
		
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		// return null; // TODO YOUR CODE HERE
		return grid;
	}
}
