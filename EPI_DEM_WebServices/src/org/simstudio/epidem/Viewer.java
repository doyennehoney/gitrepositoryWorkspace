package org.simstudio.epidem;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.simstudio.model.AtomicModel;
import org.simstudio.model.Grid;
import org.simstudio.model.Port;


public class Viewer extends AtomicModel {
	Port inDem;
	PrintStream trajectory;
	double[][] grid; 
	int t;
	public Viewer(int x, int y, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		inDem = new Port();
		addInputPort(inDem, "hola");
		
		grid = new double [x][y];
		
		try {
			trajectory = new PrintStream("Eftest.csv");
			trajectory.println("Time,Location,Population,Susceptible,Infectious,Recovered");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deltaConf() {
		// TODO Auto-generated method stub
		deltaExt(1);
	}

	@Override
	public void deltaExt(double arg0) {
		// TODO Auto-generated method stub
		
		for(int p = 0; p< inDem.getEvents().size(); p++) {              
            grid = ((Grid)inDem.getEvents().get(p)).getDataGrid();     
			System.out.println(" in VEWER valuesssss "+ inDem.getEvents().get(p));
        }    
	}

	@Override
	public void deltaInt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lambda() {
		//System.out.println("grid empty"+grid[0][0]);
		
		
		if(grid!=null){
			//trajectory.println("Time = "+t); 
			for(int i = 0; i<grid.length; i++) {
				for(int j = 0; j<grid[i].length; j++) {
					//System.out.println(t+ "      "+i + ","+j+"  "  + grid[i][j].toString());  
					trajectory.println(t+ ","+i + ""+j+","  + grid[i][j]); 
				}
			}
			t++;
		}
		
	}

	@Override
	public double ta() {
		// TODO Auto-generated method stub
		return 1;
	}

}
