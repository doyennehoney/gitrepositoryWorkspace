import model.Events;

public class Grid extends Events {
	Data dataGrid[][];

	public Grid(Data[][] grid) {
		this.dataGrid =grid;
	}

	public Data[][] getDataGrid() {
		return dataGrid;
	}
}
