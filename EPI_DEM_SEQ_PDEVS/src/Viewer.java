import java.io.FileNotFoundException;
import java.io.PrintStream;

import model.AtomicModel;
import model.Port;

public class Viewer extends AtomicModel {
	Port inDem;
	PrintStream trajectory;
	Data grid[][]; 
	int t;
	public Viewer(int x, int y) {
		super();
		inDem = new Port();
		addInputPort(inDem, "hola");
		
		grid = new Data[x][y];
		try {
			trajectory = new PrintStream("Eftest.csv");
			trajectory.println("Time,Location,Population,Susceptible,Infectious,Recovered");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deltaConf() {
		deltaExt(1);
	}

	@Override
	public void deltaExt(double arg0) {
		for(int p = 0; p< inDem.getEvents().size(); p++) {              
            grid = ((Grid)inDem.getEvents().get(p)).getDataGrid();            
        }    
	}

	@Override
	public void deltaInt() {
		
	}

	@Override
	public void lambda() {
		if(grid[0][0]!=null){
			for(int i = 0; i<grid.length; i++) {
				for(int j = 0; j<grid[i].length; j++) {
					System.out.println(t+ "      "+i + ","+j+"  "  + grid[i][j].toString());  
					trajectory.println(t+ ","+i + ""+j+","  + grid[i][j].toString()); 
				}
			}
			t++;
		}
		
	}

	@Override
	public double ta() {
		return 1;
	}

}
