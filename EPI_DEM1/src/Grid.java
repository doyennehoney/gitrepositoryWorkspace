import model.Events;

public class Grid extends Events {
	int popGrid[][] ;
	Data dataGrid[][];
	

	public Grid(int[][] popGrid) {
		// TODO Auto-generated constructor stub
		this.popGrid = popGrid;
	}

	public Grid(Data[][] grid) {
		// TODO Auto-generated constructor stub
		this.dataGrid =grid;
	}

	public int[][] getPopGrid() {
		// TODO Auto-generated method stub
		return popGrid;
	}


	public Data[][] getDataGrid() {
		return dataGrid;
	}

//	public int length() {
//		// TODO Auto-generated method stub
//		return grid.length;
//	}
//
//	public int length(int i) {
//		// TODO Auto-generated method stub
//		return grid[i].length;
//	}
//
//	public int value(int i, int j) {
//		// TODO Auto-generated method stub
//		return grid[i][j];
//	}

}
