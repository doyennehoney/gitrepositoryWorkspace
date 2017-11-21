package org.simstudio.epidem;

import org.simstudio.proxy.ContractPackage.Events;

public class Grid {
	Data dataGrid[][];
	double[] dataList;
	Events ev;

	public Grid(Data[][] grid) {
		this.dataGrid =grid;
	}
	public Grid(double[] grid) {
		ev = new Events(grid);
		this.dataList =grid;
	}

	public Data[][] getDataGrid() {
		return dataGrid;
	}
	
	public double[] getDataList() {
		return dataList;
	}
	
}
