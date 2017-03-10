// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

package assign1;

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		//return 0; // TODO ADD YOUR CODE HERE
		int row = grid.length, col = grid[0].length;
		if (row*col == 0){
			return 0;
		}
		int left = col, right = 0, top = row, bottom = 0;
		for (int i=0; i<row; i++){
			for (int j=0; j<col; j++){
				if (grid[i][j] == ch){
					left = Math.min(left, i);
					right = Math.max(right, i);
					top = Math.min(top, j);
					bottom = Math.max(bottom, j);
				}
			}
		}
		if (left>right || top>bottom){
			return 0;
		}
		return (right-left+1)*(bottom-top+1);
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		// return 0; // TODO ADD YOUR CODE HERE
		int row = grid.length, col = grid[0].length;
		if (row*col == 0){
			return 0;
		}
		int result = 0;
		for (int i=1; i<row-1; i++){
			for (int j=1; j<col-1; j++){
				char c = grid[i][j];
				int cnt = 1, flag = 0;
				while (i-cnt>=0 && i+cnt<row && j-cnt>=0 && j+cnt<col){
					if (grid[i-cnt][j]==c && grid[i][j-cnt]==c && grid[i+cnt][j]==c && grid[i][j+cnt]==c){
						flag = 1; // can be a plus
//						System.out.println(flag);
						cnt++;
					}
					else if (grid[i-cnt][j]==c || grid[i][j-cnt]==c || grid[i+cnt][j]==c || grid[i][j+cnt]==c){
						flag = 0; // not a plus
						break;
					}
					else{
						break;
					}
				}
				if (i+cnt<row && grid[i+cnt][j]==c){
					flag = 0;
				}
				if (i-cnt>=0 && grid[i-cnt][j]==c){
					flag = 0;
				}
				if (j+cnt<col && grid[i][j+cnt]==c){
					flag = 0;
				}
				if (j-cnt>=0 && grid[i][j-cnt]==c){
					flag = 0;
				}
				
				if (flag == 1){
					result++;
				}
			}
		}
		return result;
	}
	

	
}
