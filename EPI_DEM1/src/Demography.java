import java.util.Arrays;
import java.util.Random;

import model.AtomicModel;
import model.Port;

public class Demography extends AtomicModel {
	Port gridIn, gridOut;
	Random rand;
	int grid[][];
	Data dataGrid[][];
	int Min = 10, Max = 100;
	int old_pop;
	public Demography(String name, String desc, int x, int y) {
		super();
		
		gridIn = new Port();
		gridOut = new Port();
		
		addInputPort(gridIn, "Inputs");
		addOutputPort(gridOut, "Out_port");
		
		rand = new Random();
		
		dataGrid= new Data[x][y];
		grid = new int[x][y];
		for(int i = 0; i<grid.length; i++) {
			for(int j = 0; j<grid[i].length; j++) {
				grid[i][j] = (int) Math.pow(Min + (int)(Math.random() * ((Max - Min) + 1)), 2);
			}
		}

				
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void deltaConf() {
		// TODO Auto-generated method stub
		deltaInt();deltaExt(1);
		
	}

	@Override
	public void deltaExt(double arg0) {
		// TODO Auto-generated method stub
			/*for(int p = 0; p<gridIn.getEvents().size(); p++) {	
				for(int i=0; i<((Grid)gridIn.getEvents().get(0)).getGrid().length; i++) {
					 for(int j=0; j<((Grid)gridIn.getEvents().get(0)).getGrid()[i].length; j++) {
						grid[i][j] = ((Grid)gridIn.getEvents().get(0)).getGrid()[i][j];
					}
				}
			}*/
		System.out.println("			Demography Grid DeltaExt: Before"+ Arrays.deepToString(grid));
		for(int p = 0; p<gridIn.getEvents().size(); p++) {	
			
			dataGrid = ((Grid)gridIn.getEvents().get(p)).getDataGrid();
			
			
			
		}
		for(int i = 0; i<dataGrid.length; i++) {
			for(int j = 0; j<dataGrid[i].length; j++) {
				System.out.println("Total pop="+ (dataGrid[i][j].getSusceptible()+dataGrid[i][j].getInfected()+dataGrid[i][j].getRecovered()));
			}
		}
		System.out.println("			Demography Grid DeltaExt: After"+ Arrays.deepToString(grid));
	}

	@Override
	public void deltaInt() {
		// TODO Auto-generated method stub
		System.out.println("			Demography Grid DeltaInt: Before"+ Arrays.deepToString(grid));
		if(dataGrid != null){
			for(int i=0; i<grid.length; i++) {
				 for(int j=0; j<grid[i].length; j++) {
					old_pop = grid[i][j];
					System.out.println("			Demography Grid Old_pop: "+ old_pop);
			/**Using Open population with no population density
			* 
			* Birth rate = 0.0009 death rate = 0.00001, immigration = 0.02, emigration =0.01 
					grid[i][j] = (int) (old_pop + (0.02*old_pop)-(0.01*old_pop)+(0.02*old_pop)-(0.01*old_pop)); **/
			/** Using Closed population with no population density
			 * 
			 * **/
					grid[i][j] = (int) Math.round(old_pop+(0.0009*old_pop)-(0.00001*old_pop));
			/** Using Closed population with population density
			 *  k = carrying capacity
			 * 
					int k = 10000;
					grid[i][j] = (int) (((0.02*old_pop)-(0.01*old_pop))*(1 - (old_pop / k)));**/
					
				}
			}
		}	
			System.out.println("			Demography Grid DeltaInt: After"+ Arrays.deepToString(grid));
	}

	@Override
	public void lambda() {
		// TODO Auto-generated method stub
		gridOut.addEvent(new Grid(grid));
		System.out.println("			Demography Grid : "+ Arrays.deepToString(grid) );
	}

	@Override
	public double ta() {
		// TODO Auto-generated method stub
		return 1;
	}

}
